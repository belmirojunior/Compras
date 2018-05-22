package br.com.analise.compras.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity//@Entity indica que objetos dessa classe se tornem "persistível" no banco de dados.
@Table(name = "tb_categoria")//especificar o nome da tabela para nao usar o padrao que seria Categoria
@SequenceGenerator(name = "seq_categoria",sequenceName = "seq_categoria")
public class Categoria implements Serializable{



    @Id//@Id indica que o atributo id é nossa chave primária (você precisa ter uma chave primária em toda entidade)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoria")//@GeneratedValue diz que queremos que esta chave seja populada pelo banco (isto é, que seja usado um auto increment ou sequence,
    @Column(name= "ca_id")//especificar nome da coluna para que ela nao pegue o de padrao que seria id
    private Integer id;

    @Column(name="ca_nome")//especificar nome da coluna para que ela nao pegue
    private String nome;

    //associações
    //bi-directional many-to-many association
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
