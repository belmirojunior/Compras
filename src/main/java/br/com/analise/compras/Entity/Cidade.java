package br.com.analise.compras.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cidade")
@SequenceGenerator(name = "seq_cidade",sequenceName = "seq_cidade")
public class Cidade implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cidade")
    @Column(name = "ci_id")
    private Integer id;

    @Column(name ="ci_nome")
    private String Nome;

    @ManyToOne//(n para 1),
    @JoinColumn(name= "es_id")
    private Estado estado;

    private Cidade(){


    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        Nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
