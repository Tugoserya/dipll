package sample.connection_sql;

public class Config {
    protected String dbHost="localhost";
    protected String dbPort="3306";
    protected String dbUser="root";
    protected String dbPass="lalala";
    protected String dbName="Diplom";

    public void Config(){
        if(!Const.AUTH){
            dbUser="auth";
            dbPass="auth";
        }
        else{
            if(Const.INST){
                dbUser="ins";
                dbPass="ins";
            }else{
                dbUser="ob";
                dbPass="ob";
            }
        }
    }

}

