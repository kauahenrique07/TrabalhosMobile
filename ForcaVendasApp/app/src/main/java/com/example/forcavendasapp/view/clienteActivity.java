package com.example.forcavendasapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.ClienteController;
import com.example.forcavendasapp.model.Cliente;

public class clienteActivity extends AppCompatActivity {

    private EditText edCodigoCliente;
    private EditText edNomeCliente;
    private EditText edCpfCliente;
    private EditText edDtNascCliente;
    private EditText edCodEnderecoCliente;
    private ClienteController clienteController;
    private Button btnSalvarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        setTitle("Cadastrar Cliente");

        edCodigoCliente = findViewById(R.id.editCodigoCliente);
        edNomeCliente = findViewById(R.id.editNomeCliente);
        edCpfCliente = findViewById(R.id.editCpfCliente);
        edDtNascCliente = findViewById(R.id.editDtNascCliente);
        edCodEnderecoCliente = findViewById(R.id.editCodEnderecoCliente);
        btnSalvarCliente = findViewById(R.id.btnSalvarCliente);

        btnSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarCliente();
            }
        });

        clienteController = new ClienteController(this);
    }

    private void salvarCliente() {
        String validacao = clienteController.validaCliente(
                edCodigoCliente.getText().toString(),
                edNomeCliente.getText().toString(),
                edCpfCliente.getText().toString(),
                edDtNascCliente.getText().toString(),
                edCodEnderecoCliente.getText().toString());

        if(!validacao.equals("")){
            if(validacao.contains("Codigo")){
                edCodigoCliente.setError(validacao);
            }
            if(validacao.contains("Nome")){
                edNomeCliente.setError(validacao);
            }
            if(validacao.contains("Cpf")){
                edCpfCliente.setError(validacao);
            }
            if(validacao.contains("Data de Nascimento")){
                edDtNascCliente.setError(validacao);
            }
            if(validacao.contains("Codigo do Endereco")){
                edCodEnderecoCliente.setError(validacao);
            }
        } else {
            if(clienteController.salvarCliente(new Cliente(
                    Integer.parseInt(edCodigoCliente.getText().toString()),
                    edNomeCliente.getText().toString(),
                    edCpfCliente.getText().toString(),
                    edDtNascCliente.getText().toString(),
                    Integer.parseInt(edCodEnderecoCliente.getText().toString()))) > 0) {

                Toast.makeText(this,
                        "Cliente cadastrado com sucesso!!",
                        Toast.LENGTH_LONG).show();
                limparCampos();
            } else {
                Toast.makeText(this,
                        "Erro ao cadastrar Cliente!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void limparCampos() {
        edCodigoCliente.setText("");
        edNomeCliente.setText("");
        edCpfCliente.setText("");
        edDtNascCliente.setText("");
        edCodEnderecoCliente.setText("");
    }
}
