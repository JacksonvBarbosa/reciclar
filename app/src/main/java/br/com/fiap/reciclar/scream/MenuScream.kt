package br.com.fiap.reciclar.scream

import android.widget.ListView
import android.widget.Spinner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.reciclar.model.Coleta
import br.com.fiap.reciclar.repository.coletaRepository


@Composable
fun MenuScream(navController: NavController) {

    val context = LocalContext.current
    val repository = coletaRepository(context)
    var coleta = Coleta()

    var listarColetasState by remember {
        mutableStateOf(listOf<Coleta>())
    }
    listarColetasState =  repository.listarcoleta()

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
            Column (modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray)){
                Button(onClick = { navController.navigate("coleta") }, modifier =  Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(color = 0xCE1DCF26))



                ){

                    Text(text = "Solicitar Coleta")

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
fun MenuScreamPrev() {
  //  MenuScream()
}