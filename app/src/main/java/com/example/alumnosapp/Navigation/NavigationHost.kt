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

/**
 * Define las rutas de navegación de la aplicación.
 */
object Destinations {
    /**
     * Ruta para la pantalla que muestra la lista de alumnos.
     */
    const val ALUMNOS_LIST = "alumnos_list"

    /**
     * Ruta para la pantalla de detalle de un alumno.
     * Requiere un argumento `alumnoId`.
     */
    const val ALUMNO_DETAIL = "alumno_detail/{alumnoId}" // {alumnoId} es el argumento
}

/**
 * Componente principal de navegación de la aplicación.
 *
 * Configura el [NavHost] y define las diferentes rutas y sus destinos.
 */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.ALUMNOS_LIST
    ) {
        // Ruta para la pantalla de lista de alumnos.
        composable(Destinations.ALUMNOS_LIST) {
            AlumnoListScreen(
                // Define la acción al hacer clic en un alumno: navegar a la pantalla de detalle.
                onAlumnoClick = { alumnoId ->
                    navController.navigate("alumno_detail/$alumnoId")
                }
            )
        }

        // Ruta para la pantalla de detalle del alumno.
        composable(
            route = Destinations.ALUMNO_DETAIL,
            arguments = listOf(navArgument("alumnoId") { type = NavType.IntType })
        ) { backStackEntry ->

            // Extrae el ID del alumno de los argumentos de la ruta.
            val alumnoId = backStackEntry.arguments?.getInt("alumnoId")

            // Muestra la pantalla de detalle si el ID del alumno no es nulo.
            if (alumnoId != null) {
                AlumnoViewDetail(
                    alumnoId = alumnoId,
                    navController = navController
                )
            } else {
                // Muestra un mensaje de error si no se proporciona el ID del alumno.
                Text("Error: Alumno ID no proporcionado")
            }
        }
    }
}
