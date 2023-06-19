package br.unipar.studenttracker.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import br.unipar.studenttracker.R;
import br.unipar.studenttracker.adapters.NotaAdapter;
import br.unipar.studenttracker.globais.Globais;
import br.unipar.studenttracker.model.Aluno;

public class Relacao_Notas_Activitys extends AppCompatActivity {

    private Spinner selectAluno;

    private ListView lvAlunos;

    private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relacao_notas);

        atualizaLista(Globais.listaAluno);

        selectAluno = findViewById(R.id.select_ra);
            // Obtenha a lista de alunos da intenção
            List<Aluno> listaAlunos = (List<Aluno>) getIntent().getSerializableExtra("listaAlunos");

            // Crie um adapter para preencher a seleção com os nomes dos alunos
            ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaAlunos);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            selectAluno.setAdapter(adapter);
        }

    private void atualizaLista(ArrayList<Aluno> lista){
        NotaAdapter adapter =
                new NotaAdapter(this, lista);
        lvAlunos.setAdapter(adapter);
    }

    private void exibirAlunoSelecionado(Aluno aluno){
        Toast.makeText(this,
                "RA: "+aluno.getRa()+" Nome: "+aluno.getNome(),
                Toast.LENGTH_LONG).show();
    }
}
