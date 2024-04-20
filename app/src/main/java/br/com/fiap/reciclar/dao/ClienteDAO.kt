package br.com.fiap.reciclar.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.reciclar.model.Cliente



@Dao
interface ClienteDAO {

@Insert
fun salvar(cliente: Cliente): Long

@Query("SELECT * FROM  tbl_cliente WHERE loginCliente = :login AND senhaCliente = :senha")
fun validar(login : String , senha : String): Boolean


}