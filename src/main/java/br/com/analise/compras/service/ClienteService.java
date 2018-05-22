package br.com.analise.compras.service;

import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.Entity.Cliente;
import br.com.analise.compras.exception.ObjectNotFountException;
import br.com.analise.compras.repository.CategoriaRepository;
import br.com.analise.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired//A anotação @Autowired avisa ao Spring Framework para injetar
    // uma instância de alguma implementação
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Integer id){

        Cliente cliente = clienteRepository.findOne(id);

        if(cliente == null){
            throw new ObjectNotFountException("O objeto "+ Cliente.class.getName()+
                    " Com ID "+ id+" não foi encontrado");

        }
        return cliente;

        //return categoriaRepository.findOne(id);
    }

}
