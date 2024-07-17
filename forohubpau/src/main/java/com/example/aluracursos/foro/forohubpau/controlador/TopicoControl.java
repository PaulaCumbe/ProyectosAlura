package com.example.aluracursos.foro.forohubpau.controlador;
import com.example.aluracursos.foro.forohubpau.Datos.*;
import com.example.aluracursos.foro.forohubpau.datos.DatosListaTop;
import com.example.aluracursos.foro.forohubpau.datos.DatosRegistroTop;
import com.example.aluracursos.foro.forohubpau.datos.DatosTop;
import com.example.aluracursos.foro.forohubpau.datos.DatoscheckTop;
import com.example.aluracursos.foro.forohubpau.modelos.Topicos;
import com.example.aluracursos.foro.forohubpau.repositorio.TopicoRep;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoControl {
    @Autowired
    private TopicoRep topicoRep;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTop(@RequestBody @Valid DatosRegistroTop datosRegistroTop,
                                       UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topicos(datosRegistroTop);
        topicoRep.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosTop(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTop>> dtoslistTop(@PageableDefault(size = 5, sort = {"curso"}) Pageable pageable) {
        var page = topicoRep.findAll(pageable).map(DatosListaTop::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity checkTop(@RequestBody @Valid DatoscheckTop datoscheckTop) {
        var topico = topicoRep.getReferenceById(datoscheckTop.id());
        topico.actualizarInformacion(datoscheckTop);
        return ResponseEntity.ok(new DatosTop(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTop(@PathVariable Long id) {
        Topicos topico = topicoRep.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.noContent().build();
        }
        topicoRep.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity revisaTop(@PathVariable Long id) {
        var topico = topicoRep.getReferenceById(id);
        return ResponseEntity.ok(new DatosTop(topico));
    }
}

