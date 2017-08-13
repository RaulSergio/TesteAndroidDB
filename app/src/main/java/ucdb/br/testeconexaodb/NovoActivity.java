package ucdb.br.testeconexaodb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovoActivity extends AppCompatActivity {

    private Usuario usuario;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        this.usuario = new Usuario();
        this.editTextNome = (EditText)findViewById(R.id.editTextNome);
        this.editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        this.editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);

        Intent it = getIntent();
        if(it!=null){
            Bundle bundle = it.getExtras();
            //se o bundle nao vir nulo entao é edição
            if(bundle!=null){
                this.usuario.setId(bundle.getInt("id"));
                this.editTextNome.setText(bundle.getString("nome"));
                this.editTextEmail.setText(bundle.getString("email"));
                this.editTextTelefone.setText(bundle.getString("telefone"));

            }
        }
    }

    public void salvar (View view){
        this.usuario.setNome(this.editTextNome.getText().toString());
        this.usuario.setEmail(this.editTextEmail.getText().toString());
        this.usuario.setTelefone(this.editTextTelefone.getText().toString());
        this.usuario.salvar();

        Toast.makeText(this,this.usuario.get_mensagem(),Toast.LENGTH_LONG).show();
        if(usuario.is_status()){
            finish();
        }else{

        }
    }

    public void cancelar (View view){ finish();}
}
