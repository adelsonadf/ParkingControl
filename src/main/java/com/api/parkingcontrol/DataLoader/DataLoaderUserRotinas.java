package com.api.parkingcontrol.DataLoader;

import com.api.parkingcontrol.dtos.UserRotinasDto;
import com.api.parkingcontrol.repositories.UserModulosRepository;
import com.api.parkingcontrol.services.UserRotinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderUserRotinas implements CommandLineRunner {
    @Autowired
    private UserRotinasService userRotinasService;

    private UserModulosRepository userModulosRepository;

    @Override
    public void run(String... args) throws Exception {

        UserRotinasDto rotina1 = new UserRotinasDto();
        rotina1.setUserRotinaNome("Usuarios");
        rotina1.setUserRotinaDireitos("ABCDEFG");
        rotina1.setId_modulo(1);
        if (userRotinasService.salvarUserRotina(rotina1)  != null) {
            System.out.println("Rotina Usuarios inserido.");
        } else {
            System.out.println("Rotina Usuarios já existe.");
        }



        System.out.println("Dados Rotina inseridos.");
    }
}