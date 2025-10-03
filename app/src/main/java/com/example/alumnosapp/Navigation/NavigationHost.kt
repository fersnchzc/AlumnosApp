package com.example.alumnosapp.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alumnosapp.views.AlumnoListScreen
import com.example.alumnosapp.views.AlumnoViewDetail

//RUtas
object Destinations {
    const val ALUMNOS_LIST = "alumnos_list"
    const val ALUMNO_DETAIL = "alumno_detail/{alumnoId}" // {alumnoId} es el argumento
}
//navegacion
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.ALUMNOS_LIST
    ) {
        // ruta de la lista (app rpicnipal)
        composable(Destinations.ALUMNOS_LIST) {
            AlumnoListScreen(
                // Aquí se define la acción de click: navegar a la ruta de detalle
                onAlumnoClick = { alumnoId ->
                    navController.navigate("alumno_detail/$alumnoId")
                }
            )
        }

        //  ruta del detall (detalle de los alumnos)
        composable(
            route = Destinations.ALUMNO_DETAIL,
            arguments = listOf(navArgument("alumnoId") { type = NavType.IntType })
        ) { backStackEntry ->

            // Extraer el argumento de la ruta(para volver a tras)
            val alumnoId = backStackEntry.arguments?.getInt("alumnoId")

            //mostrar la pantall de detalle
            if (alumnoId != null) {
                AlumnoViewDetail(
                    alumnoId = alumnoId,
                    navController = navController
                )
            } else {
                // Manejar error de de id
                Text("Error: Alumno ID no proporcionado")
            }
        }
    }
}