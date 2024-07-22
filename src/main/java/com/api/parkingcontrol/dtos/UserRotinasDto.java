package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;

public class UserRotinasDto {
    private Long id;


    @NotBlank
    private String userRotinaNome;


    private String userRotinaDireitos;

    private long id_modulo;

    public long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(long id_modulo) {
        this.id_modulo = id_modulo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserRotinaNome(String userRotinaNome) {
        this.userRotinaNome = userRotinaNome;
    }

    public String getUserRotinaNome() {
        return userRotinaNome;
    }

    public void setUserRotinaDireitos(String userRotinaDireitos) {
        this.userRotinaDireitos = userRotinaDireitos;
    }

    public String getUserRotinaDireitos() {
        return userRotinaDireitos;
    }

}