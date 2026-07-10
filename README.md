# UniversidadUT - Sistema de Control Escolar

Este proyecto es una aplicación de consola en Java que implementa el patrón de arquitectura **Modelo-Vista-Controlador (MVC)** para gestionar el registro y consulta de alumnos y profesores. El sistema se comunica con una base de datos local relacional para persistir los datos de forma segura y eficiente.

---

## 👤 Información del Estudiante
* **Estudiante:** Kurt Cobain Vazquez Sanchez
* **Profesor:** Rene Santos Osorio
* **Base de Datos:** `soyKurtUT`

---

## 🛠️ Tecnologías y Dependencias
* **Lenguaje:** Java 25 (OpenJDK)
* **Gestor de Dependencias:** Maven
* **Base de Datos:** MariaDB / MySQL Server 
* **Conector JDBC:** `mysql-connector-j` (Versión 9.7.0)

---

## 📂 Arquitectura del Proyecto

El sistema está estructurado bajo el patrón **MVC** dentro del paquete `org.example`:

* **`modelo`**: Contiene las entidades de datos básicas.
  * `PersonaUt.java`: Clase base que define atributos comunes como `nombre` y `curp` (con validación de longitud a 18 caracteres).
  * `Alumno.java`: Hereda de `PersonaUt`. Incluye validaciones para el número de expediente (rango `2000000000` a `2140000000`), grupo y promedio (rango `0` a `10`).
  * `Profesor.java`: Hereda de `PersonaUt`. Incluye los atributos de `numEmpleado`, `nombreEmpleado`, `puesto` y `sueldo`.
* **`dao` (Data Access Object)**: Contiene la lógica de persistencia de datos y consultas SQL.
  * `AlumnoDAO.java`: Ejecuta operaciones de inserción (`INSERT`), lectura (`SELECT`) y actualización (`UPDATE`) sobre la tabla `alumnos`.
  * `ProfesorDAO.java`: Ejecuta operaciones de inserción, lectura y actualización sobre la tabla `profesores`.
* **`config`**: 
  * `Conexion.java`: Administra la conexión JDBC hacia la base de datos local `soyKurtUT` a través del puerto `3306`.
* **`vista`**:
  * `Menu.java`: Controla la interfaz de usuario por consola e interactúa con los objetos DAO para procesar la entrada de datos del usuario.
* **`Main.java`**: Punto de entrada principal para iniciar la ejecución del sistema.

---

## 🗄️ Estructura de la Base de Datos

El sistema requiere las siguientes tablas dentro del esquema `soyKurtUT`:

### Tabla `alumnos`
| Campo | Tipo | Restricción |
|---|---|---|
| `numExpediente` | INT | PRIMARY KEY |
| `nombre` | VARCHAR(150) | NOT NULL |
| `curp` | CHAR(18) | NOT NULL |
| `grupo` | VARCHAR(10) | NOT NULL |
| `promedio` | DOUBLE | NOT NULL |

### Tabla `profesores`
| Campo | Tipo | Restricción |
|---|---|---|
| `numEmpleado` | INT | PRIMARY KEY |
| `nombre` | VARCHAR(150) | NOT NULL |
| `curp` | CHAR(18) | NOT NULL |
| `nombreEmpleado` | VARCHAR(100) | NOT NULL |
| `puesto` | VARCHAR(50) | NOT NULL |
| `sueldo` | DOUBLE | NOT NULL |

---

## 🚀 Instrucciones de Compilación y Ejecución

Para compilar y ejecutar el proyecto desde la terminal utilizando Maven:

1. **Compilar el proyecto**:
   ```bash
   mvn compile
   ```

2. **Ejecutar la aplicación**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```