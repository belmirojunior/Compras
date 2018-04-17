package br.com.analise.compras.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_ESTADO")
@SequenceGenerator(name = "seq_estado",sequenceName = "seq_estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado")
    @Column(name="ES_ID")
    private Integer id;

    @Column(name="ES_NOME")
    private String Nome;

    @OneToMany(mappedBy = "estado")    //nome da variavel do estado da clas Cidade
    private List<Cidade>cidades= new ArrayList<>();

    public Estado(){


    }


    public Estado(Integer id, String nome) {
        this.id = id;
        Nome = nome;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
