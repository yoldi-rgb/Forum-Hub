package com.hub.forum.domain.usuario;

public record DatosUsuario( Long id, String nombre, String email) {

    public DatosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
