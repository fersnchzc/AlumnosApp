package com.example.alumnosapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alumnosapp.data.model.Alumno
import com.example.alumnosapp.repository.AlumnoRepository
import com.example.alumnosapp.repository.AlumnoRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


//VIewMoDEOL
class AlumnoViewModel(
    //LLAMAMOS A LA IMPL
    private val repository: AlumnoRepository = AlumnoRepositoryImpl()
) : ViewModel() {

    // gUARDAMOS LA LISTA DE LAUMNOS EN UNA VARIABELE
    val alumnos: List<Alumno> = repository.getAlumnos()

   //PARTE PRIVADA Y PARTE PUBLICA DE EL alumno seleccionado
    private val _selectedAlumno = MutableStateFlow<Alumno?>(null)
    val selectedAlumno: StateFlow<Alumno?> = _selectedAlumno.asStateFlow()

    //Selecciona un alumno
    fun selectAlumno(alumnoId: Int) {
        //SIempre esta disponible
        val alumno = alumnos.find { it.id == alumnoId }
        _selectedAlumno.value = alumno
    }

  //Si fuese necesario borrar la seleccion de alumno(no lo usamos pero para las pruebas si)
    fun clearSelectedAlumno() {
        _selectedAlumno.value = null
    }
}

//EL viewMDOdel factory, copiado de los ejemplos anteriores vistos en clase
class AlumnoViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlumnoViewModel::class.java)) {
            // Creamos e inyectamos la implementación de datos quemados.
            return AlumnoViewModel(AlumnoRepositoryImpl()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}