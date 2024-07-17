package com.hub.forum.domain.topico;


import com.hub.forum.domain.respuesta.Respuesta;
import com.hub.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "topico")
@Table(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;


    public Topico(DatosRegistrarTopico datosTopico, Usuario autor) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.status = datosTopico.status();
        this.usuario = autor != null ? autor : new Usuario();
        this.curso = datosTopico.curso();
        this.respuestas = datosTopico.respuestas() != null
                ? datosTopico.respuestas().stream()
                .map(r -> new Respuesta(r, this))
                .collect(Collectors.toList())
                : new ArrayList<>();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.findById(this.id)
                .orElseThrow(() -> new IllegalArgumentException("El Topico no fue encontrado"));
        this.titulo = datosActualizarTopico.titulo() != null
                ? datosActualizarTopico.titulo() : this.titulo;
        this.mensaje = datosActualizarTopico.mensaje() != null
                ? datosActualizarTopico.mensaje() : this.mensaje;
        this.fechaDeCreacion = LocalDateTime.now();
        this.status = datosActualizarTopico.status() != null
                ? datosActualizarTopico.status() : this.status;
        this.curso = datosActualizarTopico.curso() != null
                ? datosActualizarTopico.curso() : this.curso;
    }
}


