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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.PedidoVendaController;

public class pedidoVendaActivity extends AppCompatActivity {

    private Spinner spinnerCliente, spinnerItemVenda, spinnerCondicaoPagamento, spinnerEnderecoEntrega;
    private EditText edtQuantidade, edtQuantidadeParcelas;
    private TextView txtValorUnitario, txtUnidadeMedida, txtValorTotal, txtTotalItens, txtValorTotalFinal;
    private Button btnAdicionarItem, btnConcluirPedido;
    private ListView listItensPedido, listParcelas;
    private PedidoVendaController pedidoVendaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidovenda);
        setTitle("Cadastrar Pedido de Venda");

        // Inicializando os componentes
        spinnerCliente = findViewById(R.id.spinnerCliente);
        spinnerItemVenda = findViewById(R.id.spinnerItemVenda);
        spinnerCondicaoPagamento = findViewById(R.id.spinnerCondicaoPagamento);
        spinnerEnderecoEntrega = findViewById(R.id.spinnerEnderecoEntrega);
        edtQuantidade = findViewById(R.id.edtQuantidade);
        edtQuantidadeParcelas = findViewById(R.id.edtQuantidadeParcelas);
        txtValorUnitario = findViewById(R.id.txtValorUnitario);
        txtUnidadeMedida = findViewById(R.id.txtUnidadeMedida);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        txtTotalItens = findViewById(R.id.txtTotalItens);
        txtValorTotalFinal = findViewById(R.id.txtValorTotalFinal);
        btnAdicionarItem = findViewById(R.id.btnAdicionarItem);
        btnConcluirPedido = findViewById(R.id.btnConcluirPedido);
        listItensPedido = findViewById(R.id.listItensPedido);
        listParcelas = findViewById(R.id.listParcelas);

        pedidoVendaController = new PedidoVendaController(this);

        // Definindo listeners
        btnAdicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implementar lógica para adicionar item ao pedido
            }
        });

        btnConcluirPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implementar lógica para concluir o pedido
            }
        });
    }


}
