package br.com.bercam.forum.service

import br.com.bercam.forum.dto.AtualizacaoTopicoForm
import br.com.bercam.forum.dto.NovoTopicoForm
import br.com.bercam.forum.dto.TopicoView
import br.com.bercam.forum.exception.NotFoundException
import br.com.bercam.forum.mapper.TopicoFormMapper
import br.com.bercam.forum.mapper.TopicoViewMapper
import br.com.bercam.forum.model.Topico
import br.com.bercam.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper,
    private var notFoundMessage: String = "Tópico não encontrado!"
) {


    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map { t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico =  repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{
        val topico =  repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}