package br.unipar.studenttracker.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.globais.Globais;

public class Cadastro_Notas_Activitys extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notas);

        if (Globais.listaAluno == null) {
            Globais.listaAluno = new ArrayList<>();
        }
        
    }
}