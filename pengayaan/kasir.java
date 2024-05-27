package pengayaan;
import java.util.Scanner;

public class kasir {
    private meja[] daftarmeja;
    private menu[] daftarmenu;

    public kasir() {
        daftarmeja = new meja[10];
        for (int i = 0; i < 10; i++) {
            daftarmeja[i] = new meja(i + 1);
        }

        daftarmenu = new menu[5];
        daftarmenu[0] = new menu("Nasi Goreng", 15000);
        daftarmenu[1] = new menu("Mi Goreng", 15000);
        daftarmenu[2] = new menu("Capcay", 20000);
        daftarmenu[3] = new menu("Bihun Goreng", 17000);
        daftarmenu[4] = new menu("Ayam Koloke", 25000);
    }

    public void tampilkanDaftarMeja() {
        for (int i = 0; i < daftarmeja.length; i++) {
            if (daftarmeja[i].isKosong()) {
                System.out.println("- Meja " + (i + 1) + " (kosong)");
            } else {
                System.out.println("- Meja " + (i + 1) + " (ada pelanggan)");
            }
        }
    }

    public void tambahPelanggan(int nomorMeja, pelanggan pelanggan) {
        if (daftarmeja[nomorMeja - 1].isKosong()) {
            daftarmeja[nomorMeja - 1].setPelanggan(pelanggan);
            System.out.println("Pelanggan " + pelanggan.getNama() + " telah duduk di meja " + nomorMeja);
        } else {
            System.out.println("Gagal menambahkan pelanggan, meja " + nomorMeja + " sudah ada pelanggan");
        }
    }
    
    // menambah pesanan menu pada nomor meja
    // jika menu tidak ada dalam daftar maka tampilkan "Menu is null" 
    public void tambahPesanan(int nomorMeja, menu menu) {
        if (!daftarmeja[nomorMeja - 1].isKosong()) {
            daftarmeja[nomorMeja - 1].setMenu(menu);
            System.out.println("Pesanan " + menu.getNama() + " telah ditambahkan ke meja " + nomorMeja);
        } else {
            System.out.println("Meja " + nomorMeja + " kosong, tidak dapat menambahkan pesanan");
        }
    }

    // Menghapus pelanggan 
    public void hapusPelanggan(int nomorMeja) {
        if (!daftarmeja[nomorMeja - 1].isKosong()) {
            daftarmeja[nomorMeja - 1].setPelanggan(null);
            System.out.println("Pelanggan di meja " + nomorMeja + " telah dihapus");
        } else {
            System.out.println("Meja " + nomorMeja + " kosong, tidak ada pelanggan yang dihapus");
        }
    }

    public int hitungHargaPesanan(int nomorMeja) {
        int totalHarga = 0;
        meja meja = daftarmeja[nomorMeja - 1];
        pelanggan pelanggan = meja.getPelanggan();
        menu[] menu = meja.getMenu();
        if (pelanggan != null && menu != null && menu.length > 0) {
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] != null) {
                    totalHarga += menu[i].getHarga();
                }
            }
            return totalHarga;
        }
        return totalHarga;
    }

    public void tampilkanPesanan(int nomorMeja) {
        meja meja = daftarmeja[nomorMeja - 1];
        pelanggan pelanggan = meja.getPelanggan();
        menu[] menu = meja.getMenu();
        if (pelanggan != null && menu != null && menu.length > 0) {
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] != null) {
                    System.out.println("Meja " + nomorMeja + " - " + pelanggan.getNama() + " memesan " + menu[i].getNama() + " seharga " + menu[i].getHarga());
                }
            }
        } else {
            System.out.println("Meja " + nomorMeja + " tidak memiliki pesanan");
        }
    }    

    public void tampilkanDaftarMenu() {
        System.out.println("Daftar Menu:");
        System.out.println("1. Nasi Goreng - Rp15.000");
        System.out.println("2. Mi Goreng - Rp15.000");
        System.out.println("3. Capcay - Rp20.000");
        System.out.println("4. Bihun Goreng - Rp17.000");
        System.out.println("5. Ayam Koloke - Rp25.000");
        System.out.println("6. Simpan");
        System.out.println();
    }

    public void tampilkanDaftarFitur() {
        System.out.println("1. Tampilkan daftar meja");
        System.out.println("2. Tambah pelanggan");
        System.out.println("3. Tambah pesanan");
        System.out.println("4. Hapus pelanggan");
        System.out.println("5. Hitung harga pesanan");
        System.out.println("6. Tampilkan pesanan di meja");
        System.out.println("0. Keluar");
    }

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;
        while (pilihan != 0) {
            tampilkanDaftarFitur();
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  
            switch (pilihan) {
                case 1:
                    System.out.println("Daftar Meja:");
                    tampilkanDaftarMeja();
                    break;
                case 2:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMeja = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    pelanggan pelanggan = new pelanggan(namaPelanggan);
                    tambahPelanggan(nomorMeja, pelanggan);
                    break;
                case 3:
                boolean stopLoop = false;
                System.out.print("Masukkan nomor meja: ");
                int nomorMejaPesan = scanner.nextInt();
                Boolean meja = daftarmeja[nomorMejaPesan - 1].isKosong();
                scanner.nextLine();  
                if (!meja) {
                    tampilkanDaftarMenu();
                    while (!stopLoop) {
                        System.out.print("Masukkan nomor menu: ");
                        int nomorMenuPesan = scanner.nextInt();
                        scanner.nextLine();  
                        switch (nomorMenuPesan) {
                            case 1:
                                tambahPesanan(nomorMejaPesan, daftarmenu[0]);
                                break;
                            case 2:
                                tambahPesanan(nomorMejaPesan, daftarmenu[1]);
                                break;
                            case 3:
                                tambahPesanan(nomorMejaPesan, daftarmenu[2]);
                                break;
                            case 4:
                                tambahPesanan(nomorMejaPesan, daftarmenu[3]);
                                break;
                            case 5:
                                tambahPesanan(nomorMejaPesan, daftarmenu[4]);
                                break;
                            case 6:
                                System.out.println("Pesanan berhasil disimpan");
                                stopLoop = true;
                                break;
                            default:
                                System.out.println("Nomor menu tidak valid");
                                break;
                        }
                    }
                }
                else {
                    System.out.println("Meja tidak ada pelanggan");
                }
                break;
                case 4:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaHapus = scanner.nextInt();
                    hapusPelanggan(nomorMejaHapus);
                    break;
                case 5: 
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaHitung = scanner.nextInt();
                    int totalHarga = hitungHargaPesanan(nomorMejaHitung);
                    if (totalHarga > 0) {
                        System.out.println("Total harga pesanan di meja " + nomorMejaHitung + " adalah Rp" + totalHarga);
                    } else {
                        System.out.println("Belum ada pesanan di meja " + nomorMejaHitung);
                    }
                    break;
                case 6:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaTampilkan = scanner.nextInt();
                    tampilkanPesanan(nomorMejaTampilkan);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi kasir restoran!");
                    break;
                default:
                System.out.println("Pilihan tidak valid");
                break;
        }
        System.out.println();
    }
    scanner.close();
    }
}