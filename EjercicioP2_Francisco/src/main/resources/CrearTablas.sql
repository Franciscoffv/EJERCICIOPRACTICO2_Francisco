-- Eliminar usuario si ya existe (evita el Error 1396)
DROP USER IF EXISTS 'Francisco'@'%';

-- Crear usuario de conexión
CREATE USER 'Francisco'@'%' IDENTIFIED BY 'Francisco.';

-- Crear base de datos (la elimina primero si ya existe para evitar errores)
DROP DATABASE IF EXISTS cine_teatro_db;
CREATE DATABASE cine_teatro_db;

-- Otorgar permisos al usuario sobre la base de datos
GRANT ALL PRIVILEGES ON cine_teatro_db.* TO 'Francisco'@'%';
FLUSH PRIVILEGES;

-- Seleccionar la base de datos
USE cine_teatro_db;

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255),
    rol VARCHAR(20)
);

-- Crear tabla de películas u obras
CREATE TABLE IF NOT EXISTS peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150),
    tipo VARCHAR(20) -- 'PELICULA' o 'OBRA'
);

-- Crear tabla de funciones
CREATE TABLE IF NOT EXISTS funciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pelicula INT,
    fecha DATE,
    hora TIME,
    sala VARCHAR(50),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id)
);

-- Crear tabla de reservas
CREATE TABLE IF NOT EXISTS reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_funcion INT,
    cantidad INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_funcion) REFERENCES funciones(id)
);