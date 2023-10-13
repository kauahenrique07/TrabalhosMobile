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

        // Validação do ID do Pedido
        if(idPedido == null || idPedido.trim().isEmpty()){
            mensagem += "ID do pedido deve ser informado!\n";
        } else {
            try {
                if(Integer.parseInt(idPedido) <= 0){
                    mensagem += "ID do pedido deve ser maior que zero!\n";
                }
            } catch(NumberFormatException ex) {
                mensagem += "ID do pedido deve ser um número válido!\n";
            }
        }

        // Validação do ID do Cliente
        if(idCliente == null || idCliente.trim().isEmpty()){
            mensagem += "ID do cliente deve ser informado!\n";
        }

        // Validação do ID do Endereço de Entrega
        if(idEnderecoEntrega == null || idEnderecoEntrega.trim().isEmpty()){
            mensagem += "ID do endereço de entrega deve ser informado!\n";
        }

        // Validação do Valor Total
        if(valorTotal == null || valorTotal.trim().isEmpty()){
            mensagem += "Valor total do pedido deve ser informado!\n";
        } else {
            try {
                if(Double.parseDouble(valorTotal) <= 0){
                    mensagem += "Valor total do pedido deve ser maior que zero!\n";
                }
            } catch(NumberFormatException ex) {
                mensagem += "Valor total do pedido deve ser um número válido!\n";
            }
        }

        // Validação da Condição de Pagamento
        if(condicaoPagamento == null || condicaoPagamento.trim().isEmpty()){
            mensagem += "Condição de pagamento deve ser informada!\n";
        }

        // Validação do Número de Parcelas
        if(numeroParcelas == null || numeroParcelas.trim().isEmpty()){
            mensagem += "Número de parcelas deve ser informado!\n";
        } else {
            try {
                if(Integer.parseInt(numeroParcelas) <= 0){
                    mensagem += "Número de parcelas deve ser maior que zero!\n";
                }
            } catch(NumberFormatException ex) {
                mensagem += "Número de parcelas deve ser um número válido!\n";
            }
        }

        // Validação do Valor da Parcela
        if(valorParcela == null || valorParcela.trim().isEmpty()){
            mensagem += "Valor da parcela deve ser informado!\n";
        } else {
            try {
                if(Double.parseDouble(valorParcela) <= 0){
                    mensagem += "Valor da parcela deve ser maior que zero!\n";
                }
            } catch(NumberFormatException ex) {
                mensagem += "Valor da parcela deve ser um número válido!\n";
            }
        }

        // Validação do Frete
        if(frete == null || frete.trim().isEmpty()){
            mensagem += "Frete deve ser informado!\n";
        } else {
            try {
                if(Double.parseDouble(frete) < 0){
                    mensagem += "Frete não pode ser negativo!\n";
                }
            } catch(NumberFormatException ex) {
                mensagem += "Frete deve ser um número válido!\n";
            }
        }

        return mensagem;
    }
}