package com.api.parkingcontrol.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_USUARIOS_GRUPOS")
public class UserGruposModel implements Serializable {

    @Id
    @GeneratedValue
    private Long  id;
    @Column(nullable = false, unique = true, length = 70)
    private String userGrupoNome;



    @OneToOne
    @JoinColumn(name = "userModel_id")
    private UserModel userModel;



    public Long getUserGrupoId() {
        return id;
    }

    public void setUserGrupoId(Long id) {
    }
    public String getUserGrupoNome() { return userGrupoNome; }


    public void setUserGrupoNome(String userGrupoNome) {
    }

}
