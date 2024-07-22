package com.api.parkingcontrol.repositories;
import com.api.parkingcontrol.Entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByNome(String nome);

}