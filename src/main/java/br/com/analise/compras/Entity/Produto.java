package br.com.analise.compras.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_produto")
@SequenceGenerator(name = "seq_produto",sequenceName = "seq_produto")
public class Produto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_produto")
    @Column(name = "pr_id")
    private Integer id;

    @Column(name= "pr_nome")
    private String nome;

    @Column(name="pr_preco")
    private double preco;

    //Associações
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="tb_produto_categoria",
        joinColumns= @JoinColumn(name="pr_id"),
        inverseJoinColumns = @JoinColumn(name="ca_id"))
    private List<Categoria>categorias=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")///mapeando i id. produto lá de pedido
    private Set<ItemPedido> itens =new HashSet<>();


    public Produto(){

    }

    public Produto(Integer id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    @JsonIgnore
    public List<Pedido>getPedidos(){
        List<Pedido>lista =new ArrayList<>();
        for (ItemPedido x:itens){
            lista.add(x.getPedido());
        }
        return lista;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
