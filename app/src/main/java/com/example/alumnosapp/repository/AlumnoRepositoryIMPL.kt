package com.example.alumnosapp.repository

import com.example.alumnosapp.data.model.Alumno

/**
 * Implementación de [AlumnoRepository] que genera una lista de alumnos de prueba.
 */
class AlumnoRepositoryImpl : AlumnoRepository {
    /**
     * Devuelve una lista de 50 alumnos generados dinámicamente.
     *
     * @return Una lista de [Alumno].
     */
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
