package br.com.jonatas.emg.extensions

import android.widget.ImageView
import br.com.jonatas.emg.R
import coil.load


fun ImageView.tryLoadImage(url: String? = null, fallback: Int = R.drawable.imagem_padrao) {
    load(url) {
        placeholder(R.drawable.loading)
        fallback(fallback)
        error(R.drawable.imagem_padrao)
    }
}