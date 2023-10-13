package com.example.forcavendasapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.forcavendasapp.helper.SQLiteDataHelper;
import com.example.forcavendasapp.model.PedidoVenda;

import java.util.ArrayList;

public class PedidoVendaDao implements GenericDao<PedidoVenda> {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase bd;
    private String[] colunas = {"IDPEDIDO", "IDCLIENTE", "IDENDERECOENTREGA", "VALORTOTAL", "CONDICAOPAGAMENTO", "NUMEROPARCELAS", "VALORPARCELA", "FRETE"};
    private String tableName = "PEDIDO_VENDA";
    private Context context;
    private static PedidoVendaDao instancia;

    private PedidoVendaDao(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    public static PedidoVendaDao getInstancia(Context context) {
        if (instancia == null)
            return instancia = new PedidoVendaDao(context);
        else
            return instancia;
    }

    @Override
    public long insert(PedidoVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("IDPEDIDO", obj.getIdPedido());
            valores.put("IDCLIENTE", obj.getIdCliente());
            valores.put("IDENDERECOENTREGA", obj.getIdEnderecoEntrega());
            valores.put("VALORTOTAL", obj.getValorTotal());
            valores.put("CONDICAOPAGAMENTO", obj.getCondicaoPagamento());
            valores.put("NUMEROPARCELAS", obj.getNumeroParcelas());
            valores.put("VALORPARCELA", obj.getValorParcela());
            valores.put("FRETE", obj.getFrete());

            return bd.insert(tableName, null, valores);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.insert(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(PedidoVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("IDPEDIDO", obj.getIdPedido());
            valores.put("IDCLIENTE", obj.getIdCliente());
            valores.put("IDENDERECOENTREGA", obj.getIdEnderecoEntrega());
            valores.put("VALORTOTAL", obj.getValorTotal());
            valores.put("CONDICAOPAGAMENTO", obj.getCondicaoPagamento());
            valores.put("NUMEROPARCELAS", obj.getNumeroParcelas());
            valores.put("VALORPARCELA", obj.getValorParcela());
            valores.put("FRETE", obj.getFrete());

            String[] identificador = {String.valueOf(obj.getIdPedido())};
            return bd.update(tableName, valores, "IDPEDIDO = ?", identificador);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.update(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(PedidoVenda obj) {
        try {
            String[] identificador = {String.valueOf(obj.getIdPedido())};
            return bd.delete(tableName, "IDPEDIDO = ?", identificador);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.delete(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<PedidoVenda> getAll() {
        ArrayList<PedidoVenda> lista = new ArrayList<>();
        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "IDPEDIDO asc");
            if (cursor.moveToFirst()) {
                do {
                    PedidoVenda pedidoVenda = new PedidoVenda();
                    pedidoVenda.setIdPedido(cursor.getInt(0));
                    pedidoVenda.setIdCliente(cursor.getInt(1));
                    pedidoVenda.setIdEnderecoEntrega(cursor.getInt(2));
                    pedidoVenda.setValorTotal(cursor.getDouble(3));
                    pedidoVenda.setCondicaoPagamento(cursor.getString(4));
                    pedidoVenda.setNumeroParcelas(cursor.getInt(5));
                    pedidoVenda.setValorParcela(cursor.getDouble(6));
                    pedidoVenda.setFrete(cursor.getDouble(7));

                    lista.add(pedidoVenda);
                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public PedidoVenda getById(int id) {
        try {
            Cursor cursor = bd.query(tableName, colunas, "IDPEDIDO = ?", new String[]{String.valueOf(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                PedidoVenda pedidoVenda = new PedidoVenda();
                pedidoVenda.setIdPedido(cursor.getInt(0));
                pedidoVenda.setIdCliente(cursor.getInt(1));
                pedidoVenda.setIdEnderecoEntrega(cursor.getInt(2));
                pedidoVenda.setValorTotal(cursor.getDouble(3));
                pedidoVenda.setCondicaoPagamento(cursor.getString(4));
                pedidoVenda.setNumeroParcelas(cursor.getInt(5));
                pedidoVenda.setValorParcela(cursor.getDouble(6));
                pedidoVenda.setFrete(cursor.getDouble(7));

                return pedidoVenda;
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.getById(): " + ex.getMessage());
        }
        return null;
    }

}
