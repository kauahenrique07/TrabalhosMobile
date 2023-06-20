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

        String[] vetorDisciplinas = new String[]{"", "DEV. WEB", "PROJETO INT.",
                "QUALIDADE", "GERÊNCIA", "FRAMEWORKS", "EMPREENDEDORISMO",
                "RELAÇÕES"};
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

                // Verificar se todos os campos estão preenchidos
                if (ra.isEmpty() || nome.isEmpty() || disciplina.isEmpty() || nota.isEmpty() || bimestre.isEmpty()) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Por favor preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificar se RA contém apenas números inteiros
                if (!ra.matches("\\d+")) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "RA deve conter apenas números inteiros!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificar se nome contém apenas letras (incluindo acentuação e ç)
                if (!nome.matches("^[\\p{L} .'-]+$")) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Nome deve conter apenas letras!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar nota
                double notaDouble;
                try {
                    notaDouble = Double.parseDouble(nota);
                    if (notaDouble < 0.0 || notaDouble > 10.0) {
                        Toast.makeText(Cadastro_Notas_Activitys.this, "Nota deve ser entre 0.0 e 10.0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Formato de nota inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Aluno alunoExistente = null;
                for (Aluno aluno : Globais.listaAluno) {
                    if (aluno.getRa() == Integer.parseInt(ra)) {
                        alunoExistente = aluno;
                        if (!aluno.getNome().equals(nome)) {
                            Toast.makeText(Cadastro_Notas_Activitys.this, "RA já cadastrado com nome diferente!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                    }
                }

                if (alunoExistente != null) {
                    if (bimestre.equals("1º")) {
                        alunoExistente.setPriBim(notaDouble);
                    } else if (bimestre.equals("2º")) {
                        alunoExistente.setSegBim(notaDouble);
                    } else if (bimestre.equals("3º")) {
                        alunoExistente.setTercBim(notaDouble);
                    } else if (bimestre.equals("4º")) {
                        alunoExistente.setQuarBim(notaDouble);
                    }
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Nota do aluno atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Aluno novoAluno = new Aluno();
                    novoAluno.setRa(Integer.parseInt(ra));
                    novoAluno.setNome(nome);
                    novoAluno.setDisciplina(disciplina);
                    if (bimestre.equals("1º")) {
                        novoAluno.setPriBim(notaDouble);
                    } else if (bimestre.equals("2º")) {
                        novoAluno.setSegBim(notaDouble);
                    } else if (bimestre.equals("3º")) {
                        novoAluno.setTercBim(notaDouble);
                    } else if (bimestre.equals("4º")) {
                        novoAluno.setQuarBim(notaDouble);
                    }
                    Globais.listaAluno.add(novoAluno);
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Aluno adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                }

                // Limpar campos depois de adicionar
                etRA.setText("");
                etNome.setText("");
                spDisciplina.setSelection(0);
                etNota.setText("");
                spBimestre.setSelection(0);
            }
        });



        btnVerNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Globais.listaAluno.isEmpty()) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Adicione pelo menos um aluno antes de acessar esta opção!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Cadastro_Notas_Activitys.this, Relacao_Notas_Activitys.class);
                    startActivity(intent);
                }
            }
        });

        btnVerMedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Globais.listaAluno.isEmpty()) {
                    Toast.makeText(Cadastro_Notas_Activitys.this, "Adicione pelo menos um aluno antes de acessar esta opção!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Cadastro_Notas_Activitys.this, Relacao_Medias_Activitys.class);
                    startActivity(intent);
                }
            }
        });
    }
}



