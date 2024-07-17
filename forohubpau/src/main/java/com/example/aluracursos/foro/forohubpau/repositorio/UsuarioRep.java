package com.example.aluracursos.foro.forohubpau.repositorio;

import com.example.aluracursos.foro.forohubpau.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRep extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}
