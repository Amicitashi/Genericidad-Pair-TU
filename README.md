# Ejercicio Genericidad: Clase Genérica Pair<T, U>

Este ejercicio implementa una clase genérica en Java llamada `Pair<T, U>` que permite almacenar un par de elementos de tipos diferentes. Además, los datos de la clase se guardan en una base de datos MySQL.

Configura la base de datos MySQL con las siguientes tablas:

CREATE DATABASE IF NOT EXISTS usuarios;

USE usuarios;

CREATE TABLE IF NOT EXISTS personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    edad INT
);

CREATE TABLE IF NOT EXISTS eps_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eps VARCHAR(100),
    fecha_nacimiento DATE
);


Datos de la persona insertados correctamente: (Juan Pérez, 30)
Datos de la EPS y la fecha de nacimiento insertados correctamente: (Salud Total, 1993-05-15)


# Evidencias de funcionamiento

![image](https://github.com/user-attachments/assets/4c38ec0a-ebdf-41d7-a275-6f5d75e2890f)






