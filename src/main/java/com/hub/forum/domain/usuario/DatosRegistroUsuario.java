package com.hub.forum.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuario
        (
                @NotBlank
                String nombre,
                @Email
                @NotBlank
                String email,
                @NotBlank
                String clave
        ) {
}
