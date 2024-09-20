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
                valor = BigDecimal("19.99"),
                imagem = "https://images.pexels.com/photos/89778/strawberries-frisch-ripe-sweet-89778.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            Produto(
                nome = "Cesta de verduras",
                descricao = "Batata, pepino e cenoura",
                valor = BigDecimal("29.99"),
                imagem = "https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg"
            )
        )
    }
}