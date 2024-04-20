package br.com.fiap.reciclar.repository

import android.content.Context
import br.com.fiap.reciclar.dao.ReciclarDb
import br.com.fiap.reciclar.model.Cliente

class ClienteRepository (context: Context) {

    private val db = ReciclarDb.getDatabese(context).clienteDao()

    fun salvar (cliente:Cliente): Long{
        return  db.salvar(cliente)
    }
    fun  validar (cliente: Cliente): Boolean{

        return  db.validar(cliente.loginCliente , cliente.senhaCliente)
    }
}