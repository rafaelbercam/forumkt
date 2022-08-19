package br.com.bercam.forum.mapper

import br.com.bercam.forum.dto.NovoTopicoForm
import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Topico
import br.com.bercam.forum.service.CursoService
import br.com.bercam.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        val curso = cursoService.buscarPorId(t.idCurso)
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso), //como alterar o CusoView para Curso da entidade?
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
