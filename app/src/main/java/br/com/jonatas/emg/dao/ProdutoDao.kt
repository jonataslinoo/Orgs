package br.com.jonatas.emg.dao

import br.com.jonatas.emg.model.Produto

class ProdutoDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}