package br.com.jonatas.emg.dao

import br.com.jonatas.emg.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "Cesta de frutas",
                descricao = "Laranja, manga e uva",
                valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "Cesta de verduras",
                descricao = "Batata, pepino e cenoura",
                valor = BigDecimal("29.99")
            )
        )
    }
}