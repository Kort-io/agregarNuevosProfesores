-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS soyKurtUT;
USE soyKurtUT;

-- Crear la tabla de alumnos
CREATE TABLE IF NOT EXISTS alumnos (
    numExpediente INT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    curp CHAR(18) NOT NULL,
    grupo VARCHAR(50) NOT NULL,
    promedio DOUBLE NOT NULL,
    PRIMARY KEY (numExpediente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear la tabla de profesores
CREATE TABLE IF NOT EXISTS profesores (
    numEmpleado INT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    curp CHAR(18) NOT NULL,
    nombreEmpleado VARCHAR(100) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    sueldo DOUBLE NOT NULL,
    PRIMARY KEY (numEmpleado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar datos iniciales en la tabla de profesores (basados en el PDF)
INSERT INTO profesores (numEmpleado, nombre, curp, nombreEmpleado, puesto, sueldo) 
VALUES 
(3, 'Sebastian Mendoza Montoya', 'MEMS070902HQTNNBA6', 'Sebastian', 'Maestro', 50000.0),
(2025, 'santiago', 'MEMS070902HQTNNBA6', 'Santi', 'MAESTRO', 10000.0)
ON DUPLICATE KEY UPDATE 
nombre = VALUES(nombre), 
curp = VALUES(curp), 
nombreEmpleado = VALUES(nombreEmpleado), 
puesto = VALUES(puesto), 
sueldo = VALUES(sueldo);
