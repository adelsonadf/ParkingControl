package com.api.parkingcontrol.dtos;
import com.api.parkingcontrol.models.UserGruposModel;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class UserDto {


    @NotBlank
    private String userName;
    @NotBlank
    private String userSenha;
    @NotBlank
    private String userFone;
    @NotBlank
    private String userEmail;

    @NotNull
    private int userGrupo;

    @NotNull
    private int userStatus;


    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private  LocalDate aniversarioDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private  LocalDate registrationDate;

    public LocalDate getUltimoAcessoDate() {
        return ultimoAcessoDate;
    }

    public void setUltimoAcessoDate(LocalDate ultimoAcessoDate) {
        this.ultimoAcessoDate = ultimoAcessoDate;
    }

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private  LocalDate ultimoAcessoDate;



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

    public int getUserGrupo() {  return userGrupo;  }

    public void setUserGrupo(int userGrupo) {
        this.userGrupo = userGrupo;
    }

    public int getUserStatus() {  return userStatus;  }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public LocalDate getAniversarioDate() {  return aniversarioDate;  }

    public void setAniversarioDate(LocalDate aniversarioDate) {
        this.aniversarioDate = aniversarioDate;
    }

    public LocalDate getRegistrationDate() {  return registrationDate;  }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }





}
