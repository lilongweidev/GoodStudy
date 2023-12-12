package com.llw.goodstudy.pages

import android.widget.Toolbar
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.compose.rememberNavController
import com.llw.goodstudy.R

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.llw.goodstudy.utils.Constant

@Composable
fun LoginPage(navController: NavHostController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginEnabled = username.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.mipmap.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(160.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = { Text(text = "账号(手机号/邮箱)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            label = { Text(text = "密码") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { /* 处理登录逻辑 */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = loginEnabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.coral_orange),
                contentColor = colorResource(R.color.white)
            )
        ) {
            Text(text = "登录")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate(Constant.PAGE_REGISTER) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.coral_orange),
                contentColor = colorResource(R.color.white)
            )
        ) {
            Text(text = "注册")
        }
    }
}

/**
 * 预览
 */
@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun PreviewLoginPage() {
    LoginPage(navController = rememberAnimatedNavController())
}
