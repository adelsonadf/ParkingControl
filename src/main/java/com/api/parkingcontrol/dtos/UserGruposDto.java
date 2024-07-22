package com.api.parkingcontrol.dtos;
import javax.validation.constraints.NotBlank;

public class UserGruposDto {

    @NotBlank
    private String userGrupoNome;

    public void setUserGrupoNome(String userGrupoNome) {
        this.userGrupoNome = userGrupoNome;
    }


    public String getUserGrupoNome() {
        return userGrupoNome;
    }


}
