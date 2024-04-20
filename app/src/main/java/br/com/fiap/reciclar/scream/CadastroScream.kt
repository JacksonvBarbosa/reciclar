package br.com.fiap.reciclar.scream

import android.provider.UserDictionary.Words
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.reciclar.model.Cliente
import br.com.fiap.reciclar.repository.ClienteRepository
import org.jetbrains.annotations.Nls.Capitalization

@Composable
fun CadastroScream(navController: NavController) {

   val context = LocalContext.current
   val repository = ClienteRepository(context)


    var nomeState by remember {
        mutableStateOf("")
    }
    var cpfState by remember {
        mutableStateOf("")
    }
    var enderecoState by remember {
        mutableStateOf("")
    }
    var telefoneState by remember {
        mutableStateOf("")
    }
    var loginState by remember {
        mutableStateOf("")
    }
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
                .padding(top = 32.dp),
                ) {
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                Text(text = "Cadastro",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xCE1DCF26)
                )
            }

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = nomeState, onValueChange =
                {
                    nomeState = it
                },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = {
                        Text(text = "Nome Completo")
                    }
                    , keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        keyboardType = KeyboardType.Ascii


                    )
                )
                OutlinedTextField(value = cpfState, onValueChange = {
                    cpfState=it
                },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = { Text(text = "CPF") },
                             keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                            )
                )
                OutlinedTextField(value = enderecoState, onValueChange = {
                    enderecoState=it
                },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = { Text(
                        text = "Endereço"
                    )
                    })
                OutlinedTextField(value = telefoneState, onValueChange = {
                    telefoneState=it
                },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = { Text(
                        text = "Telefone"
                    )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )
                )
                OutlinedTextField(value = loginState, onValueChange = {
                    loginState=it
                },
                    modifier = Modifier.padding(bottom = 16.dp),
                    label = { Text(
                        text = "Login"
                    )
                    })
                OutlinedTextField(value = senhaState, onValueChange = {
                    senhaState = it},
                    modifier = Modifier.padding(bottom = 32.dp),
                    label = { Text(text = "Senha") },
                    keyboardOptions = KeyboardOptions(

                        keyboardType = KeyboardType.Password
                    )
                )

                Button(onClick = {

                    val cliente = Cliente(

                        nomeCliente = nomeState,
                        cpfCliente = cpfState,
                        enderecoClient = enderecoState,
                        telefoneCliente = telefoneState,
                        loginCliente = loginState,
                        senhaCliente = senhaState


                    )
                    repository.salvar(cliente)
                    navController.navigate("login")


                }) {
                    Text(text = "Cadastrar")
                    Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = "" )
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
private fun CadastroScreamPrev() {

  //  CadastroScream()
}