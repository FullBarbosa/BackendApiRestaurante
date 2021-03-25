package br.com.diogo.restapi.models.repository;

import br.com.diogo.restapi.models.entities.Pedidos;


import org.springframework.data.repository.CrudRepository;


public interface PedidosRepository extends CrudRepository<Pedidos, Integer> {

}
