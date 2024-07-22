package com.api.parkingcontrol.services;
import com.api.parkingcontrol.Entidades.Produto;
import com.api.parkingcontrol.dtos.ProdutoDTO;
import com.api.parkingcontrol.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        // Verificar se o produto já existe pelo nome (ou outro campo único)
        Produto produtoExistente = produtoRepository.findByNome(produtoDTO.getNome());
        if (produtoExistente != null) {
            // Produto já existe, não fazer nada ou lançar uma exceção
            return null;
        }

        // Converter DTO para entidade
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());

        // Salvar a entidade
        Produto savedProduto = produtoRepository.save(produto);

        // Converter entidade salva de volta para DTO
        ProdutoDTO savedProdutoDTO = new ProdutoDTO();
        savedProdutoDTO.setId(savedProduto.getId());
        savedProdutoDTO.setNome(savedProduto.getNome());
        savedProdutoDTO.setPreco(savedProduto.getPreco());

        return savedProdutoDTO;
    }

    public List<ProdutoDTO> listarProdutos() {
        return produtoRepository.findAll().stream().map(produto -> {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setId(produto.getId());
            produtoDTO.setNome(produto.getNome());
            produtoDTO.setPreco(produto.getPreco());
            return produtoDTO;
        }).collect(Collectors.toList());
    }
}