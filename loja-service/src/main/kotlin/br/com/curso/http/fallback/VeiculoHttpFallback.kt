package br.com.curso.http.fallback

import br.com.curso.config.ConexaoRedis
import br.com.curso.dto.output.Veiculo
import br.com.curso.http.VeiculoHttp
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.retry.annotation.Fallback


@Fallback
class VeiculoHttpFallback (private val objectMapper: ObjectMapper): VeiculoHttp {
    override fun findById(id: Long): Veiculo {
        val jedis = ConexaoRedis.getConexao()
        val veiculoJSON = jedis.get(id.toString())
        val veiculo = objectMapper.readValue(veiculoJSON, Veiculo::class.java)
        return veiculo
    }
}