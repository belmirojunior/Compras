package br.com.analise.compras.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CATEGORIA")
@SequenceGenerator(name = "seq_categoria",sequenceName = "seq_categoria")
public class Categoria implements Serializable{



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoria")
    @Column(name= "CA_ID")
    private Integer id;

    @Column(name="CA_NOME")
    private String nome;

    //associações
    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")//faça um mapeamento igual de categorias
    private List<Produto>produtos=new ArrayList<>();//lista de produtos

    public Categoria(){

    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
