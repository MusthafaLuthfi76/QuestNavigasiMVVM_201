package com.example.praktikummvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikummvvm.model.DataJK

@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJK : List<String>,
    onClickButton : (MutableList<String>) -> Unit
){
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var listData : MutableList<String> = mutableListOf(nama, jenisK, alamat)

    Column (modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = nim,
            onValueChange = {nim = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("NIM") },
            placeholder = { Text("Masukkan NIM anda: ") }
        )

        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nama") },
            placeholder = { Text("Masukkan nama anda: ") }
        )

        Row {
            pilihanJK.forEach { selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK )
                }
            }
        }

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat anda: ") }
        )

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("email") },
            placeholder = { Text("Masukkan email anda: ") }
        )

        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nomor HP") },
            placeholder = { Text("Masukkan Nomor HP anda: ") }
        )

        Button(onClick = {
            onClickButton(listData)
        },
            modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")
        }
    }
}

