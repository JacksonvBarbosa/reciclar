package br.com.fiap.reciclar.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.reciclar.model.Cliente
import br.com.fiap.reciclar.model.Coleta

@Database(entities = [Coleta::class,Cliente::class],version=3)
abstract class ReciclarDb : RoomDatabase() {

   abstract fun clienteDao(): ClienteDAO

    abstract fun coletaDao(): ColetaDao

   companion object{

       lateinit var instanciaBanco : ReciclarDb



       fun getDatabese(context: Context): ReciclarDb{



           if(!::instanciaBanco.isInitialized){

               instanciaBanco = Room
                   .databaseBuilder(
                       context = context,
                       klass = ReciclarDb::class.java,
                       name="db_recicle")
                   .allowMainThreadQueries()
                   .fallbackToDestructiveMigration()
                   .build()


           }
           return instanciaBanco

       }
   }

}