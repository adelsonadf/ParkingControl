package com.api.parkingcontrol.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tb_usuarios_Rotinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userRotinaNome;
    private String userRotinaDireitos;

    private Long userModulo_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRotinaNome() {
        return userRotinaNome;
    }

    public void setUserRotinaNome(String userRotinaNome) {
        this.userRotinaNome = userRotinaNome;
    }

    public String getUserRotinaDireitos() {
        return userRotinaDireitos;
    }

    public void setUserRotinaDireitos(String userRotinaDireitos) {
        this.userRotinaDireitos = userRotinaDireitos;
    }

    public Long getUserModulo_id() {
        return userModulo_id;
    }

    public void setUserModulo_id(Long userModulo_id) {
        this.userModulo_id = userModulo_id;
    }
}


