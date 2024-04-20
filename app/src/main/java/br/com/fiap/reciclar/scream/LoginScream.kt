package br.com.fiap.reciclar.scream

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.reciclar.R
import br.com.fiap.reciclar.model.Cliente
import br.com.fiap.reciclar.repository.ClienteRepository

@Composable
fun LoginScream(navController: NavController) {

    val context = LocalContext.current
    val repository = ClienteRepository(context)

    var loginState by remember {
    mutableStateOf("")}
    var senhaState by remember {
        mutableStateOf("")
    }


    Surface(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()) {


        Column (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween

        ){
            Card( modifier = Modifier
                .background(color = Color(color = 0xCE1DCF26))
                .fillMaxWidth()
                .absolutePadding(top = 32.dp)) {
            }
            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Recicle",
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xCE1DCF26)
                )
            }
            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Login",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xCE1DCF26)
                    )
            }

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = loginState,
                    onValueChange = {loginState = it
                                    },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = { Text(
                    text = "Login"
                )})
                OutlinedTextField(value = senhaState,
                    onValueChange = {senhaState = it
                                    },
                    modifier = Modifier.padding(bottom = 32.dp),
                    label = { Text(text = "Senha")}
                )
                Button(onClick = {

                    val cliente = Cliente(

                        loginCliente = loginState,
                        senhaCliente = senhaState
                    )
                    if(repository.validar(cliente)){

                        navController.navigate("menu")

                    }

                }) {
                    Text(text = "Entrar")
                    Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = "" )
                }
                Row( modifier = Modifier.padding(top = 8.dp) ) {
                    Text(text = "Cadastrar",
                        modifier = Modifier.
                        clickable { navController.navigate("cadastro") })

                }

            }
            Card( modifier = Modifier
                .background(color = Color(color = 0xCE1DCF26))
                .fillMaxWidth()
                .absolutePadding(top = 32.dp)


            ) {
            }
        }

    }
}

@Preview (showSystemUi = true)
@Composable
private fun LoginScreamPrev() {
    //LoginScream()
}