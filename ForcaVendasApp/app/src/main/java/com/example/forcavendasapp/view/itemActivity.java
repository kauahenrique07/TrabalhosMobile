package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.ItemController;
import com.example.forcavendasapp.model.Item;

public class itemActivity extends AppCompatActivity {

    private EditText edCodigoItem;
    private EditText edDescricaoItem;
    private EditText edVlrUnitarioItem;
    private EditText edUnMedidaItem;
    private ItemController itemController;
    private Button btnSalvarItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        setTitle("Cadastrar Item");

        edCodigoItem = findViewById(R.id.editCodigoItem);
        edDescricaoItem = findViewById(R.id.editDescricaoItem);
        edVlrUnitarioItem = findViewById(R.id.editVlrUnitItem);
        edUnMedidaItem = findViewById(R.id.editUnMedidaItem);
        btnSalvarItem = findViewById(R.id.btnSalvarItem);

        btnSalvarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarItem();
            }
        });

        itemController = new ItemController(this);
    }

    private void salvarItem() {
        String validacao = itemController.validaItem(
                edCodigoItem.getText().toString(),
                edDescricaoItem.getText().toString(),
                edVlrUnitarioItem.getText().toString(),
                edUnMedidaItem.getText().toString());

        if(!validacao.equals("")){
            if(validacao.contains("Codigo")){
                edCodigoItem.setError(validacao);
            }
            if(validacao.contains("Descrição")){
                edDescricaoItem.setError(validacao);
            }
            if(validacao.contains("Valor Unitário")){
                edVlrUnitarioItem.setError(validacao);
            }
            if(validacao.contains("Unidade de Medida")){
                edUnMedidaItem.setError(validacao);
            }
        } else {
            int codigo = Integer.parseInt(edCodigoItem.getText().toString());
            String descricao = edDescricaoItem.getText().toString();
            int vlrUnitario = Integer.parseInt(edVlrUnitarioItem.getText().toString());
            String unMedida = edUnMedidaItem.getText().toString();

            Item item = new Item(codigo, descricao, vlrUnitario, unMedida);

            if(itemController.salvarItem(item) > 0) {
                Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();
            } else {
                Toast.makeText(this, "Erro ao cadastrar item!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void limparCampos() {
        edCodigoItem.setText("");
        edDescricaoItem.setText("");
        edVlrUnitarioItem.setText("");
        edUnMedidaItem.setText("");
    }
}