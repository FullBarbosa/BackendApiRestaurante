package br.com.diogo.restapi.models.repository;

import br.com.diogo.restapi.models.entities.Mesas;
import br.com.diogo.restapi.models.entities.Pedidos;
import org.springframework.data.repository.CrudRepository;

public interface MesasRepository  extends CrudRepository<Mesas, Integer> {
}
