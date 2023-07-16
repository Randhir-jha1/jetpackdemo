package com.appdev.geekjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.geekjetpack.ui.theme.GeekJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeekJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //CounterScreen()
                    LoginScreen()
                }
            }
        }
    }
    private fun login(username:String,password:String){

        if (username=="randhir"&&password=="12345"){
            Toast.makeText(this,"Login Seccessfully",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Incorrect username & password",Toast.LENGTH_LONG).show()

        }
    }
    @Composable
    fun LoginScreen(){
        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "Hello Again!", fontSize = 25.sp, color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Text(text = "Welcome", fontSize = 25.sp, color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Text(text = "Back!", fontSize = 25.sp, color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {Icon(Icons.Default.Person,contentDescription = "person")},
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "enter username")
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {Icon(Icons.Default.Lock,contentDescription = "person")},
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "enter password")
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedButton(onClick = {login(username.value,password.value)},
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)

            ) {
                Text(text = "Login")
            }

        }
    }

}



@Composable
fun CounterScreen(){

    var count by remember{ mutableStateOf(0) }
    var textValue by remember {
        mutableStateOf("")
    }
     Column() {
         Text(text = "Count: $count", fontSize = 18.sp)
         Button(onClick = {count++}) {
             Text(text = "Increment")
         }
         TextField(
             value = textValue,
             onValueChange ={textValue=it},
             label = {Text("Enter your name")},
             modifier = Modifier.padding(16.dp)
             )


     }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val listItem = listOf("Item 1", "Item 2","Item 3")
    Column {
         Text(
             text = "Hello $name!",
             modifier = modifier
         )
         Button(onClick = { },
            modifier = Modifier.padding(16.dp)
         ) {
             Text(text = "Click Me!")
         }
         Image(painter = painterResource(R.drawable.ic_launcher_background),
             contentDescription ="Image",
             modifier = Modifier.size(200.dp)
         )
         Box(modifier = Modifier
             .size(200.dp, 100.dp)
             .background(Color.Red)){
             Text(
                 text = "Hello",
                 color= Color.White

             )
         }
         Card (modifier= Modifier
             .padding(16.dp)
             .fillMaxWidth(),
             elevation = CardDefaults.cardElevation(
                 defaultElevation = 10.dp
             )
         ){
             Column(modifier = Modifier.padding(16.dp)) {
                 Text(text = "Title", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                 Text(text = "Description")
             }

         }

        LazyColumn{
            items(listItem){item->

                Card (modifier= Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = item, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                        Text(text = "Description")
                    }

                }

            }
        }


     }

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    GeekJetpackTheme {
//        Greeting("Android")
//    }
//}