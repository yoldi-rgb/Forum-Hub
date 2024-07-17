CREATE TABLE topicos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha_de_creacion DATETIME NOT NULL,
    status status_enum NOT NULL,
    usuario_id BIGINT,
    curso VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);