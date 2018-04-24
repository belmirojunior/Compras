package br.com.analise.compras.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_PEDIDO")
@SequenceGenerator(name = "seq_pedido",sequenceName = "seq_pedido")
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pedido")
    @Column(name= "pe_id")
    private Integer id;

    @Column(name= "pe_instante")
    private Date instants;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "pedido")//se escrui tbm o pedido
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "en_id")
    private Endereco emderecoDeEntrega;

    @ManyToOne
    @JoinColumn(name = "cl_id")
    private Cliente cliente;

    public Pedido(){

    }

    public Pedido(Integer id,Date instants, Pagamento pagamento, Endereco emderecoDeEntrega, Cliente cliente) {
        this.id = id;
        this.instants = instants;
        this.pagamento = pagamento;
        this.emderecoDeEntrega = emderecoDeEntrega;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstants() {
        return instants;
    }

    public void setInstants(Date instants) {
        this.instants = instants;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Endereco getEmderecoDeEntrega() {
        return emderecoDeEntrega;
    }

    public void setEmderecoDeEntrega(Endereco emderecoDeEntrega) {
        this.emderecoDeEntrega = emderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
