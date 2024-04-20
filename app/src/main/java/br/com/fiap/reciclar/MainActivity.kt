package br.com.fiap.reciclar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.reciclar.scream.AgendamentoScream
import br.com.fiap.reciclar.scream.CadastroScream
import br.com.fiap.reciclar.scream.LoginScream
import br.com.fiap.reciclar.scream.MenuScream
import br.com.fiap.reciclar.ui.theme.ReciclarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReciclarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScream(navController) }
                        composable(route = "cadastro") { CadastroScream(navController) }
                        composable(route = "menu") { MenuScream(navController) }
                        composable(route = "coleta"){ AgendamentoScream(navController)}

                    }
                }
            }
        }
    }
}


