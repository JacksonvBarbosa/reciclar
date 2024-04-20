package br.com.fiap.reciclar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_cliente")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val codCliente: Long = 0,

    val nomeCliente: String = "",
    val cpfCliente: String = "",
    val enderecoClient: String = "",
    val telefoneCliente: String = "",
    val loginCliente: String = "",
    val senhaCliente: String = ""

)
