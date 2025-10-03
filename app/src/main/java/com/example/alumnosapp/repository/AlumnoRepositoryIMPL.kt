package com.example.alumnosapp.repository

import com.example.alumnosapp.data.model.Alumno

// generacion de los alumnos, con la funcion getALiumnos
class AlumnoRepositoryImpl : AlumnoRepository {
    override fun getAlumnos(): List<Alumno> {
        val alumnos = mutableListOf<Alumno>()

        for(i in 0 until 50 ){
            val alumno = Alumno(

                nombre = nombreAlumno[i % nombreAlumno.size],
                apellidos = apellidos[i % apellidos.size],
                edad = edad[i % edad.size],
                curso = curso[i % curso.size],
                imageUrls = alumnoImageUrl[i % alumnoImageUrl.size],
                id = i
            )
            alumnos.add(alumno)
        }
        return alumnos

    }
}