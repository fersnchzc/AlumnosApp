package com.example.alumnosapp.repository

import com.example.alumnosapp.data.model.Alumno

/**
 * Lista de nombres de ejemplo para generar alumnos.
 */
val nombreAlumno: List<String> = listOf(
    "Fernando", "Juan", "David", "Maria", "Jose", "Marina", "Pablo", "Pau", "Ariel", "Uriel"
)

/**
 * Lista de apellidos de ejemplo para generar alumnos.
 */
val apellidos: List<String> = listOf(
    "Contreras", "Gonzalez", "Martinez", "Sanchez", "Alvarez", "García", "Fernández", "Pérez", "López", "Gómez"
)

/**
 * Lista de edades de ejemplo para generar alumnos.
 */
val edad: List<String> = listOf("17", "18", "20", "19", "21")

/**
 * Lista de cursos de ejemplo para generar alumnos.
 */
val curso: List<String> = listOf("Primero", "Segundo", "Tercero", "Cuarto", "Quinto")

/**
 * Lista de URLs de imágenes de ejemplo para los perfiles de los alumnos.
 */
val alumnoImageUrl: List<String> = listOf(
    // 1. Joven estudiando con tablet en la biblioteca
    "https://media.istockphoto.com/id/1626853870/es/foto/un-hombre-de-negocios-enfocado-trabajando-en-su-computadora.jpg?s=612x612&w=0&k=20&c=M_gtZfOu7KtI67G5hwMuuFDdDh2AoXu7ikI4_n9LngU=",

    // 2. Estudiante sonriendo con libros
    "https://media.istockphoto.com/id/1276837818/es/foto/focuses-hombre-calcular-gastos-pagar-facturas-en-l%C3%ADnea.jpg?s=612x612&w=0&k=20&c=cOda3yns4PpgZZsAfcWVYzytnkhR4Dg1ZW9FBNvDu5g=",

    // 3. Estudiante sentada con cuaderno
    "https://media.istockphoto.com/id/1490134483/es/foto/mujer-comprando-en-l%C3%ADnea.jpg?s=612x612&w=0&k=20&c=d6PcruYTLZfNlYevYVsPU3vU4F5lqEZfjqNDErrSAos="
)

/**
 * Interfaz que define las operaciones para obtener datos de alumnos.
 */
interface AlumnoRepository {
    /**
     * Devuelve una lista de alumnos.
     *
     * @return Una lista de [Alumno].
     */
    fun getAlumnos(): List<Alumno>
}
