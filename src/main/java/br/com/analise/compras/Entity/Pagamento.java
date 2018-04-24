package br.com.analise.compras.Entity;

import br.com.analise.compras.Entity.enumemation.EstadoPagamentoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "seq_pagamento",sequenceName = "seq_pagamento")
public class Pagamento implements Serializable{

    @Id
    @Column(name= "pa_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pagamento")
    private Integer id;

    @Column(name= "pa_estado")
    private EstadoPagamentoEnum estado;

    @OneToOne//um para um
    @JoinColumn(name = "pe_id")
    @MapsId//diz que o id que vai definir a chave primaria de pagamento é esse aqui
    private Pedido pedido;//pedido é a chave primaria de pagamento

    public Pagamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamentoEnum estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pagamento(Integer id, EstadoPagamentoEnum estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
