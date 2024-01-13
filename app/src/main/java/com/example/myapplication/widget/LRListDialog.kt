package com.example.myapplication.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.melody.dialog.any_pop.AnyPopDialog
import com.melody.dialog.any_pop.AnyPopDialogProperties
import com.melody.dialog.any_pop.DirectionState

/**
 * 读者根据自己的业务自行定制，测试LEFT/RIGHT弹出的Dialog
 */
@Composable
internal fun LRListDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        AnyPopDialog(
            modifier = Modifier
                .fillMaxWidth(0.6F)
                .fillMaxHeight()
                .imePadding()
                .background(color = colorResource(id = R.color.dialog_window_background)),
            // 可以自由配置，如监听键盘弹起，禁止outSide关闭等，根据自己需求定制吧
            properties = AnyPopDialogProperties(direction = DirectionState.RIGHT),
            content = {
                LRListContent(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxSize()
                )
            },
            onDismiss = onDismiss
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LRListContent(modifier: Modifier) {
    var textField by remember {
        mutableStateOf("")
    }
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(18) {
            item {
                Text(
                    text = "测试:$it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp),
                    fontSize = 18.sp
                )
            }
        }
        item {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = textField,
                onValueChange = { textField = it })
        }
    }
}