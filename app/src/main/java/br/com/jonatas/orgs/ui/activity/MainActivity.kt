package br.com.jonatas.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.jonatas.orgs.R
import br.com.jonatas.orgs.model.Produto
import br.com.jonatas.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "Cesta de Frutas",
                    descricao = "Laranja, manga e maçã",
                    valor = BigDecimal(
                        "19.99"
                    )
                ),
                Produto(
                    nome = "Cesta de Frutas 2",
                    descricao = "Laranja, manga e uva",
                    valor = BigDecimal("9.99")
                ),
                Produto(
                    nome = "Cesta de Frutas 3",
                    descricao = "Laranja, manga e banana",
                    valor = BigDecimal("29.99")
                )
            )
        )
    }
}