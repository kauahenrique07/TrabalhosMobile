package br.unipar.studenttracker.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
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
                if (!selectedRA.isEmpty()) {
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
        List<String> raList = Globais.listaAluno.stream().map(aluno -> String.valueOf(aluno.getRa())).collect(Collectors.toList());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, raList);
        spRA.setAdapter(adapter);
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
