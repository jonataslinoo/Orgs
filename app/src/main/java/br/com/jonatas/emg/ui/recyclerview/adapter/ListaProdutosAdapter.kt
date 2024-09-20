package br.com.jonatas.emg.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jonatas.emg.databinding.ProdutoItemBinding
import br.com.jonatas.emg.extensions.formatBrazilianCurrency
import br.com.jonatas.emg.extensions.tryLoadImage
import br.com.jonatas.emg.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>,
    var quandoClicadoNoItemListener: (produto: Produto) -> Unit = {}
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var produto: Produto

        private val nome = binding.produtoItemNome
        private val descricao = binding.produtoItemDescricao
        private val valor = binding.produtoItemValor
        private val imagem = binding.produtoItemImageview

        fun vincula(produto: Produto) {
            this.produto = produto
            nome.text = produto.nome
            descricao.text = produto.descricao
            valor.text = produto.valor.formatBrazilianCurrency()

            imagem.visibility = if (produto.imagem != null) View.VISIBLE else View.GONE
            imagem.tryLoadImage(produto.imagem)
        }

        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized) {
                    quandoClicadoNoItemListener(produto)
                }
            }
        }
    }
}
