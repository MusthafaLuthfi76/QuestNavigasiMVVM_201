package com.example.praktikummvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
    var listData : MutableList<String> = mutableListOf(nim, nama, jenisK, alamat, email, noHp)

    Column (modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            value = nim,
            leadingIcon = { Icon(imageVector = Icons.Default.AccountBox,
                contentDescription = "Faceicon") },
            onValueChange = {nim = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("NIM") },
            placeholder = { Text("Masukkan NIM anda: ") }
        )

        OutlinedTextField(
            value = nama,
            leadingIcon = { Icon(imageVector = Icons.Default.Face,
                contentDescription = "Faceicon") },
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

        OutlinedTextField(
            value = alamat,
            leadingIcon = { Icon(imageVector = Icons.Default.Place,
                contentDescription = "Addressicon") },
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat anda: ") }
        )

        OutlinedTextField(
            value = email,
            leadingIcon = { Icon(imageVector = Icons.Default.Email,
                contentDescription = "Mailicon") },
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("email") },
            placeholder = { Text("Masukkan email anda: ") }
        )

        OutlinedTextField(
            value = noHp,
            leadingIcon = { Icon(imageVector = Icons.Default.Phone,
                contentDescription = "Phoneicon") },
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

