package com.example.todo_example.api

import com.example.todo_example.model.Categoria
import com.example.todo_example.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefa")
    // suspend so é executado dentro de uma corrotina
    suspend fun addTarefa(@Body tarefa: Tarefa): Response<Tarefa>

    @GET("tarefa")
    suspend fun listTarefa(): Response<List<Tarefa>>
}