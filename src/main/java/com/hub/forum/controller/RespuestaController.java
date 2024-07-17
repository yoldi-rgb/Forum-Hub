package com.hub.forum.controller;

import com.hub.forum.domain.respuesta.DatosRegistrarRespuesta;
import com.hub.forum.domain.respuesta.Respuesta;
import com.hub.forum.domain.respuesta.RespuestaRepository;
import com.hub.forum.domain.topico.Topico;
import com.hub.forum.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/topicos/{topicoId}/respuestas")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;

    public RespuestaController(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@PathVariable Long topicoId, @RequestBody @Valid DatosRegistrarRespuesta datosRegistroRespuesta) {
        var topico = topicoRepository.findById(topicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        var respuesta = new Respuesta(datosRegistroRespuesta, topico);
        var respuestaGuardar = respuestaRepository.save(respuesta);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaGuardar);
    }


}
