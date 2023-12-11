package com.llw.goodstudy.pages

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.llw.goodstudy.R
import com.llw.goodstudy.utils.Constant
import com.llw.goodstudy.utils.EasyUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashPage(navController: NavHostController) {

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        coroutineScope.launch {
            delay(1500) // 延迟1秒
            navController.navigate(Constant.PAGE_LOGIN)// 进入登录页面
        }
    }
    SplashContent()
}

@Preview
@Composable
fun SplashContent() {
    EasyUtils.setStatusBar(LocalContext.current, colorResource(id = R.color.white))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo 图片
        Image(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Fit
        )

        // 欢迎文本
        Text(
            text = "Good Study",
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
