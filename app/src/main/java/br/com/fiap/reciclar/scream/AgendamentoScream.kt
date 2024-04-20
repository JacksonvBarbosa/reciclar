package br.com.fiap.reciclar.scream

import android.widget.Spinner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import br.com.fiap.reciclar.model.Coleta
import br.com.fiap.reciclar.repository.ClienteRepository
import br.com.fiap.reciclar.repository.coletaRepository

@Composable
fun AgendamentoScream(navController: NavController) {



    val context = LocalContext.current
    val repository = coletaRepository(context)
    var menu: Spinner


    var tipoDeColetaState by remember {
        mutableStateOf("")
    }

    var dataDeColetaState by remember {
        mutableStateOf("")
    }
    var periodState by remember {
        mutableStateOf("")
    }
    var enderecoState by remember {
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
                Text(text = "Agendamento",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xCE1DCF26)
                )
            }

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = tipoDeColetaState, onValueChange =
                {
                    tipoDeColetaState = it
                },
                    modifier = Modifier.padding(bottom = 24.dp),
                    label = {
                        Text(text = "Tipo de Coleta")
                    }
                    , keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        keyboardType = KeyboardType.Ascii


                    )
                )


                OutlinedTextField(value = dataDeColetaState, onValueChange = {
                    dataDeColetaState=it
                },
                    modifier = Modifier.padding(bottom = 24.dp),
                    label = { Text(
                        text = "Data da Coleta"
                    )
                    })

                OutlinedTextField(value = periodState, onValueChange = {
                    periodState=it
                },
                    modifier = Modifier.padding(bottom = 24.dp),
                    label = { Text(
                        text = "Periodo"
                    )
                    })
                OutlinedTextField(value = enderecoState, onValueChange = {
                   enderecoState=it
                },
                    modifier = Modifier.padding(bottom = 24.dp),
                    label = { Text(
                        text = "Endereço"
                    )
                    })


                Button(onClick = {
                    val coleta = Coleta(

                        tipoResiduo = tipoDeColetaState,
                        dataColeta = dataDeColetaState,
                        periodoColeta = periodState,
                        enderecoColeta = enderecoState

                    )
                    repository.salvar(coleta)
                    navController.navigate("menu")



                }) {
                    Text(text = "Agendar")
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

@Preview(showSystemUi = true)
@Composable
private fun AgendamentoPreview() {
    //AgendamentoScream()

}