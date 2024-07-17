package com.hub.forum.domain.topico;

import com.hub.forum.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        Status status,
        Usuario usuario,
        String curso
) {
}
