package com.example.aluracursos.foro.forohubpau.controlador;
import com.example.aluracursos.foro.forohubpau.datos.DatosAutenticador;
import com.example.aluracursos.foro.forohubpau.datos.DatosToken;
import com.example.aluracursos.foro.forohubpau.modelos.Usuario;
import com.example.aluracursos.foro.forohubpau.problemas.Token;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticadorControl {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Token tokenService;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticador datosAutenticador) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticador.login(), datosAutenticador.password());
        var autenticacion = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosToken(tokenJWT));
    }
}


