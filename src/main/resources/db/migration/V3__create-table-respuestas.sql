CREATE TABLE respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(255) NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    fechaDeCreacion DATETIME NOT NULL,
    usuario_id BIGINT,
    topico_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
);