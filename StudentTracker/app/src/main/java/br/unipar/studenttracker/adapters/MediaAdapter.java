package br.unipar.studenttracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.unipar.studenttracker.model.Aluno;

import java.util.List;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.model.Aluno;

public class MediaAdapter extends BaseAdapter {

    private final Context context;
    private final List<Aluno> alunos;

    public MediaAdapter(Context context, List<Aluno> alunos) {
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
        View rowView = inflater.inflate(R.layout.item_list_medias, parent, false);

        TextView tvRa = rowView.findViewById(R.id.tvRa);
        TextView tvMedia = rowView.findViewById(R.id.tvMedia);
        TextView tvAluno = rowView.findViewById(R.id.tvAluno);
        TextView tvResultado = rowView.findViewById(R.id.tvResultado);

        Aluno aluno = alunos.get(position);

        tvRa.setText("RA: " + aluno.getRa());
        double media = aluno.calcularMedia(aluno);
        tvMedia.setText("Média: " + media);
        tvAluno.setText("Aluno: " + aluno.getNome());
        tvResultado.setText(calcularResultado(media));

        return rowView;
    }

    private String calcularResultado(double media) {
        return media >= 6.0 ? "APROVADO" : "REPROVADO";
    }
}