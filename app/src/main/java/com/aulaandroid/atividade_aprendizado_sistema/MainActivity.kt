package com.aulaandroid.atividade_aprendizado_sistema


import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.J
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.atividade_aprendizado_sistema.ui.theme.AtividadeaprendizadosistemaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtividadeaprendizadosistemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    criandoTemplateTop(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AtividadeaprendizadosistemaTheme {
        Greeting("Android")
    }
}

@Composable
fun criandoTemplateTop(modifier: Modifier = Modifier){
    var adicionando by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
            .background(Color.White).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Qual é a sua idade?",
            color = Color(28, 58, 176, 255),
            fontSize = 32.sp)

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 18.sp
        )
        Text(
            text = "$adicionando",
            fontSize = 50.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    if (adicionando > 0){
                        adicionando = adicionando - 1
                    } else
                    adicionando = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(28, 58, 176, 255)
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier.size(65.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_check_indeterminate_small_24),
                    contentDescription = "Botão de subtrair",
                )
            }

            OutlinedButton(
                onClick = {
                    if (adicionando < 180) {
                        adicionando = adicionando + 1
                    } else {
                        adicionando = 180
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(28, 58, 176, 255)
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier.size(65.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionando"
                )
            }
        }
        if (adicionando >= 18) {
            Text(text = "Voce é MAIOR de idade",
                color = Color(28, 58, 176, 255),
                fontSize = 28.sp)
        } else {
            Text(text = "Voce é MENOR de idade",
                color = Color(28, 58, 176, 255),
                fontSize = 28.sp)
        }
    }


}