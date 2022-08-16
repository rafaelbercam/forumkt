package br.com.bercam.forum.repository

import br.com.bercam.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long > {
}