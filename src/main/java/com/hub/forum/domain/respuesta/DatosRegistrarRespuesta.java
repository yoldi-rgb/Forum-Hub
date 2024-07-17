package com.hub.forum.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarRespuesta(@NotBlank
                                      String mensaje,
                                      @NotBlank
                                      String usuario) {
}
