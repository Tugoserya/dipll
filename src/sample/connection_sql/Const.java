package sample.connection_sql;

public class Const {


    /**
     * Таблица viewer
     */
    public static final String VIEWER_TABLE = "viewer";
    public static final String VIEWER_ID = "id_view";
    public static final String VIEWER_PASSPORT = "passport";
    public static final String VIEWER_NAME = "name";
    public static final String VIEWER_LAST_NAME = "last_name";
    public static final String VIEWER_LOGIN = "login";
    public static final String VIEWER_PASSWORD = "pass";
    public static final String VIEWER_PATRONYMIC = "patronymic";
    public static final String VIEWER_STATUS = "status";
    /**
     * Таблица inspector
     */
    public static final String INSPECTOR_TABLE = "inspector";
    public static final String INSPECTOR_ID = "id_ins";
    public static final String INSPECTOR_ID_CARD = "id_card";
    public static final String INSPECTOR_NAME = "name";
    public static final String INSPECTOR_LAST_NAME = "last_name";
    public static final String INSPECTOR_LOGIN = "login";
    public static final String INSPECTOR_PASSWORD = "pass";
    public static final String INSPECTOR_PATRONYMIC = "patronymic";
    public static final String INSPECTOR_STATUS = "status";
    /**
     * Таблица car_dtp
     */

    public static final String CAR_DTP_TABLE = "car_dtp";
    public static final String CAR_DTP_ID = "id_car";
    public static final String CAR_DTP_GOS = "gos_nomer";
    public static final String CAR_DTP_VIN = "vin";
    public static final String CAR_DTP_MARCA = "marca";
    public static final String CAR_DTP_CAR_ID = "dtp_id";
    public static final String CAR_DTP_COL = "dtp_col";

    /**
     * Таблица dtp
     */
    public static final String DTP_TABLE = "dtp";
    public static final String DTP_ID = "id";
    public static final String DTP_CLASS_DTP = "class_dtp";
    public static final String DTP_KOLO_AVTO = "kolo_avto";
    public static final String DTP_DATA = "data";
    public static final String DTP_GPS = "GPS";
    public static final String DTP_RADIUS = "radius";
    public static final String DTP_SOST = "sost";
    public static final boolean AUTH = false;
    public static final boolean INST = false;


    public static int id_user;
    public static int status;
    public static int dtp = 0;
    public static int car_dtp_id = 0;
    public static int vin = 0;
}
