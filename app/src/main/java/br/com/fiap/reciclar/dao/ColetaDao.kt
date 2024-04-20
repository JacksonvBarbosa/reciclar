package br.com.fiap.reciclar.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.reciclar.model.Cliente
import br.com.fiap.reciclar.model.Coleta

@Dao
interface ColetaDao {

    @Insert
    fun salvar(coleta: Coleta): Long


    @Query("SELECT * FROM  tbl_coleta")
    fun listarColeta(): List<Coleta>




}