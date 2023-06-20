package br.unipar.studenttracker.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.globais.Globais;
import br.unipar.studenttracker.model.Aluno;


public class Cadastro_Notas_Activitys extends AppCompatActivity {
    private EditText etRA, etNome, etNota;
    private Spinner spBimestre, spDisciplina;
    private Button btnAdicionar, btnVerNotas, btnVerMedias;
    private String bimestreSelecionado, disciplinaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notas);

        etRA = findViewById(R.id.edit_ra);
        etNome = findViewById(R.id.edit_nome);
        spDisciplina = findViewById(R.id.spDisciplina);
        etNota = findViewById(R.id.edita_nota);
        spBimestre = findViewById(R.id.spBimestre);
        btnAdicionar = findViewById(R.id.btn_add);
        btnVerNotas = findViewById(R.id.btn_view_notas);
        btnVerMedias = findViewById(R.id.btn_view_media);

        String[] vetorBimestres = new String[]{"", "1º", "2º", "3º", "4º"};
        ArrayAdapter adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestres);

        String[] vetorDisciplinas = new String[]{"", "DESENVOLVIMENTO WEB", "PROJETO INTEGRADOR",
                "QUALIDADE DE SOFTWARE", "GERÊNCIA DE PROJEOTS", "FRAMEWORKS", "EMPREENDEDORISMO",
                "RELAÇÕES INTERPESSOAIS"};
        ArrayAdapter adapterDisciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplinas);

        spDisciplina.setAdapter(adapterDisciplina);
        spBimestre.setAdapter(adapterBimestre);

        spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                disciplinaSelecionada = (String) spDisciplina.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bimestreSelecionado = (String) spBimestre.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ra = etRA.getText().toString().trim();
                String nome = etNome.getText().toString().trim();
                String disciplina = spDisciplina.getSelectedItem().toString();
                String nota = etNota.getText().toString().trim();
                String bimestre = spBimestre.getSelectedItem().toString();

                if (!ra.isEmpty() && !nome.isEmpty() && !disciplina.isEmpty() && !nota.isEmpty() && !bimestre.isEmpty()) {
                    Aluno aluno = new Aluno();
                    aluno.setRa(Integer.parseInt(ra));
                    aluno.setNome(nome);
                    aluno.setDisciplina(disciplina);
                    if (bimestre.equals("1º")) {
                        aluno.setPriBim(Double.parseDouble(nota));
                    } else if (bimestre.equals("2º")) {
                        aluno.setSegBim(Double.parseDouble(nota));
                    } else if (bimestre.equals("3º")) {
                        aluno.setTercBim(Double.parseDouble(nota));
                    } else if (bimestre.equals("4º")) {
                        aluno.setQuarBim(Double.parseDouble(nota));
                    }
                    Globais.listaAluno.add(aluno);
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Aluno adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                    // Limpar campos depois de adicionar
                    etRA.setText("");
                    etNome.setText("");
                    spDisciplina.setSelection(0);
                    etNota.setText("");
                    spBimestre.setSelection(0);
                } else {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Por favor preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVerNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro_Notas_Activitys.this, Relacao_Notas_Activitys.class);
                startActivity(intent);
            }
        });

        btnVerMedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro_Notas_Activitys.this, Relacao_Medias_Activitys.class);
                startActivity(intent);
            }
        });
    }
}



