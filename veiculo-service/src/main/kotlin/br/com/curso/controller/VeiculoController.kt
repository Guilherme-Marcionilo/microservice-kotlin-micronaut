package br.com.curso.controller

import br.com.curso.model.Veiculo
import br.com.curso.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import java.util.*

@Validated
@Controller("/veiculos")
class VeiculoController (private val veiculoService: VeiculoService) {

    @Post
    fun create(@Body request: Veiculo): HttpResponse<Any> {
        val possivelVeiculo = veiculoService.create(request)
        return HttpResponse.created(possivelVeiculo)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): HttpResponse<Optional<Veiculo>> {
        val possivelVeiculo = veiculoService.findById(id)
        return HttpResponse.ok(possivelVeiculo)
    }
}