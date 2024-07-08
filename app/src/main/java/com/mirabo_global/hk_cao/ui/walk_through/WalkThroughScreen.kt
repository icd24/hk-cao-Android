package com.mirabo_global.hk_cao.ui.walk_through

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mirabo_global.hk_cao.ui.theme.BGMain
import com.mirabo_global.hk_cao.R
import com.mirabo_global.hk_cao.ui.components.advancedShadow
import com.mirabo_global.hk_cao.util.ScreenHeightInDp

@Composable
fun WalkThroughScreen(onNextScreen: () -> Unit) {
    var step by remember { mutableIntStateOf(1) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            val screenHeight = ScreenHeightInDp() - 96
            val gradient = Brush.linearGradient(
                colors = listOf(Color.Transparent, BGMain),
                end = Offset(0f, screenHeight)
            )
            Box(
                Modifier
                    .background(
                        color = BGMain,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .fillMaxSize()
                    .weight(1f)) {
                Image(painter = painterResource(id = R.drawable.wall_through_mask),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "mask",
                    modifier = Modifier.fillMaxSize()
                        .background(color = Color.Transparent,
                            shape = RoundedCornerShape(16.dp))
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(gradient, shape = RoundedCornerShape(16.dp))
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                    ) {
                        Column {
                            Text(
                                text = "0$step",
                                style = TextStyle(
                                    fontSize = 80.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                ),
                            )
                            Text(
                                text =
                                    when (step) {
                                        1 -> "キャリアシートが\nほぼタップのみで作れる"
                                        2 -> "求人を待つだけ"
                                        3 -> "独自の視点で\n企業の特徴を確認できる"
                                        else -> "キャリアシートが\nほぼタップのみで作れる"
                                    }
                                ,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    lineHeight = 36.sp
                                ),
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = when (step) {
                                    1 -> "出品する際に必要なキャリアシートは、簡単な操作で完成します。"
                                    2 -> "キャリアシート登録後は、企業からのオファーを待つだけ。"
                                    3 -> "企業の特徴を知ることで、年収だけにとらわれない転職活動が可能です。"
                                    else -> "企業の特徴を知ることで、年収だけにとらわれない転職活動が可能です。"
                                },
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White,
                                ),
                            )
                        }
                    }
                    StepBox(currentStep = step, onClick = {
                        step = it
                    })
                }
            }
            BottomButton(onNextScreen)
        }
    }
}

@Composable
fun BottomButton(onNextScreen: () -> Unit) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 16.dp)
        ) {
            Box(modifier = Modifier
                .advancedShadow(
                    color = BGMain,
                    alpha = 0.16f,
                    offsetX = 0.dp,
                    offsetY = 0.dp,
                    shadowBlurRadius = 12.dp
                )
                .weight(1f)
                .height(48.dp)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            ) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = BGMain
                    )
                ) {
                    Text(text = "テキスト", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier
                .advancedShadow(
                    color = BGMain,
                    alpha = 0.16f,
                    offsetX = 0.dp,
                    offsetY = 0.dp,
                    shadowBlurRadius = 12.dp
                )
                .weight(1f)
                .height(48.dp)
                .background(color = BGMain, shape = RoundedCornerShape(16.dp))
            ) {
                Button(onClick = { onNextScreen() }, modifier = Modifier
                    .fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "会員登録", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                }
            }
        }
}

@Composable
fun StepBox(currentStep: Int, onClick: (Int) -> Unit) {
    val activeColor = Color.White
    val deActiveColor = Color.White.copy(alpha = 0.7f)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(activeColor)
                .clickable {
                    onClick(1)
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(
                    color = if (currentStep >= 2) activeColor else deActiveColor
                )
                .clickable {
                    onClick(2)
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(
                    color = if (currentStep >= 3) activeColor else deActiveColor
                )
                .clickable {
                    onClick(3)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WalkThroughScreenPreview() {
    WalkThroughScreen(onNextScreen = {})
}