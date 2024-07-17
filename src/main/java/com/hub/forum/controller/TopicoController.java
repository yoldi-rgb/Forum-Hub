package com.hub.forum.controller;


import com.hub.forum.domain.topico.*;
import com.hub.forum.domain.usuario.Usuario;
import com.hub.forum.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private TopicoRepository repository;
    private UsuarioRepository usuarioRepository;

    public TopicoController(TopicoRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        }


    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@Valid @RequestBody DatosRegistrarTopico datos) {
        Usuario usuario = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Usuario no fue encontrado"));

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un tópico con el mismo título y mensaje");
        }

        Topico topico = new Topico(datos, usuario);
        var topicoGuardado = repository.save(topico);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(topicoGuardado.getId())
                .toUri();

        return ResponseEntity.created(location).body(new DatosRespuestaTopico(topicoGuardado));
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size=10,sort="titulo") Pageable paginacion){
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoTopico::new)) ;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalleTopico(@PathVariable Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        topico.actualizarDatos(datosActualizarTopico, repository);
        repository.save(topico);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        repository.delete(topico);
        return ResponseEntity.noContent().build();
    }





}
