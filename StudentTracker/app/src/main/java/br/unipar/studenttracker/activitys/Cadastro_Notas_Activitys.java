package br.unipar.studenttracker.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import br.unipar.studenttracker.R;

public class Cadastro_Notas_Activitys extends AppCompatActivity {

    private EditText editRa;
    private EditText editNome;
    private Spinner selectDisciplina;
    private EditText editNota;
    private Spinner selectBimestre;
    private Button btnAdd;
    private Button btnViewNotas;
    private Button btnViewMedias; // Botão para visualizar as médias

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notas);

        editRa = findViewById(R.id.edit_ra);
        editNome = findViewById(R.id.edit_nome);
        selectDisciplina = findViewById(R.id.select_disciplina);
        editNota = findViewById(R.id.edita_nota);
        selectBimestre = findViewById(R.id.select_bimestre);
        btnAdd = findViewById(R.id.btn_add);
        btnViewNotas = findViewById(R.id.btn_view_notas);
        btnViewMedias = findViewById(R.id.btn_view_media); // Botão "VER MÉDIAS"

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarNota();
            }
        });

        btnViewNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaRelacaoNotas();
            }
        });

        btnViewMedias.setOnClickListener(new View.OnClickListener() { // Ação do botão "VER MÉDIAS"
            @Override
            public void onClick(View v) {
                abrirTelaRelacaoMedias();
            }
        });
    }

    private void adicionarNota() {
        String ra = editRa.getText().toString().trim();
        String nome = editNome.getText().toString().trim();
        String disciplina = selectDisciplina.getSelectedItem().toString().trim();
        String nota = editNota.getText().toString().trim();
        String bimestre = selectBimestre.getSelectedItem().toString().trim();

        if (TextUtils.isEmpty(ra) || TextUtils.isEmpty(nome) || TextUtils.isEmpty(disciplina)
                || TextUtils.isEmpty(nota) || TextUtils.isEmpty(bimestre)) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        String mensagem = "Nota cadastrada com sucesso!";
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

        // Limpar os campos após adicionar a nota
        editRa.setText("");
        editNome.setText("");
        selectDisciplina.setSelection(0);
        editNota.setText("");
        selectBimestre.setSelection(0);
    }

    private void abrirTelaRelacaoNotas() {
        Intent intent = new Intent(this, Relacao_Notas_Activitys.class);
        startActivity(intent);
    }

    private void abrirTelaRelacaoMedias() {
        Intent intent = new Intent(this, Relacao_Medias_Activitys.class);
        startActivity(intent);
    }
}
