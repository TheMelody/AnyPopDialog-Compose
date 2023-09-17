package com.example.myapplication.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.melody.dialog.any.pop.AnyPopDialog
import com.melody.dialog.any.pop.AnyPopDialogProperties
import com.melody.dialog.any.pop.DirectionState

@Composable
internal fun TopToastDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        var isActiveClose by remember { mutableStateOf(false) }
        AnyPopDialog(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeightIn(max = 160.dp, min = 80.dp)
                .background(color = colorResource(id = R.color.dialog_toast_background))
                .clickable(
                    indication = rememberRipple(),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        isActiveClose = true
                    }
                ),
            isActiveClose = isActiveClose,
            // 请根据自己需要自己配置，自己定制谢谢配合
            properties = AnyPopDialogProperties(
                direction = DirectionState.TOP,
                dismissOnClickOutside = true,
                backgroundDimEnabled = false
            ),
            content = {
                TopToastContent(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )
            },
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun TopToastContent(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
        Text(text = "系统服务不可用，请联系开发者。错误码:(0x123456)", color = Color(0xFFFAFAFA))
    }
}