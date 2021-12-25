package br.com.curso.service

import br.com.curso.model.Veiculo
import br.com.curso.repository.VeiculoRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class VeiculoService (private val veiculoRepository: VeiculoRepository){

    fun create(veiculo: Veiculo): Veiculo {
        return veiculoRepository.save(veiculo)
    }

    fun findById (id: Long): Optional<Veiculo> {
        return veiculoRepository.findById(id)
    }


}