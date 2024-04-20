package br.com.fiap.reciclar.model

import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "tbl_coleta")
data class Coleta(

    @PrimaryKey(autoGenerate = true)
    val codColeta: Long = 0,

    val tipoResiduo: String = "",
    val dataColeta: String = "",
    val periodoColeta: String = "",
    val enderecoColeta: String = ""


)
