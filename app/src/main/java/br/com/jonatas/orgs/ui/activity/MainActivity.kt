package br.com.jonatas.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.jonatas.orgs.R
import br.com.jonatas.orgs.dao.ProdutoDao
import br.com.jonatas.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fabNovaNota = findViewById<FloatingActionButton>(R.id.fab_nova_nota)
        fabNovaNota.setOnClickListener {
            Intent(this, FormularioProdutoActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val dao = ProdutoDao()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    }
}