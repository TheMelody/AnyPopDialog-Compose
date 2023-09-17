package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.widget.LRListDialog
import com.example.myapplication.widget.NoNetWorkHelpDialog
import com.example.myapplication.widget.TopToastDialog

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
    var showNetHelpDialog by remember { mutableStateOf(false) }
    NoNetWorkHelpDialog(showNetHelpDialog){ showNetHelpDialog = false }

    var showLRListDialog by remember { mutableStateOf(false) }
    LRListDialog(showLRListDialog){ showLRListDialog = false }

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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        TestContent()
    }
}