package ucdb.br.testeconexaodb;

/**
 * Created by drago on 13/08/2017.
 */

public class Usuario extends _Default {
    private int id;
    private String nome, email, telefone;

    public Usuario(String _mensagem, boolean _status) {
        super();
        this.id = -1;
        this.email = "";
        this.nome = "";
        this.telefone = "";

    }

    //TODO implementar GetUsuarios, Salvar e Apagar
}
