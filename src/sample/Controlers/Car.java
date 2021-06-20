package sample.Controlers;


public class Car {

    public int id;
    public String gos_nomer;
    public String vin;
    public String marca;
    public int dtp_col;

    public Car(int id, String gos_nomer, String vin, String marca, int dtp_col) {
        this.id = id;
        this.gos_nomer = gos_nomer;
        this.vin = vin;
        this.marca = marca;
        this.dtp_col = dtp_col;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGos_nomer() {
        return gos_nomer;
    }

    public void setGos_nomer(String gos_nomer) {
        this.gos_nomer = gos_nomer;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDtp_col() {
        return dtp_col;
    }

    public void setDtp_col(int dtp_col) {
        this.dtp_col = dtp_col;
    }
}
