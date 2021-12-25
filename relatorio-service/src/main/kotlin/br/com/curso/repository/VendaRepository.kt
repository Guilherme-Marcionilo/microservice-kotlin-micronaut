package br.com.curso.repository

import br.com.curso.model.Venda
import com.mongodb.client.MongoClient
import com.mongodb.client.result.InsertOneResult
import jakarta.inject.Singleton

@Singleton
class VendaRepository (private val mongoClient: MongoClient){

    fun create(venda: Venda): InsertOneResult {
        return getConnection().insertOne(venda)
    }

    fun getAll(): List<Venda> {
        return getConnection().find().toList()
    }

    fun getConnection() = mongoClient.getDatabase("vendas").getCollection("venda", Venda::class.java)
}