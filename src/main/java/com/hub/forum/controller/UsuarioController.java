package com.hub.forum.controller;

import com.hub.forum.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private  UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<DatosUsuario> crearUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {;
        Usuario usuario = new Usuario(
                datos.nombre(),
                datos.email(),
                datos.clave()
        );
        Usuario usuarioGuardado = repository.save(usuario);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioGuardado.getId())
                .toUri();

        return ResponseEntity.created(location).body(new DatosUsuario(usuarioGuardado));

    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosUsuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        return ResponseEntity.ok(new DatosUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuarios(Pageable paginacion){
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoUsuario::new));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarUsuario(@PathVariable Long id, @RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Usuario no fue encontrado"));
        usuario.actualizarDatos(datosActualizarUsuario);
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }



}
