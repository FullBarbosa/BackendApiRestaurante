package br.com.diogo.restapi.models.repository;

import br.com.diogo.restapi.models.entities.Pratos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PratosRepository
        extends PagingAndSortingRepository<Pratos, Integer> {
    public Iterable<Pratos> findByNomeContainingIgnoreCase(String partNome);
}
