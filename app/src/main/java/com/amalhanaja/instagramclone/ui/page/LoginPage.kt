package com.amalhanaja.instagramclone.ui.page

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun LoginPage() {
    ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        val context = LocalContext.current
        fun login(username: String, password: String) {
            Toast.makeText(context, "Login Dengan Username: $username dan Password: $password", Toast.LENGTH_SHORT).show()
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF4f5bd5),
                                Color(0xFF962fbf),
                                Color(0xFFd62976),
                                Color(0xFFfa7e1e),
                                Color(0xFFfeda75),
                            ),
                        )
                    )
                    .rotate(45f)
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LanguageSection()
                Spacer(modifier = Modifier.weight(1f))
                LoginForm(onLoginButtonClicked = { username, password ->
                    login(username, password)
                })
                Spacer(modifier = Modifier.weight(1f))
                SignUpSection()
            }
        }
    }
}

@Composable
fun LanguageSection() {
    Row(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "English", fontSize = 14.sp)
        Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "Language Options")
    }
}

@Composable
fun LogoSection() {
    Text(text = "Instagram", fontSize = 48.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
}

@Composable
fun LoginForm(
    onLoginButtonClicked: (
        username: String,
        password: String,
    ) -> Unit,
) {
    val (username, setUsername) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        LogoSection()
        val windowInset = LocalWindowInsets.current
        SideEffect {
            Log.d("Login", "${windowInset.ime.animatedInsets.bottom}")
            Log.d("Login", "${windowInset.ime.animatedInsets.top}")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = setUsername,
            placeholder = { Text(text = "Phone number, username or email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = setPassword,
            placeholder = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Forgot your login details?")
            TextButton(onClick = { /*TODO*/ }) {
                Text("Get help logging in")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onLoginButtonClicked(username, password) }
        ) {
            Text(text = "Log In")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text(
                text = "OR",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
            Divider(modifier = Modifier.weight(1f))
        }
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Continue with Facebook"
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Continue with Facebook")
        }
    }
}

@Composable
fun SignUpSection() {
    Column() {
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Don't have an account ?")
            TextButton(onClick = { /*TODO*/ }) {
                Text("Sign up")
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, device = Devices.PIXEL_3)
@Composable
fun PreviewLoginPage() {
    LoginPage()
}