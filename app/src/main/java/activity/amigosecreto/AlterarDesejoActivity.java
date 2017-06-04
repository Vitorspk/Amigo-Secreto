package activity.amigosecreto;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import activity.amigosecreto.db.Desejo;
import activity.amigosecreto.db.DesejoDAO;

/**
 * Created by HP on 21/06/2015.
 */
public class AlterarDesejoActivity extends Activity {

    private Desejo old_desejo;
    private Desejo new_desejo;

    private EditText et_produto;
    private EditText et_categoria;
    private EditText et_preco_minimo;
    private EditText et_preco_maximo;
    private EditText et_lojas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_desejo);
        old_desejo = (Desejo) getIntent().getExtras().get("desejo");
        et_produto = (EditText) findViewById(R.id.et_produto);
        et_categoria = (EditText) findViewById(R.id.et_categoria);
        et_preco_minimo = (EditText) findViewById(R.id.et_preco_minimo);
        et_preco_maximo = (EditText) findViewById(R.id.et_preco_maximo);
        et_lojas = (EditText) findViewById(R.id.et_lojas);
        et_produto.setText(old_desejo.getProduto());
        et_categoria.setText(old_desejo.getCategoria());
        et_preco_minimo.setText(""+old_desejo.getPrecoMinimo());
        et_preco_maximo.setText(""+old_desejo.getPrecoMaximo());
        et_lojas.setText(old_desejo.getLojas());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alterar_desejo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_salvar:
                alterar();
                setResult(DetalheDesejoActivity.RESULT_SAVE);
                finish();
                return true;
            case R.id.menu_excluir:
                remover();
                setResult(DetalheDesejoActivity.RESULT_REMOVE);
                finish();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void remover() {
        try {
            DesejoDAO dao = new DesejoDAO(this);
            dao.open();
            dao.remover(old_desejo);
            dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void alterar() {
        try {
            DesejoDAO dao = new DesejoDAO(this);
            dao.open();
            new_desejo = new Desejo();
            new_desejo.setId(old_desejo.getId());
            new_desejo.setProduto(et_produto.getEditableText().toString().trim());
            new_desejo.setCategoria(et_categoria.getEditableText().toString().trim());
            new_desejo.setPrecoMinimo(Double.parseDouble(et_preco_minimo.getEditableText().toString().trim()));
            new_desejo.setPrecoMaximo(Double.parseDouble(et_preco_maximo.getEditableText().toString().trim()));
            new_desejo.setLojas(et_lojas.getEditableText().toString().trim());
            dao.alterar(old_desejo, new_desejo);
            dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
