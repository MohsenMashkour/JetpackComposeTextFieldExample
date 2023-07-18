package com.mkrdeveloper.jetpackcomposetextfieldexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkrdeveloper.jetpackcomposetextfieldexample.ui.theme.JetpackComposeTextFieldExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTextFieldExampleTheme {

                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MyApp() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var newTextValue by remember {
            mutableStateOf("")
        }
        val context = LocalContext.current

        val keyboardController = LocalSoftwareKeyboardController.current

        val focusManager = LocalFocusManager.current

        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {

            TextField(value = newTextValue, onValueChange = {
                newTextValue = it
            },
                label = { Text(text = "Enter your email") },
                //maxLines = 2
                singleLine = true,
                modifier = Modifier.width(300.dp),
                placeholder = {
                    Text(text = "test@email.com")
                },
                // visualTransformation = PasswordVisualTransformation()
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "")
                    }
                }
            )


            OutlinedTextField(
                value = newTextValue, onValueChange = {
                    newTextValue = it
                },
                label = { Text(text = "Enter your email") },
                //maxLines = 2
                singleLine = true,
                modifier = Modifier.width(300.dp),
                placeholder = {
                    Text(text = "test@email.com")
                },
                // visualTransformation = PasswordVisualTransformation()
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {

                        keyboardController?.hide()
                        Toast.makeText(context, "send button pressed", Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }
                )
            )
            BasicTextField(value = "sub please", onValueChange = {}
            ,modifier = Modifier.width(300.dp).background(Color.LightGray))


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTextFieldExampleTheme {
        MyApp()
    }
}