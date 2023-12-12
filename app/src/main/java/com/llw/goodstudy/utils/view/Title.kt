package com.llw.goodstudy.utils.view

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenericTitle(
    title: String,
    subtitle: String = "",
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onMoreClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // 返回按钮
        Icon(
            painterResource(id = com.llw.goodstudy.R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier
                .size(32.dp)
                .clickable { onBackClicked() }
        )

        Column(
            modifier = Modifier
                .padding(start = 48.dp)
                .align(Alignment.CenterStart)
        ) {
            // 标题
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                fontSize = 20.sp,
                color = Color.Black,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            // 子标题
            Text(
                text = subtitle,
                style = MaterialTheme.typography.subtitle1,
                fontSize = 16.sp,
                color = Color.Gray,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        // 更多按钮
        Icon(
            painterResource(id = com.llw.goodstudy.R.drawable.ic_more),
            contentDescription = "More",
            modifier = Modifier
                .size(32.dp)
                .clickable { onMoreClicked() }
                .align(Alignment.CenterEnd)
        )
    }
}

@Preview
@Composable
fun PreviewRegisterPage() {
    GenericTitle(title = "测试", subtitle = "", modifier = Modifier, onBackClicked = {}, onMoreClicked = {})
}



