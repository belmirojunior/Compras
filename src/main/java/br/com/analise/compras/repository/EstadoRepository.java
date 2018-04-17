package br.com.analise.compras.repository;

import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {


}
