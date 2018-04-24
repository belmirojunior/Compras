package br.com.analise.compras.repository;

import br.com.analise.compras.Entity.Cidade;
import br.com.analise.compras.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {


}
