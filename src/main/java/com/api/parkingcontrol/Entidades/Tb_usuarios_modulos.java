package com.api.parkingcontrol.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tb_usuarios_modulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userModuloNome;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserModuloNome() {
        return userModuloNome;
    }

    public void setUserModuloNome(String userModuloNome) {
        this.userModuloNome = userModuloNome;
    }
}

