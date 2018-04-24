package br.com.analise.compras.Entity;

import br.com.analise.compras.Entity.enumemation.EstadoPagamentoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class PagamentoComCartao extends Pagamento {

    private Integer numeroDeParcelas;

    public PagamentoComCartao(){

    }

    public PagamentoComCartao(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
