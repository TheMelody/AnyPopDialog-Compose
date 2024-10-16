AnyPopDialog-Compose
===============
<a href="https://xiaozhuanlan.com/u/halifax"><img alt="小专栏" src="https://img.shields.io/badge/%E5%B0%8F%E4%B8%93%E6%A0%8F-FF7055" ></a>
<a href="https://juejin.cn/user/8451824316670/posts"><img alt="稀土掘金" src="https://img.shields.io/badge/稀土掘金-056DE8" ></a>
<a href="https://www.zhihu.com/people/fq_halifax"><img src="https://img.shields.io/badge/%E7%9F%A5%E4%B9%8E-056DE8" alt="知乎"></a>
<a href="https://blog.csdn.net/logicsboy"><img src="https://img.shields.io/badge/CSDN-fc5531" alt="CSDN">

可控制Compose Dialog弹出的方向，支持上下左右，自由定制，真Dialog哦🔥

> [!NOTE]  
> AnyPopDialog需要自己传修改后的Modifier，如Modifier.systemBarsPadding()等等
> 
> 示例中提供了如何设置导航栏和状态栏颜色的例子(**不是很理解，感觉很癫**)，如有需要可自行查看


# 效果
<div>
    <img src="screenshot/preview.gif" width="30%"/>
    <img src="screenshot/小横条.gif" width="30%"/>
    <img src="screenshot/三大金刚.gif" width="30%"/>
</div>


# 集成

```gradle.kts
dependencies {
    implementation("io.github.TheMelody:any_pop_dialog_compose:1.0.3")
}
```

# 用法
```kotlin
@Composable
fun TestXXXX() {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        var isActiveClose by remember { mutableStateOf(false) }
        AnyPopDialog(
            modifier = Modifier.fillMaxWidth().background(...).systemBarsPadding(),
            isActiveClose = isActiveClose,
            // 根据你自己的功能，调整进入方向即可，支持:TOP/LEFT/RIGHT/BOTTOM/NONE
            properties = AnyPopDialogProperties(direction = DirectionState.BOTTOM),
            content = {
                // 这里放你自己的Dialog内容
                // 如果你需要在你自己的组件中想动画关闭Dialog，请更新isActiveClose
            },
            onDismiss = { showDialog = false }
        )
    }
    ...
}
```
