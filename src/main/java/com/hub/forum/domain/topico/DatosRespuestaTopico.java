package com.hub.forum.domain.topico;

import lombok.Getter;

@Getter
public class DatosRespuestaTopico {
    private Long id;
    private String titulo;
    private String mensaje;
    private String usuario;
    private String curso;

    public DatosRespuestaTopico(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.usuario = topico.getUsuario().getNombre();
        this.curso = topico.getCurso();
    }

}
