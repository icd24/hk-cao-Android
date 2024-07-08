package com.mirabo_global.hk_cao.ui.term_of_service
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mirabo_global.hk_cao.database.TermOfServiceType
import com.mirabo_global.hk_cao.database.termOfService
import com.mirabo_global.hk_cao.R
import com.mirabo_global.hk_cao.ui.components.advancedShadow
import com.mirabo_global.hk_cao.ui.splash.SplashScreen
import com.mirabo_global.hk_cao.ui.theme.BGMain
import com.mirabo_global.hk_cao.ui.theme.TermOfServiceBackground

@Composable
fun TermOfServiceScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Set your background color here
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_title_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(20.dp)
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Image(
                painter = painterResource(id = R.drawable.ico_menu),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(20.dp)
            )
        }

        Row (modifier = Modifier.padding(start = 20.dp)){
            Box(
                modifier = Modifier
                .advancedShadow(
                    color = BGMain,
                    alpha = 0.16f,
                    offsetX = 0.dp,
                    offsetY = 0.dp,
                    shadowBlurRadius = 12.dp
                )
                .height(29.dp)
                .width(64.dp)
                .background(color = BGMain, shape = RoundedCornerShape(16.dp)
                ),
                contentAlignment = Alignment.Center
            ) {
                Text("戻る",
                    style = TextStyle(color = Color.White,
                    fontWeight = FontWeight.Bold,)
                )
            }

            Text(
                text = "キャリオク利用規約", // Replace with AppString.termOfServiceTitle
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                color = BGMain, // Replace with AppColors.main
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 10.dp)
            )
        }


        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(TermOfServiceBackground)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            termOfService.forEach { items ->
                Box(modifier = Modifier
                    .advancedShadow(
                        color = BGMain,
                        alpha = 0.16f,
                        offsetX = 0.dp,
                        offsetY = 0.dp,
                        shadowBlurRadius = 12.dp
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    items.forEach { item ->
                        when (item.type) {
                            TermOfServiceType.SectionHeader -> {
                                Text(
                                    text = item.content ?: "",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    ),
                                    color = BGMain
                                )
                            }

                            TermOfServiceType.Header -> {
                                Text(
                                    text = item.content ?: "",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                )
                            }

                            TermOfServiceType.Separator -> {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(BGMain.copy(alpha = 0.3f))
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }

                            TermOfServiceType.Text -> {
                                Text(
                                    text = item.content ?: "",
                                    style = TextStyle(fontSize = 16.sp),
                                    modifier = Modifier.padding(top = if (item.isPadding) 6.dp else 0.dp)
                                )
                            }

                            TermOfServiceType.TextIndent -> {
                                Row(
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = item.indent ?: " ",
                                        style = TextStyle(fontSize = 16.sp)
                                    )
                                    Text(
                                        text = item.content ?: "",
                                        style = TextStyle(fontSize = 16.sp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(if (item.isPadding) 6.dp else 0.dp))
                            }
                        }
                    }
                }
            }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TermOfServicePreview() {
    TermOfServiceScreen()
}