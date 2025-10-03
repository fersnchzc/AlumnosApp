package com.example.alumnosapp.data.model

/**
 * Representa el modelo de datos para un alumno.
 *
 * @property id El identificador único del alumno.
 * @property nombre El nombre del alumno.
 * @property apellidos Los apellidos del alumno.
 * @property edad La edad del alumno.
 * @property curso El curso en el que está matriculado el alumno.
 * @property imageUrls La URL de la imagen de perfil del alumno.
 */
data class Alumno(
    val id: Int,
    val nombre: String,
    val apellidos: String,
    val edad: String,
    val curso: String,
    val imageUrls: String
)
