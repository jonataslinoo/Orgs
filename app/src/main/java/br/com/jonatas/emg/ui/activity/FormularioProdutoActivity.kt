package br.com.jonatas.emg.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.jonatas.emg.R
import br.com.jonatas.emg.database.AppDatabase
import br.com.jonatas.emg.databinding.ActivityFormularioProdutoBinding
import br.com.jonatas.emg.extensions.tryLoadImage
import br.com.jonatas.emg.model.Produto
import br.com.jonatas.emg.ui.dialog.FormularioImagemDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    private val produtoDao by lazy {
        AppDatabase.getInstance(this).produtoDao()
    }

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = getString(R.string.titulo_tela_formulario_produto)
        configuraBotaoSalvar()

        binding.activityFormularioProdutoImagem
            .setOnClickListener {
                FormularioImagemDialog(this).show(url) { url ->
                    this.url = url
                    binding.activityFormularioProdutoImagem.tryLoadImage(url)
                }
            }
    }

    private fun configuraBotaoSalvar() {
        binding.activityFormularioProdutoBotaoSalvar
            .setOnClickListener {
                val produtoNovo = criaProduto()
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        produtoDao.salva(produtoNovo)
                    }
                }
                finish()
            }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val campoValor = binding.activityFormularioProdutoValor

        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )
    }
}