package br.com.bercam.forum.mapper

import br.com.bercam.forum.dto.NovoCursoForm
import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.service.CursoService
import org.springframework.stereotype.Component

@Component
class CursoFormMapper(
    private var cursoService: CursoService
): Mapper<NovoCursoForm, Curso> {
    override fun map(t: NovoCursoForm): Curso {
       return Curso(
           nome = t.nome,
           categoria = t.categoria
       )
    }
}