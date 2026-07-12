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
    puesto VARCHAR(50) NOT NULL,
    sueldo DOUBLE NOT NULL,
    PRIMARY KEY (numEmpleado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar datos iniciales en la tabla de alumnos
INSERT INTO alumnos (numExpediente, nombre, curp, grupo, promedio)
VALUES
(2023000001, 'Juan Perez Gomez', 'PEGJ010101HDFRRN01', 'G1', 8.5),
(2023000002, 'Maria Lopez Hernandez', 'LOHM020202MDFRRN02', 'G1', 9.2),
(2023000003, 'Carlos Ramirez Diaz', 'RADC030303HDFRRN03', 'G2', 7.8),
(2023000004, 'Ana Martinez Rodriguez', 'MARA040404MDFRRN04', 'G2', 9.5),
(2023000005, 'Luis Fernandez Torres', 'FETL050505HDFRRN05', 'G1', 8.0),
(2023000006, 'Sofia Sanchez Ruiz', 'SARS060606MDFRRN06', 'G3', 9.9),
(2023000007, 'Diego Castro Ortiz', 'CAOD070707HDFRRN07', 'G3', 6.5),
(2023000008, 'Laura Gomez Flores', 'GOFL080808MDFRRN08', 'G2', 8.8),
(2023000009, 'Pedro Alvarez Vazquez', 'ALVP090909HDFRRN09', 'G1', 7.2),
(2023000010, 'Elena Diaz Jimenez', 'DIJE101010MDFRRN10', 'G3', 9.0)
ON DUPLICATE KEY UPDATE
nombre = VALUES(nombre),
curp = VALUES(curp),
grupo = VALUES(grupo),
promedio = VALUES(promedio);

-- Insertar datos iniciales en la tabla de profesores (basados en el PDF y completados a 10)
INSERT INTO profesores (numEmpleado, nombre, curp, puesto, sueldo)
VALUES
(3, 'Sebastian Mendoza Montoya', 'MEMS070902HQTNNBA6', 'Maestro', 50000.0),
(2025, 'santiago', 'MEMS070902HQTNNBA6', 'MAESTRO', 10000.0),
(50723, 'RENE SANTOS OSORIO', 'RENEPROGRAMAP00071', 'INGENIERO DE SOFTWARE Y DOCENTE', 40000.0),
(78906, 'MARISOL MORALES RESENDIZ', 'MARISOLPROGRAMARED', 'INGENIERA EN REDES Y TELECOMUNICACIONES', 38000.0),
(79682, 'FERNANDO FERRUSCA ORTIZ', 'FERNANDOFERRUSCA12', 'RECTOR DE LA UTSJR', 100000.0),
(4, 'Patricia Gomez Vazquez', 'GOVP750405MDFRRN01', 'Investigador', 45000.0),
(5, 'Roberto Torres Luna', 'TOLR800812HDFRRN02', 'Asociado', 35000.0),
(6, 'Gabriela Rios Perez', 'RIPG851122MDFRRN03', 'Auxiliar', 25000.0),
(7, 'Fernando Morales Solis', 'MOSF900315HDFRRN04', 'Maestro', 40000.0),
(8, 'Monica Delgado Cruz', 'DECM920719MDFRRN05', 'Investigador', 48000.0)
ON DUPLICATE KEY UPDATE
nombre = VALUES(nombre),
curp = VALUES(curp),
puesto = VALUES(puesto),
sueldo = VALUES(sueldo);
