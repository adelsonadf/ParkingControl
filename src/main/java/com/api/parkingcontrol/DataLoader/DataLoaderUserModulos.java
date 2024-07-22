package com.api.parkingcontrol.DataLoader;

import com.api.parkingcontrol.dtos.UserModulosDto;
import com.api.parkingcontrol.services.UserModulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderUserModulos implements CommandLineRunner {
    @Autowired
    private UserModulosService userModulosService;

    @Override
    public void run(String... args) throws Exception {

        UserModulosDto tb_usuarios_modulos1 = new UserModulosDto();
        tb_usuarios_modulos1.setUserModuloNome("Financeiro");

        UserModulosDto tb_usuarios_modulos2 = new UserModulosDto();
        tb_usuarios_modulos2.setUserModuloNome("Compras");

        UserModulosDto tb_usuarios_modulos3 = new UserModulosDto();
        tb_usuarios_modulos3.setUserModuloNome("Faturamento");

        UserModulosDto tb_usuarios_modulos4 = new UserModulosDto();
        tb_usuarios_modulos4.setUserModuloNome("Administrativo");

        if (userModulosService.salvartb_usuarios_modulos(tb_usuarios_modulos1)  != null) {
            System.out.println("Modulo Financeiro inserido.");
        } else {
            System.out.println("Modulo Financeiro já existe.");
        }

        if (userModulosService.salvartb_usuarios_modulos(tb_usuarios_modulos2)  != null) {
            System.out.println("Modulo Compras inserido.");
        } else {
            System.out.println("Modulo Compras já existe.");
        }

        if (userModulosService.salvartb_usuarios_modulos(tb_usuarios_modulos3)  != null) {
            System.out.println("Modulo Faturamento inserido.");
        } else {
            System.out.println("Modulo Faturamento já existe.");
        }

        if (userModulosService.salvartb_usuarios_modulos(tb_usuarios_modulos4)  != null) {
            System.out.println("Modulo Administrativo inserido.");
        } else {
            System.out.println("Modulo Administrativo já existe.");
        }


        System.out.println("Dados iniciais inseridos.");
    }
}