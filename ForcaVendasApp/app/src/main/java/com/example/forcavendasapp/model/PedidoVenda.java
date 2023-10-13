package com.example.forcavendasapp.model;

public class PedidoVenda {

    private int idPedido;
    private int idCliente;
    private int idEnderecoEntrega;
    private double valorTotal;
    private String condicaoPagamento;
    private int numeroParcelas;
    private double valorParcela;
    private double frete;

    public PedidoVenda(int idPedido, int idCliente, int idEnderecoEntrega, double valorTotal, String condicaoPagamento, int numeroParcelas, double valorParcela, double frete) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEnderecoEntrega = idEnderecoEntrega;
        this.valorTotal = valorTotal;
        this.condicaoPagamento = condicaoPagamento;
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
        this.frete = frete;
    }

    public PedidoVenda() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEnderecoEntrega() {
        return idEnderecoEntrega;
    }

    public void setIdEnderecoEntrega(int idEnderecoEntrega) {
        this.idEnderecoEntrega = idEnderecoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
}
