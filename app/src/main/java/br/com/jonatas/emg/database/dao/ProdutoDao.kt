package br.com.jonatas.emg.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.jonatas.emg.model.Produto

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun buscaTodos(): List<Produto>

    @Insert
    fun salva(vararg produto: Produto)
}