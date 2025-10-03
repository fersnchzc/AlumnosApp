package com.example.alumnosapp.repository

import com.example.alumnosapp.data.model.Alumno

//Datos para la lista de alumnos
val nombreAlumno : List<String> = listOf(
    "Fernando", "Juan", "David", "Maria", "Jose", "Marina", "Pablo", "Pau", "Ariel", "Uriel"
)

val apellidos : List<String> = listOf(
    "Contreras", "Gonzalez", "Martinez", "Sanchez", "Alvarez", "García", "Fernández", "Pérez", "López", "Gómez"
)

val edad : List<String> = listOf("17", "18", "20", "19", "21")

val curso : List<String> = listOf("Primero", "Segundo", "Tercero", "Cuarto", "Quinto")

val alumnoImageUrl : List<String> = listOf(
    // 1. Joven estudiando con tablet en la biblioteca
    "https://media.istockphoto.com/id/1626853870/es/foto/un-hombre-de-negocios-enfocado-trabajando-en-su-computadora.jpg?s=612x612&w=0&k=20&c=M_gtZfOu7KtI67G5hwMuuFDdDh2AoXu7ikI4_n9LngU=",

    // 2. Estudiante sonriendo con libros
    "https://media.istockphoto.com/id/1276837818/es/foto/focuses-hombre-calcular-gastos-pagar-facturas-en-l%C3%ADnea.jpg?s=612x612&w=0&k=20&c=cOda3yns4PpgZZsAfcWVYzytnkhR4Dg1ZW9FBNvDu5g=",

    // 3. Estudiante sentada con cuaderno
    "https://media.istockphoto.com/id/1490134483/es/foto/mujer-comprando-en-l%C3%ADnea.jpg?s=612x612&w=0&k=20&c=d6PcruYTLZfNlYevYVsPU3vU4F5lqEZfjqNDErrSAos="
)
//Interfaz de AlumnoRepository pedida por el eunnciado

interface AlumnoRepository {
    fun getAlumnos(): List<Alumno>
}