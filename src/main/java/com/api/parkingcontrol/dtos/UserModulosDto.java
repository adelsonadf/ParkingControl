package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;

public class UserModulosDto {
    private Long id;
    // Getters e setters


    @NotBlank
    private String userModuloNome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserModuloNome(String userModuloNome) {
        this.userModuloNome = userModuloNome;
    }

    public String getUserModuloNome() {
        return userModuloNome;
    }


}
