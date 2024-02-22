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




    @OneToMany(mappedBy = "userGruposModel")
    private List<UserModel> userModel;

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }


}
