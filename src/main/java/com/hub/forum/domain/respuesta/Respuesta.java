package com.hub.forum.domain.respuesta;


import com.hub.forum.domain.topico.Topico;
import com.hub.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;


@Entity(name = "respuesta")
@Table(name = "Respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String usuario;
    private LocalDateTime fechaDeCreacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioDeTopico;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;


    public Respuesta(DatosRegistrarRespuesta datosRegistroRespuesta, Topico topico) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.usuario = datosRegistroRespuesta.usuario();
        this.topico = topico;
        this.usuarioDeTopico = topico.getUsuario();
    }

}
