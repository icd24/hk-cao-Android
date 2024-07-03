package com.hk.cao.ui.walk_through

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hk.cao.ui.theme.BGMain

@Composable
fun WalkThroughScreen(onNextScreen: () -> Unit) {
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
            Box(
                Modifier
                    .background(
                        color = BGMain,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .fillMaxSize()
                    .weight(1f)) {
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WalkThroughScreenPreview() {
    WalkThroughScreen(onNextScreen = {})
}