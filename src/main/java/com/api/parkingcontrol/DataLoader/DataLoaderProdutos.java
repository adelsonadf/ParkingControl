package com.api.parkingcontrol.DataLoader;

import com.api.parkingcontrol.dtos.ProdutoDTO;
import com.api.parkingcontrol.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoaderProdutos implements CommandLineRunner {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(String... args) throws Exception {


/*        Long produtoId = 1L;  // ID do produto que você deseja consultar

        Optional<Produto> produto = produtoRepository.findById(produtoId);

        // Verificar se o produto foi encontrado e exibir os detalhes
        if (produto.isPresent()) {
            Produto p = produto.get();
            System.out.println("Produto encontrado: ID = " + p.getId() + ", Nome = " + p.getNome() + ", Preço = " + p.getPreco());
        } else {
            System.out.println("Produto com ID " + produtoId + " não encontrado.");
        }*/



        ProdutoDTO produto1 = new ProdutoDTO();
        produto1.setNome("Produto A");
        produto1.setPreco(10.99);

        ProdutoDTO produto2 = new ProdutoDTO();
        produto2.setNome("Produto B");
        produto2.setPreco(15.99);

        if (produtoService.salvarProduto(produto1) != null) {
            System.out.println("Produto A inserido.");
        } else {
            System.out.println("Produto A já existe.");
        }

        if (produtoService.salvarProduto(produto2) != null) {
            System.out.println("Produto B inserido.");
        } else {
            System.out.println("Produto B já existe.");
        }
    }
}