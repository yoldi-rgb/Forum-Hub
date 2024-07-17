package com.hub.forum.domain.topico;

import com.hub.forum.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        Status status,
        Usuario usuario,
        String curso
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion(),
                topico.getStatus(), topico.getUsuario(), topico.getCurso()
        );
    }
}
