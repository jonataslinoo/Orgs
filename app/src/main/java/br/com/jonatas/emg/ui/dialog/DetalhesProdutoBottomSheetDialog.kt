package br.com.jonatas.emg.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import br.com.jonatas.emg.databinding.DetalhesProdutoBinding
import br.com.jonatas.emg.extensions.formatBrazilianCurrency
import br.com.jonatas.emg.extensions.tryLoadImage
import br.com.jonatas.emg.model.Produto
import com.google.android.material.bottomsheet.BottomSheetDialog

class DetalhesProdutoBottomSheetDialog(
    private val context: Context,
    private val produto: Produto
) {

    fun show() {
        val binding = DetalhesProdutoBinding
            .inflate(LayoutInflater.from(context))

        binding.apply {
            bottomSheetDetalhesProdutoNome.text = produto.nome
            bottomSheetDetalhesProdutoDescricao.text = produto.descricao
            bottomSheetDetalhesProdutoValor.text = produto.valor.formatBrazilianCurrency()
            bottomSheetDetalhesProdutoImageview.tryLoadImage(produto.imagem)
        }

        BottomSheetDialog(context).apply {
            setContentView(binding.root)
            show()
        }
    }
}