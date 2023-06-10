package br.unipar.studenttracker.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;
import br.unipar.studenttracker.R;
import br.unipar.studenttracker.model.Aluno;

public class Relacao_Notas_Activitys extends AppCompatActivity {

    private Spinner selectAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relacao_notas);

        selectAluno = findViewById(R.id.select_ra);

        // Obtenha a lista de alunos da intenção
        List<Aluno> listaAlunos = (List<Aluno>) getIntent().getSerializableExtra("listaAlunos");

        // Crie um adapter para preencher a seleção com os nomes dos alunos
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaAlunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectAluno.setAdapter(adapter);
    }
}
