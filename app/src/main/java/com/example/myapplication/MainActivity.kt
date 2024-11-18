package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.widget.LRListDialog
import com.example.myapplication.widget.LRListSB1Dialog
import com.example.myapplication.widget.NoNetWorkHelpDialog
import com.example.myapplication.widget.NoNetWorkHelpNavBarDialog1
import com.example.myapplication.widget.TopToastDialog
import com.melody.dialog.any_pop.AnyPopDialog
import com.melody.dialog.any_pop.AnyPopDialogProperties
import com.melody.dialog.any_pop.DirectionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestContent()
                }
            }
        }
    }
}


@Composable
fun TestContent(modifier: Modifier = Modifier) {
    // 请打开：com.example.myapplication.ui.theme.Theme.kt文件，查看第61行

    var showNetHelpDialog by remember { mutableStateOf(false) }
    NoNetWorkHelpDialog(showNetHelpDialog){ showNetHelpDialog = false }

    var showNavBar1Dialog by remember { mutableStateOf(false) }
    NoNetWorkHelpNavBarDialog1(showNavBar1Dialog){ showNavBar1Dialog = false } // 自己改Modifier

    var showLRListDialog by remember { mutableStateOf(false) }
    LRListDialog(showLRListDialog){ showLRListDialog = false }

    var showLRListSBDialog by remember { mutableStateOf(false) }
    LRListSB1Dialog(showLRListSBDialog){ showLRListSBDialog = false } // 自己改Modifier

    var showTOPDialog by remember { mutableStateOf(false) }
    TopToastDialog(showTOPDialog){ showTOPDialog = false }

    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showNetHelpDialog = !showNetHelpDialog }) {
                Text(text = "网络连接失败，点击重试")
            }
            Button(onClick = { showLRListDialog = !showLRListDialog }) {
                Text(text = "测试右侧弹出") // 左侧效果请你自己修改一下properties查看
            }
            Button(onClick = { showTOPDialog = !showTOPDialog }) {
                Text(text = "测试顶部弹出") // 这个看你自己怎么玩了，有时候也是可以当做Toast的
            }
            Button(onClick = { showNavBar1Dialog = !showNavBar1Dialog }) {
                Text(text = "无法理解要修改【导航栏颜色】的同学在想什么\uD83E\uDD23") // 自己改Modifier
            }
            Button(onClick = { showLRListSBDialog = !showLRListSBDialog }) {
                Text(text = "无法理解要修改【状态栏颜色】的同学在想什么\uD83E\uDD23") // 自己改Modifier
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:Nexus 5"
)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        TestContent(modifier = Modifier.fillMaxSize())
    }
}

@Preview(
    showBackground = true,
    device = "id:Nexus 5",
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewAnyPopDialog() {
    MyApplicationTheme(dynamicColor = true, darkTheme = false) {
        AnyPopDialog(
            onDismiss = {},
            properties = AnyPopDialogProperties(direction = DirectionState.NONE),
            content = {
                Text("我是预览模式下的内容", color = Color.White, modifier = Modifier.padding(16.dp))
            }
        )
    }
}
