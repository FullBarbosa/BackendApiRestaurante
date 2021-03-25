package br.com.diogo.restapi.controllers;

import br.com.diogo.restapi.models.entities.Pratos;
import br.com.diogo.restapi.models.repository.PratosRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/pratos")
public class PratosControllers {

    @Autowired
    private PratosRepository pratosRepository;

    //   Cadastro
    @PostMapping
    @ResponseBody
    Pratos novoPrato(@Valid @RequestBody Pratos prato) {

        pratosRepository.save(prato);
        return prato;
    }

    //   chamada de todos pratos disponiveis
    @GetMapping
    public Iterable<Pratos> obeterPratos() {
        return pratosRepository.findAll();
    }

    //   chamada de todos pratos ddisponiveis
    @GetMapping(path="/nome/{parteNome}")
    public Iterable<Pratos> obeterPratosNome(@PathVariable String parteNome) {
        return pratosRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    //   chamada por id
    @GetMapping(path = "/{id}")
    public Optional<Pratos> obterPratoId(@PathVariable int id) {
        return pratosRepository.findById(id);
    }

    //    Atualizar prato por Id
    @PutMapping(path = "/{id}")
    public ResponseEntity<Pratos> alterarPrato(@PathVariable int id, @Valid @RequestBody Pratos pratoAtualizado) {
        return pratosRepository.findById(id).map(prato ->{
            prato.setNome(pratoAtualizado.getNome());
            prato.setPreco(pratoAtualizado.getPreco());

            Pratos pratoNovo = pratosRepository.save(prato);
            return ResponseEntity.ok().body(pratoNovo);
        }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping(path = "/{id}")
    public void excluirPrato(@PathVariable int id){
        pratosRepository.deleteById(id);

    }
}
