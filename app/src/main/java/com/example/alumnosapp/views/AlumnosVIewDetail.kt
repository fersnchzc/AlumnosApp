package com.example.alumnosapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.alumnosapp.viewmodel.AlumnoViewModel
import com.example.alumnosapp.viewmodel.AlumnoViewModelFactory
import io.ktor.websocket.Frame

//Vista de detalle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Recibimos el ID, EL VIEWMODLE Y EL NACONTORLLER
fun AlumnoViewDetail(
    alumnoId: Int,
    viewModel: AlumnoViewModel = viewModel(factory = AlumnoViewModelFactory()),
    navController: NavHostController
) {
    LaunchedEffect(alumnoId) {
        viewModel.selectAlumno(alumnoId)
    }
    //Variable auxiliar para ver cual esta sleeccionado
    val alumno by viewModel.selectedAlumno.collectAsState()

    Scaffold(
        //Barra superior con flecha de atras, reutilizada de codigos antiguos
        topBar = { BarraSuperirosAtras(title = "Detalle del Alumno", showBackButton = true, onBackButtonClicked = { navController.popBackStack() }) }
    ) { paddingValues ->

        alumno?.let { a ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Usamos AsynciIMAGE
                AsyncImage(
                    model = a.imageUrls,
                    contentDescription = "Foto de ${a.nombre}",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Información
                Text("ID: ${a.id}", style = MaterialTheme.typography.bodySmall)
                Text("Nombre: ${a.nombre} ${a.apellidos}", style = MaterialTheme.typography.headlineMedium)
                Text("Edad: ${a.edad}", style = MaterialTheme.typography.titleMedium)
                Text("Curso: ${a.curso}", style = MaterialTheme.typography.titleMedium)
            }
        } ?: run {
           //Por si no se encuentra el alumno
            Text("Alumno no encontrado.", modifier = Modifier.padding(paddingValues))
        }
    }
}
//Barra superior con flecha de atras generada por gemini
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperirosAtras(
    modifier: Modifier = Modifier,
    title: String = "Lista de Empleados", // Hacemos el título dinámico
    showBackButton: Boolean = false, // Nuevo parámetro para controlar la visibilidad de la flecha
    onBackButtonClicked: () -> Unit = {} // Nuevo parámetro para el evento de clic
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        navigationIcon = { // Añadimos el icono de navegación
            if (showBackButton) {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Icono de flecha hacia atrás
                        contentDescription = "Atrás",
                        tint = Color.White
                    )
                }
            }
        }
    )
}
