package com.llw.goodstudy.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.llw.goodstudy.R
import com.llw.goodstudy.utils.EasyUtils

@Composable
fun RegisterPage(navController: NavHostController) {
    var phoneNumber by remember { mutableStateOf("") }
    var isErrorPhone by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var isErrorEmail by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var isErrorPwd by remember { mutableStateOf(false) }
    var confirmPassword by remember { mutableStateOf("") }
    var isErrorConfirmPwd by remember { mutableStateOf(false) }
    //注册按钮可以点击的条件，输入框内容不为空,并且输入内容符合要求
    val registerEnabled =
        phoneNumber.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank() &&
                (!isErrorPhone)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "注册",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                isErrorPhone = !EasyUtils.isPhoneValid(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null
                )
            },
            label = { Text(text = "手机号") },
            isError = isErrorPhone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                isErrorEmail = !EasyUtils.isEmailValid(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            label = { Text(text = "邮箱") },
            isError = isErrorEmail,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                isErrorPwd = !EasyUtils.isPasswordValid(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            label = { Text(text = "密码") },
            isError = isErrorPwd,
//            trailingIcon = {
//                val isVisible = password.isNotEmpty()
//                val passwordIcon = if (isVisible) Icons.Default.Lock else Icons.Default.Lock // 根据需要可以添加其他图标
//                Icon(
//                    imageVector = passwordIcon,
//                    contentDescription = null,
//                    modifier = Modifier.padding(end = 12.dp)
//                )
//            },
            visualTransformation = if (password.isNotEmpty()) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                isErrorConfirmPwd = !EasyUtils.isPasswordValid(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            label = { Text(text = "确认密码") },
            isError = isErrorConfirmPwd,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                //注册

            },
            modifier = Modifier.fillMaxWidth(),
            enabled = registerEnabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.coral_orange),
                contentColor = colorResource(R.color.white)
            )
        ) {
            Text(text = "注册")
        }
    }
}
