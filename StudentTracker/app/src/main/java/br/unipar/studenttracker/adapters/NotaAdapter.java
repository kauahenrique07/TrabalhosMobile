package br.unipar.studenttracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.unipar.studenttracker.R;
import br.unipar.studenttracker.model.Aluno;

public class NotaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Aluno> lista;

    public NotaAdapter(Context context, ArrayList<Aluno> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_notas, parent, false);
        }

        Aluno notasAluno = lista.get(position);

        TextView tvDisciplina = view.findViewById(R.id.tvDisciplina);
        TextView tvMedia = view.findViewById(R.id.tvMedia);
        TextView tvPriBim = view.findViewById(R.id.tvNotaPri);
        TextView tvSegBim = view.findViewById(R.id.tvNotaSeg);
        TextView tvTercBim = view.findViewById(R.id.tvNotaTerc);
        TextView tvQuarBim = view.findViewById(R.id.tvNotaQuar);

        Double media = (notasAluno.getPriBim() + notasAluno.getSegBim() + notasAluno.getTercBim() + notasAluno.getQuarBim()) / 4;

        tvDisciplina.setText(notasAluno.getDisciplina());
        tvPriBim.setText(context.getString(R.string.pri_bim_label) + " " + notasAluno.getPriBim());
        tvSegBim.setText(context.getString(R.string.seg_bim_label) + " " + notasAluno.getSegBim());
        tvTercBim.setText(context.getString(R.string.terc_bim_label) + " " + notasAluno.getTercBim());
        tvQuarBim.setText(context.getString(R.string.quar_bim_label) + " " + notasAluno.getQuarBim());
        tvMedia.setText(context.getString(R.string.media_label) + " " + media);

        return view;
    }
}