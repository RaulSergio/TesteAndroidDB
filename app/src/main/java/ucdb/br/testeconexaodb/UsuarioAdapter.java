package ucdb.br.testeconexaodb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drago on 13/08/2017.
 */

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Usuario itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_lista, null);
        final View layout = convertView;

        TextView textViewNome = (TextView) convertView.findViewById(R.id.TextViewNome);
        textViewNome.setText(itemPosicao.getNome());

        TextView textViewEmail = (TextView) convertView.findViewById(R.id.TextViewEmail);
        textViewEmail.setText(itemPosicao.getNome());

        TextView textViewTelefone = (TextView) convertView.findViewById(R.id.TextViewTelefone);
        textViewTelefone.setText(itemPosicao.getNome());

        Button buttonEditar = (Button) convertView.findViewById(R.id.botaoEditar);
        buttonEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

            public void Onclick(View v) {
                Intent it = new Intent(context, NovoActivity.class);
                it.putExtra("telefone", itemPosicao.getTelefone());
                it.putExtra("email", itemPosicao.getEmail());
                it.putExtra("nome", itemPosicao.getNome());
                it.putExtra("id", itemPosicao.getId());
                context.startActivity(it);
            }

        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.botaoApagar);
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPosicao.apagar();
                if (itemPosicao._status)
                    layout.setVisibility(View.GONE);
                else
                    Toast.makeText(context, itemPosicao.get_mensagem(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
