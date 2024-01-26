package com.example.myapplication.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.melody.dialog.any_pop.AnyPopDialog

/**
 * 读者根据自己的业务自行定制，测试快手无网络提示的Dialog
 */
@Composable
internal fun NoNetWorkHelpDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        var isActiveClose by remember { mutableStateOf(false) }
        AnyPopDialog(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(color = colorResource(id = R.color.dialog_window_background))
                .systemBarsPadding(),
            isActiveClose = isActiveClose,
            content = {
                NetSettingContent(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    onDismiss = {
                        isActiveClose = true
                    }
                )
            },
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun NetSettingContent(modifier: Modifier = Modifier, onDismiss: () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        TitleAndClose(onDismiss = onDismiss)
        Text(text = stringResource(id = R.string.test_network_unavailable_dialog_content))
        RoundCornerOkButton(onDismiss = onDismiss)
    }
}

@Composable
private fun TitleAndClose(onDismiss: () -> Unit) {
    val currentOnDismiss by rememberUpdatedState(newValue = onDismiss)
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(id = R.string.test_network_unavailable_dialog_title),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        CloseButton(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .clickable(
                    indication = rememberRipple(),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = currentOnDismiss
                )
        )
    }
}

@Composable
private fun CloseButton(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_dialog_close),
            contentDescription = "Dialog Close"
        )
    }
}

@Composable
private fun ColumnScope.RoundCornerOkButton(onDismiss: () -> Unit) {
    val currentOnDismiss by rememberUpdatedState(newValue = onDismiss)
    Box(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth(0.7F)
            .padding(top = 10.dp)
            .height(46.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF6B97F0),
                shape = RoundedCornerShape(28.dp)
            )
            .clip(RoundedCornerShape(23.dp))
            .clickable(
                indication = rememberRipple(),
                interactionSource = remember { MutableInteractionSource() },
                onClick = currentOnDismiss
            ),
    ) {
        Text(
            text = stringResource(id = R.string.dialog_knew),
            modifier = Modifier.align(Alignment.Center),
            fontWeight = FontWeight.Medium,
            color = Color(0xFF6B97F0),
            fontSize = 15.sp
        )
    }
}