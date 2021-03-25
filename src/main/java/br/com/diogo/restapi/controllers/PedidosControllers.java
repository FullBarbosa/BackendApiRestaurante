package br.com.diogo.restapi.controllers;


import br.com.diogo.restapi.models.entities.Pedidos;


import br.com.diogo.restapi.models.entities.Pratos;
import br.com.diogo.restapi.models.repository.PedidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/pedidos")
public class  PedidosControllers {

    @Autowired
    private PedidosRepository pedidosRepository;

    @PostMapping
    @ResponseBody
    Pedidos novoPedido(@Valid @RequestBody Pedidos pedido) {

        pedidosRepository.save(pedido);
        return pedido;
    }

    //   chamada de todos pratos disponiveis
    @GetMapping
    public Iterable<Pedidos> obeterPedidos() {
        return pedidosRepository.findAll();
    }

    //   chamada por id
    @GetMapping(path = "/{id}")
    public Optional<Pedidos> obterPedidoId(@PathVariable int id) {
        return pedidosRepository.findById(id);
    }


    //    Atualizar prato por Id
    @PutMapping(path = "/{id}")
    public ResponseEntity<Pedidos> alterarPedido(@PathVariable int id, @Valid @RequestBody Pedidos pedidoAtualizado) {
        return pedidosRepository.findById(id).map(pedido ->{
            pedido.setStatus(pedidoAtualizado.getStatus());
            pedido.setPrato(pedidoAtualizado.getPrato());
            pedido.setMesa(pedidoAtualizado.getMesa());


            Pedidos pedidoNovo = pedidosRepository.save(pedido);
            return ResponseEntity.ok().body(pedidoNovo);
        }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping(path = "/{id}")
    public void excluirPedido(@PathVariable int id){
        pedidosRepository.deleteById(id);
    }

}
