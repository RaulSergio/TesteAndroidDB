package ucdb.br.testeconexaodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by drago on 13/08/2017.
 */

public class DB extends _Default implements Runnable {

    private Connection conn;
    private String host = "192.168.1.6";
    private String db = "android";
    private String user = "android";
    private String pass = "123456";
    private String url = "jdbc:postgresql://%s:$d/$s";
    private int port = 5432;


    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);
        this.conecta();
        this.desconecta();

    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conecta() {
        Thread thread = new Thread(this);
        // a partir do moneto do start, a Thread vai executar o que esta no metodo run
        // e retornar com a conexao ao banco de dados
        thread.start();
        try {
            //aguarda a conclusao do metodo run
            thread.join();
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }

    }

    private void desconecta() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {

            } finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query) {
        this.conecta();
        ResultSet resultset = null;
        try {                      //instanciando     //executando doInBackgorund   //espera o retorno
            ResultSet resultSet = new ExecuteDB(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultset;


    }public ResultSet execute(String query) {
        this.conecta();
        ResultSet resultset = null;
        try {                      //instanciando     //executando doInBackgorund   //espera o retorno
            ResultSet resultSet = new ExecuteDB(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultset;
    }
}
