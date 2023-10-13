package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.EnderecoController;
import com.example.forcavendasapp.model.Endereco;

public class enderecoActivity extends AppCompatActivity {

    private EditText edCodigoEndereco;
    private EditText edLogradouro;
    private EditText edNumero;
    private EditText edBairro;
    private EditText edCidade;
    private EditText edUf;
    private EnderecoController enderecoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        setTitle("Cadastrar Endereço");

        edCodigoEndereco = findViewById(R.id.editCodigoEndereco);
        edLogradouro = findViewById(R.id.editLogradouro);
        edNumero = findViewById(R.id.editNumero);
        edBairro = findViewById(R.id.editBairro);
        edCidade = findViewById(R.id.editCidade);
        edUf = findViewById(R.id.editUF);

        enderecoController = new EnderecoController(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnInflater = getMenuInflater();
        mnInflater.inflate(R.menu.menu_padrao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSalvar) {
            salvarEndereco();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvarEndereco() {
        String validacao = enderecoController.validaEndereco(
                edCodigoEndereco.getText().toString(),
                edLogradouro.getText().toString(),
                edNumero.getText().toString(),
                edBairro.getText().toString(),
                edCidade.getText().toString(),
                edUf.getText().toString());

        if(!validacao.equals("")){
            if(validacao.contains("Codigo")){
                edCodigoEndereco.setError(validacao);
            }
            if(validacao.contains("Logradouro")){
                edLogradouro.setError(validacao);
            }
            if(validacao.contains("Numero")){
                edNumero.setError(validacao);
            }
            if(validacao.contains("Bairro")){
                edBairro.setError(validacao);
            }
            if(validacao.contains("Cidade")){
                edCidade.setError(validacao);
            }
            if(validacao.contains("Uf")){
                edUf.setError(validacao);
            }
        } else {
            if(enderecoController.salvarEndereco(new Endereco(
                    Integer.parseInt(edCodigoEndereco.getText().toString()),
                    edLogradouro.getText().toString(),
                    Integer.parseInt(edNumero.getText().toString()),
                    edBairro.getText().toString(),
                    edCidade.getText().toString(),
                    edUf.getText().toString())) > 0) {

                Toast.makeText(this,
                        "Endereço cadastrado com sucesso!!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                        "Erro ao cadastrar Endereço!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
