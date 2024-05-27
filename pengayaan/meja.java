package pengayaan;
public class meja {
    private int nomorMeja;
    private pelanggan pelanggan;
    private menu[] menu;

    public meja(int nomorMeja) {
        this.nomorMeja = nomorMeja;
        this.menu = new menu[10]; // maksimum 10 pesanan per meja
    }

    public int getNomorMeja() {
        return nomorMeja;
    }

    public void setNomorMeja(int nomorMeja) {
        this.nomorMeja = nomorMeja;
    }

    public pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public menu[] getMenu() {
        return menu;
    }

    public void setMenu(menu menu) {
        boolean pesananDitambahkan = false;
        for (int i = 0; i < this.menu.length; i++) {
            if (this.menu[i] == null) {
                this.menu[i] = menu;
                pesananDitambahkan = true;
                break;
            }
        }
        if (!pesananDitambahkan) {
            System.out.println("Maaf, tidak dapat menambahkan pesanan lagi. Sudah mencapai batas maksimum 10 pesanan.");
        }
    }
    
    // untuk mengecek apakah meja kosong
    public boolean isKosong() {
        return pelanggan == null;
    }
}
