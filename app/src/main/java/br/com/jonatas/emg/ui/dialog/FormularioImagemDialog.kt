package br.com.jonatas.emg.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.jonatas.emg.R
import br.com.jonatas.emg.databinding.FormularioImagemBinding
import br.com.jonatas.emg.extensions.tryLoadImage

class FormularioImagemDialog(private val context: Context) {

    fun show(
        urlPadrao: String? = null,
        quandoCarregaImagem: (url: String) -> Unit
    ) {
        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {
                
                urlPadrao?.let { urlRecebida ->
                    formularioImagemImageview.tryLoadImage(urlRecebida)
                    formularioImagemUrl.setText(urlRecebida)
                }

                formularioImagemBotaoCarregar.setOnClickListener {
                    val url = formularioImagemUrl.text.toString()
                    formularioImagemImageview.tryLoadImage(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton(context.getString(R.string.text_button_dialog_confirmar)) { _, _ ->
                        val url = formularioImagemUrl.text.toString()
                        quandoCarregaImagem(url)
                    }
                    .setNegativeButton(context.getString(R.string.text_button_dialog_cancelar)) { _, _ ->
                    }
                    .show()
            }
    }
}