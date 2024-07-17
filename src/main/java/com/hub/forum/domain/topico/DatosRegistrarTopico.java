package com.hub.forum.domain.topico;

import com.hub.forum.domain.respuesta.DatosRegistrarRespuesta;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DatosRegistrarTopico(@NotBlank
                                   String titulo,
                                   @NotBlank
                                   String mensaje,
                                   Status status,
                                   Long autorId,
                                   @NotBlank
                                   String usuario,
                                   @NotBlank
                                   String curso,
                                   List<DatosRegistrarRespuesta> respuestas) {
}
