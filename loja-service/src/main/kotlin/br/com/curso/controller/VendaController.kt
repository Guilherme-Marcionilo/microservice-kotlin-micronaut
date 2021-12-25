package br.com.curso.controller

import br.com.curso.dto.input.VendaInput
import br.com.curso.service.VendaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vendas")
class VendaController(private val vendaService: VendaService){

    @Post
    fun realizarVenda(@Body vendaInput: VendaInput): HttpResponse<Any> {
        val possivelVenda = vendaService.realizarVenda(vendaInput)
        return HttpResponse.ok(possivelVenda)
    }
}