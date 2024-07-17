package com.hub.forum.domain.usuario;

public record DatosListadoUsuario(
        Long id,
        String nombre
        )
{
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }

}
