package com.api.parkingcontrol.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "TB_USUARIOS")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue
    private Long  id;
    @Column(nullable = false, unique = true, length = 70)
    private String userName;
    @Column(nullable = false, length = 70)
    private String userSenha;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column()
    private LocalDateTime ultimoAcessoDate;

    @Column()

    private LocalDate aniversarioDate;

    @Column(nullable = false, length = 130)
    private String userFone;
    @Column(nullable = false, length = 50)
    private String userEmail;

    @Column(nullable = false)
    private int userGrupo;

    @Column()
    private int userStatus;

    @OneToOne(mappedBy = "userModel", cascade = CascadeType.ALL)
    private UserGruposModel userGruposModel;
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSenha() {
       return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getUltimoAcessoDate() {
        return ultimoAcessoDate;
    }

    public void setUltimoAcessoDate(LocalDateTime ultimoAcessoDate) {
        this.ultimoAcessoDate = ultimoAcessoDate;
    }

    public LocalDate getAniversarioDate() {
        return aniversarioDate;
    }

    public void setAniversarioDate(LocalDate aniverssarioDate) {
        this.aniversarioDate = aniverssarioDate;
    }





    public String getUserFone() {
        return userFone;
    }

    public void setUserFone(String userFone) {
        this.userFone = userFone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserGrupo() {
       return userGrupo;
    }

   public void setUserGrupo(int userGrupo) {
       this.userGrupo = userGrupo;
   }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public UserGruposModel getUserGruposModel() {
        return userGruposModel;
    }

    public void setUserGruposModel(UserGruposModel userGruposModel) {
        this.userGruposModel = userGruposModel;
    }

}

