package br.com.jonatas.emg.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.jonatas.emg.R
import br.com.jonatas.emg.dao.ProdutoDao
import br.com.jonatas.emg.databinding.ActivityListaProdutosBinding
import br.com.jonatas.emg.ui.dialog.DetalhesProdutoBottomSheetDialog
import br.com.jonatas.emg.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    val dao = ProdutoDao()
    val adapter by lazy {
        ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = getString(R.string.titulo_tela_lista_produtos)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
        adapter.quandoClicadoNoItemListener = { produtoCliado ->
            DetalhesProdutoBottomSheetDialog(
                this,
                produtoCliado
            ).show()
        }
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutosFab
        fab.setOnClickListener {
            vaiParaTelaFormularioProduto()
        }
    }

    private fun vaiParaTelaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }
}