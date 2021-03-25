package br.com.diogo.restapi.controllers;


import br.com.diogo.restapi.models.entities.Mesas;

import br.com.diogo.restapi.models.entities.Pedidos;
import br.com.diogo.restapi.models.repository.MesasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/mesas")
public class MesaControllers {



    @Autowired
    private MesasRepository mesasRepository;

    //   Cadastro
    @PostMapping
    @ResponseBody
    Mesas novaMesa(@Valid @RequestBody Mesas mesas) {

        mesasRepository.save(mesas);
        return mesas;
    }

    //   chamada de todos pratos disponiveis
    @GetMapping
    public Iterable<Mesas> obeterMesas() {
        return mesasRepository.findAll();
    }

    //   chamada por id
    @GetMapping(path = "/{id}")
    public Optional<Mesas> obterMesaId(@PathVariable int id) {
        return mesasRepository.findById(id);
    }

    //    Atualizar prato por Id
    @PutMapping(path = "/{id}")
    public ResponseEntity<Mesas> alterarMesa(@PathVariable int id, @Valid @RequestBody Mesas mesaAtualizado) {
        return mesasRepository.findById(id).map(mesa ->{
            mesa.setStatus(mesaAtualizado.getStatus());


            Mesas mesanovo = mesasRepository.save(mesa);
            return ResponseEntity.ok().body(mesanovo);
        }).orElse(ResponseEntity.notFound().build());

    }

}
