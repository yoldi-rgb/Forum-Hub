CREATE TABLE topicos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_de_creacion DATETIME NOT NULL,
    status ENUM('ACTIVO', 'CERRADO') NOT NULL,
    usuario_id BIGINT,
    curso VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);