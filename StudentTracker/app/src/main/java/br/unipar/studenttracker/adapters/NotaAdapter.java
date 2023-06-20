package br.unipar.studenttracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.unipar.studenttracker.model.Aluno;

import androidx.annotation.NonNull;

import java.util.List;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.model.Aluno;

public class NotaAdapter extends BaseAdapter {

    private final Context context;
    private final List<Aluno> alunos;

    public NotaAdapter(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_list_notas, parent, false);

        TextView tvDisciplina = rowView.findViewById(R.id.tvDisciplina);
        TextView tvMedia = rowView.findViewById(R.id.tvMedia);
        TextView tvNotaPri = rowView.findViewById(R.id.tvNotaPri);
        TextView tvNotaSeg = rowView.findViewById(R.id.tvNotaSeg);
        TextView tvNotaTerc = rowView.findViewById(R.id.tvNotaTerc);
        TextView tvNotaQuar = rowView.findViewById(R.id.tvNotaQuar);

        Aluno aluno = alunos.get(position);

        tvDisciplina.setText("Disciplina: " + aluno.getDisciplina());
        tvMedia.setText("Média: " + aluno.calcularMedia(aluno));
        tvNotaPri.setText("1ºBim: " + (aluno.getPriBim() != null ? aluno.getPriBim().toString() : ""));
        tvNotaSeg.setText("2ºBim: " + (aluno.getSegBim() != null ? aluno.getSegBim().toString() : ""));
        tvNotaTerc.setText("3ºBim: " + (aluno.getTercBim() != null ? aluno.getTercBim().toString() : ""));
        tvNotaQuar.setText("4ºBim: " + (aluno.getQuarBim() != null ? aluno.getQuarBim().toString() : ""));

        return rowView;
    }
}