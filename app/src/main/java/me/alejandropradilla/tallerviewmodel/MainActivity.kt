package me.alejandropradilla.tallerviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

class ContadorViewModel : ViewModel() {
    val contador = mutableIntStateOf(0)
    fun sumar() {
        contador.intValue++
    }
}

class MainActivity : ComponentActivity() {
    private val vm: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla(vm)
        }
    }
}

@Composable
fun Pantalla(vm: ContadorViewModel) {
    val contadorLocal = remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Con ViewModel: ${vm.contador.intValue}", fontSize = 24.sp)
        Button(onClick = { vm.sumar() }) { Text("Sumar") }

        Text("Sin ViewModel: ${contadorLocal.intValue}", fontSize = 24.sp)
        Button(onClick = { contadorLocal.intValue++ }) { Text("Sumar") }
    }
}
