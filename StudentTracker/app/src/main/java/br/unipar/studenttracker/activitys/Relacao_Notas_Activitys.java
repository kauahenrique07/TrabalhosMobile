package br.unipar.studenttracker.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.adapters.NotaAdapter;
import br.unipar.studenttracker.globais.Globais;
import br.unipar.studenttracker.model.Aluno;

public class Relacao_Notas_Activitys extends AppCompatActivity {

    private Spinner spRA;
    private ListView lvNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relacao_notas);

        spRA = findViewById(R.id.select_ra);
        lvNotas = findViewById(R.id.lvNotas);

        updateRAList();
        updateNotaList();

        spRA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedRA = (String) spRA.getSelectedItem();
                if (!selectedRA.isEmpty() && !selectedRA.equals("TODOS")) {
                    List<Aluno> filteredList = Globais.listaAluno.stream()
                            .filter(aluno -> String.valueOf(aluno.getRa()).equals(selectedRA))
                            .collect(Collectors.toList());
                    NotaAdapter adapter = new NotaAdapter(Relacao_Notas_Activitys.this, filteredList);
                    lvNotas.setAdapter(adapter);
                } else {
                    updateNotaList();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void updateRAList() {
        // Crie um Set para armazenar os RAs únicos
        Set<String> raSet = new HashSet<>();

        // Adicione RAs dos alunos no Set
        for (Aluno aluno : Globais.listaAluno) {
            raSet.add(String.valueOf(aluno.getRa()));
        }

        // Converta o Set em uma List para usar com o ArrayAdapter
        List<String> raList = new ArrayList<>(raSet);

        // Adicione a opção "TODAS" à lista
        raList.add(0, "TODOS");

        // Crie um ArrayAdapter para o Spinner
        ArrayAdapter<String> adapterRA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, raList);

        // Defina o adapter para o Spinner
        spRA.setAdapter(adapterRA);
    }

    private void updateNotaList() {
        NotaAdapter adapter = new NotaAdapter(this, Globais.listaAluno);
        lvNotas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateRAList();
        updateNotaList();
    }
}