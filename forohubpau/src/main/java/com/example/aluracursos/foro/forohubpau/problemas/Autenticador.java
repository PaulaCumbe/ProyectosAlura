package com.example.aluracursos.foro.forohubpau.problemas;
import com.example.aluracursos.foro.forohubpau.modelos.Usuario;
import com.example.aluracursos.foro.forohubpau.repositorio.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Autenticador implements UserDetailsService {
    @Autowired
    private UsuarioRep usuarioRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRep.findByLogin(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}

