package ucdb.br.testeconexaodb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by drago on 13/08/2017.
 */

public class DB extends _Default implements Runnable{

    private Connection conn;
    private String host  = "", db = "android";
    private String user = "android", pass = "123456";
    private String url = "jdbc:postgresql://%s:$d/$s";
    private int port = 5432;


    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);
        //TODO abrir conexão
        //TODO fechar conexão

    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();

    }
}
