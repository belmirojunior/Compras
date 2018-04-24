package br.com.analise.compras.Entity.enumemation;

public enum TipoClienteEnum {
    PESSOAFISICA("Pessoa Física"),
    PESSOAJURIDICA("Pessoa Juridica");

    String descricao;

    TipoClienteEnum(String descricao){
        this.descricao=descricao;
    }

    public  String getDescricao(){
        return descricao;
    }
}
