package com.api.parkingcontrol.dtos;
import javax.validation.constraints.NotBlank;

public class UserGruposDto {

    @NotBlank
    private String userGrupoNome;

    public String getUserGrupoNome() {
        return userGrupoNome;
    }

    public void setUserGrupoNome(String userName) {
        this.userGrupoNome = userGrupoNome;
    }


}
