package br.com.fiap.reciclar.repository

import android.content.Context
import br.com.fiap.reciclar.dao.ReciclarDb
import br.com.fiap.reciclar.model.Cliente
import br.com.fiap.reciclar.model.Coleta

class coletaRepository (context: Context) {

    private val db = ReciclarDb.getDatabese(context).coletaDao()

    fun salvar (coleta: Coleta): Long{
        return  db.salvar(coleta)
    }
    fun  listarcoleta(): List<Coleta> {

        return db.listarColeta()
    }
}