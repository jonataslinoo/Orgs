package br.com.jonatas.emg.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity
data class Produto(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagem: String? = null
)
