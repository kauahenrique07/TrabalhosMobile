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

public class MediaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Aluno> lista;

    public MediaAdapter(Context context, ArrayList<Aluno> lista) {
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
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_list_medias,
                            parent, false);
        }

        String resultado = "";

        Aluno notasAluno = lista.get(position);

        Double media = (lista.get(position).getPriBim() + lista.get(position).getSegBim() + lista.get(position).getTercBim() + lista.get(position).getQuarBim())/4;

        if(media >= 60){
            resultado = "APROVADO";
        }else{
            resultado = "REPROVADO";
        }

        TextView tvAlunoMedia = view.findViewById(R.id.tvMedia);
        TextView tvRa = view.findViewById(R.id.tvRa);
        TextView tvResultado = view.findViewById(R.id.tvResultado);
        TextView tvMediaTotal = view.findViewById(R.id.tvMedia);
        TextView tvMateria = view.findViewById(R.id.tvDisciplina);


        tvAlunoMedia.setText(notasAluno.getNome());
        tvRa.setText(tvRa.getText().toString() + notasAluno.getRa());
        tvResultado.setText(resultado);
        tvMediaTotal.setText(String.valueOf(media));
        tvMateria.setText(notasAluno.getDisciplina());

        return view;
    }
}
