package br.unipar.studenttracker.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;
import java.util.stream.Collectors;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.adapters.MediaAdapter;
import br.unipar.studenttracker.globais.Globais;
import br.unipar.studenttracker.model.Aluno;

public class Relacao_Medias_Activitys extends AppCompatActivity {

    private Spinner spDisciplina;
    private ListView lvMedias;
    private String[] vetorDisciplinas = new String[]{"TODAS", "DEV. WEB", "PROJETO INT.",
            "QUALIDADE", "GERÊNCIA", "FRAMEWORKS", "EMPREENDEDORISMO",
            "RELAÇÕES"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relacao_medias);

        spDisciplina = findViewById(R.id.spDisciplina);
        lvMedias = findViewById(R.id.lvNotas);

        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vetorDisciplinas);
        spDisciplina.setAdapter(adapterDisciplina);

        spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDisciplina = (String) spDisciplina.getSelectedItem();
                if (!selectedDisciplina.isEmpty() && !selectedDisciplina.equals("TODAS")) {
                    List<Aluno> filteredList = Globais.listaAluno.stream()
                            .filter(aluno -> aluno.getDisciplina() != null && aluno.getDisciplina().equals(selectedDisciplina))
                            .collect(Collectors.toList());
                    MediaAdapter adapter = new MediaAdapter(Relacao_Medias_Activitys.this, filteredList);
                    lvMedias.setAdapter(adapter);
                } else {
                    updateMediaList();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        updateMediaList();
    }

    private void updateMediaList() {
        MediaAdapter adapter = new MediaAdapter(this, Globais.listaAluno);
        lvMedias.setAdapter(adapter);
    }
}