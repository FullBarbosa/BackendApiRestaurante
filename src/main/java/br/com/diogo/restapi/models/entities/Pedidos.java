package br.com.diogo.restapi.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mesa;
    private String status;

    @ManyToMany
    private List<Pratos> prato;

    public List<Pratos> getPrato() {
        return prato;
    }

    public void setPrato(List<Pratos> prato) {
        this.prato = prato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }


}
