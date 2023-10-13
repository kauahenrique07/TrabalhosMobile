package com.example.forcavendasapp.controller;

import android.content.Context;

import com.example.forcavendasapp.dao.PedidoVendaDao;
import com.example.forcavendasapp.model.PedidoVenda;

import java.util.ArrayList;

public class PedidoVendaController {

    private Context context;

    public PedidoVendaController(Context context) {
        this.context = context;
    }

    public long salvarPedidoVenda(PedidoVenda pedidoVenda){
        return PedidoVendaDao.getInstancia(context).insert(pedidoVenda);
    }

    public long atualizarPedidoVenda(PedidoVenda pedidoVenda){
        return PedidoVendaDao.getInstancia(context).update(pedidoVenda);
    }

    public long apagarPedidoVenda(PedidoVenda pedidoVenda){
        return PedidoVendaDao.getInstancia(context).delete(pedidoVenda);
    }

    public ArrayList<PedidoVenda> findAllPedidoVenda(){
        return PedidoVendaDao.getInstancia(context).getAll();
    }

    public PedidoVenda findByIdPedidoVenda(int id){
        return PedidoVendaDao.getInstancia(context).getById(id);
    }

    public String validaPedidoVenda(String idPedido, String idCliente, String idEnderecoEntrega, String valorTotal, String condicaoPagamento, String numeroParcelas, String valorParcela, String frete){
        String mensagem = "";
        if(idPedido == null || idPedido.isEmpty()){
            mensagem += "ID do pedido deve ser informado!\n";
        }else{
            try{
                if(Integer.parseInt(idPedido) <= 0){
                    mensagem += "ID do pedido deve ser maior que zero!\n";
                }
            }catch(NumberFormatException ex){
                mensagem += "ID do pedido deve ser número válido!\n";
            }
        }
        if(idCliente == null || idCliente.isEmpty()){
            mensagem += "ID do cliente deve ser informado!\n";
        }
        if(idEnderecoEntrega == null || idEnderecoEntrega.isEmpty()){
            mensagem += "ID do endereço de entrega deve ser informado!\n";
        }
        if(valorTotal == null || valorTotal.isEmpty()){
            mensagem += "Valor total do pedido deve ser informado!\n";
        }
        if(condicaoPagamento == null || condicaoPagamento.isEmpty()){
            mensagem += "Condição de pagamento deve ser informada!\n";
        }
        if(numeroParcelas == null || numeroParcelas.isEmpty()){
            mensagem += "Número de parcelas deve ser informado!\n";
        }
        if(valorParcela == null || valorParcela.isEmpty()){
            mensagem += "Valor da parcela deve ser informado!\n";
        }
        if(frete == null || frete.isEmpty()){
            mensagem += "Frete deve ser informado!\n";
        }
        return mensagem;
    }
}