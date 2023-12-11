package com.llw.goodstudy.utils

import android.content.Context
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

object EasyUtils {

    /**
     * 设置状态栏
     * @param bgColor 背景颜色
     * @param dark 是否为深色模式
     */
    fun setStatusBar(context: Context, bgColor: Color, dark: Boolean = true) {
        (context as? ComponentActivity)?.window?.apply {
            //背景颜色
            statusBarColor = bgColor.toArgb()
            //文字和图标主题颜色，深色和浅色两种模式
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                this.decorView.windowInsetsController?.apply {
                    setSystemBarsAppearance(if (dark) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
                }
            } else {
                this.decorView.systemUiVisibility = if (dark) View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                else View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        }
    }


    /**
     * 校验手机号
     */
    fun isPhoneValid(phoneNumber: String): Boolean {
        val pattern = Regex("^\\d{10}$")
        return pattern.matches(phoneNumber)
    }

    /**
     * 校验邮箱
     */
    fun isEmailValid(email: String): Boolean {
        val pattern = Regex("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}\$")
        return pattern.matches(email)
    }

    /**
     * 校验密码长度
     */
    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }
}