package br.com.analise.compras.Entity.enumemation;

public enum EstadoPagamentoEnum {

    PENDENTE("Pendente"),
    QUITADO("Quitado"),
    CANCELADO("Cancelado");

    String descricao;

    EstadoPagamentoEnum(String descricao){
        this.descricao=descricao;
    }

    public  String getDescricao(){
        return descricao;
    }
}
