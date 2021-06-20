package sample.Controlers;

public class Table_modul {
    public int id;
    public String class_dtp;
    public String kol_avto;
    public String data;
    public String GPS;
    public String radius;
    public String sost;
    public String Inspector_id;

    public Table_modul(int id, String class_dtp, String kol_avto, String data, String GPS,  String radius, String sost, String Inspector_id) {
        this.id = id;
        this.class_dtp = class_dtp;
        this.kol_avto = kol_avto;
        this.data = data;
        this.GPS = GPS;
        this.radius = radius;
        this.sost = sost;
        this.Inspector_id = Inspector_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_dtp() {
        return class_dtp;
    }

    public void setClass_dtp(String class_dtp) {
        this.class_dtp = class_dtp;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getKol_avto() {
        return kol_avto;
    }

    public void setKol_avto(String kol_avto) {
        this.kol_avto = kol_avto;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public String getInspector_id() {
        return Inspector_id;
    }

    public void setInspector_id(String Inspector_id) {
        this.Inspector_id = Inspector_id;
    }
}
