@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.screens.navigation.NavigationDestination
import com.example.myapplication.viewModel.AppViewModelProvider
import com.example.myapplication.viewModel.SignupViewModel
import kotlinx.coroutines.launch
import androidx.compose.material3.Text as Text1

object SignupDestination : NavigationDestination {
    override val route: String = "signup"
    override val title: String = "Signup"
}

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {},
    viewModel: SignupViewModel = viewModel(factory = AppViewModelProvider.Factory)) {


    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .requiredWidth(390.dp)
            .requiredHeight(844.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 385.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Name",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = name,
                onValueChange = {
                        newName -> name = newName
                    viewModel.updateUiState(viewModel.userUiState.usersDetails.copy(name = newName))
                },
                placeholder = { Text1("Enter your name") },
                modifier = Modifier
                    .offset(x = 0.dp, y = 20.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 465.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Email",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = email,
                onValueChange = {
                        newEmail -> email = newEmail
                    viewModel.updateUiState(viewModel.userUiState.usersDetails.copy(email = newEmail))
                },
                placeholder = { Text1("Enter your email address") },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 20.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 545.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Phone Number",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = phoneNumber,
                onValueChange = {
                        newPhoneNumber -> phoneNumber = newPhoneNumber
                    viewModel.updateUiState(viewModel.userUiState.usersDetails.copy(phone = newPhoneNumber))
                },
                placeholder = { Text1("Enter your phone number") },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 625.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Password",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = password,
                onValueChange = {
                        newPassword -> password = newPassword
                    viewModel.updateUiState(viewModel.userUiState.usersDetails.copy(password = newPassword))
                },
                placeholder = { Text1("Enter your password") },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Text1(
            text = "Glamify Me",
            color = Color.Black,
            style = TextStyle(fontSize = 48.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 64.dp, y = 280.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Glamify Me Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 80.dp)
                .requiredWidth(188.dp)
        )
        Button(
            onClick = {
                coroutineScope.launch {
                    Log.d("Pre signup", viewModel.userUiState.toString())
                    viewModel.registerUser { isRegistered, error ->
                        if (isRegistered) {
                            navigateToLogin()
                        } else {
                            Log.d("Register", "Registration failed: $error")
                        }
                    }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 730.dp)
                .requiredWidth(342.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredWidth(342.dp)
            ) {
                Text1(
                    text = "Sign Up",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )
            }
        }

        Text1(
            text = "Have an account?",
            color = Color.LightGray,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 110.dp, y = 780.dp)
        )

        Button(
            onClick = { navigateToLogin()},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 255.dp, y = 755.dp)
        ) { }

        Text1(
            text = "Log In",
            color = Color.Black,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 780.dp)
        )
    }
}

@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun SignupScreenPreview() {
    SignupScreen()
}
