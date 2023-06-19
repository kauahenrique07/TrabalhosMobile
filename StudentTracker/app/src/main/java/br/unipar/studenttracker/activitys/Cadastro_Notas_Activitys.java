package br.unipar.studenttracker.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import br.unipar.studenttracker.R;
import br.unipar.studenttracker.globais.Globais;
import br.unipar.studenttracker.model.Aluno;

public class Cadastro_Notas_Activitys extends AppCompatActivity {

    private EditText editRa;
    private EditText editNome;
    private Spinner selectDisciplina;
    private int bimestreSelecionado;
    private String disciplinaSelecionada;
    private EditText editNota;
    private Spinner selectBimestre;
    private Button btnAdd;
    private Button btnViewNotas;
    private Button btnViewMedias;

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
        btnViewMedias = findViewById(R.id.btn_view_media);

        String[] vetorDisciplinas = new String[]{"","PROJETO INTEGRADOR","DESENVOLVIMENTO WEB",
                "QUALIDADE DE SOFTWARE", "GERENCIA DE PROJETOS", "EMPREENDEDORISMO", "RELAÇÕES INTERPESSOAIS", "FRAMEWORKS"};

        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, vetorDisciplinas);

        selectDisciplina.setAdapter(adapterDisciplina);

        String[] vetorBimestres = new String[]{"","1º","2º","3º","4º"};

        ArrayAdapter<String> adapterBimestre = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, vetorBimestres);

        selectBimestre.setAdapter(adapterBimestre);

        selectDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                disciplinaSelecionada = (String) selectDisciplina.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        selectBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                bimestreSelecionado = (int) selectBimestre.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

        btnViewMedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaRelacaoMedias();
            }
        });
    }

    private void adicionarNota() {
        // Obtenha os dados dos campos de entrada
        String ra = editRa.getText().toString().trim();
        String nome = editNome.getText().toString().trim();
        String disciplina = selectDisciplina.getSelectedItem().toString().trim();
        String nota = editNota.getText().toString().trim();
        String bimestre = selectBimestre.getSelectedItem().toString().trim();

        // Verifique se algum campo está vazio
        if (TextUtils.isEmpty(ra) || TextUtils.isEmpty(nome) || TextUtils.isEmpty(disciplina)
                || TextUtils.isEmpty(nota) || TextUtils.isEmpty(bimestre)) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cria um novo objeto Aluno
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(editRa.getText().toString()));
        aluno.setNome(editNome.getText().toString());
        aluno.setDisciplina(disciplinaSelecionada);
        aluno.setNota(Double.parseDouble(editNota.getText().toString()));
        aluno.setBimestre(bimestreSelecionado);


        // Adiciona o aluno à lista de alunos
        Globais.listaAluno.add(aluno);


        // Notifique o usuário sobre a adição da nota
        String mensagem = "Nota cadastrada com sucesso!";
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

        // Limpa os campos após adicionar a nota
        editRa.setText("");
        editNome.setText("");
        selectDisciplina.setSelection(0);
        editNota.setText("");
        selectBimestre.setSelection(0);

        finish();
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

