package com.jp.demo.service;

import com.jp.demo.model.ProdutoModel;
import com.jp.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ProdutoModel cadastrar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, ProdutoModel produtoModel) {
        ProdutoModel produto = produtoRepository.findById(id).get();

        produto.setNome(produtoModel.getNome());
        produto.setPreco(produtoModel.getPreco());
        produto.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());

        return produtoRepository.save(produto);
    }
}
