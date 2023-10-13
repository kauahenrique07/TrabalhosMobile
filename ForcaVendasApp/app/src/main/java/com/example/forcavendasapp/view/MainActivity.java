package com.example.forcavendasapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.forcavendasapp.R;

public class MainActivity extends AppCompatActivity {

    private Button btnMenuCliente;
    private Button btnMenuEndereco;
    private Button btnMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializando os botões
        btnMenuCliente = findViewById(R.id.btnMenuCliente);
        btnMenuEndereco = findViewById(R.id.btnMenuEndereco);
        btnMenuItem = findViewById(R.id.btnMenuItem);

        // Definindo os listeners para os botões
        btnMenuCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, clienteActivity.class);
                startActivity(intent);
            }
        });

        btnMenuEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, enderecoActivity.class);
                startActivity(intent);
            }
        });

        btnMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, itemActivity.class);
                startActivity(intent);
            }
        });
    }
}
