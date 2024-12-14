package edu.course.quiz.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizCard(
    innerPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
        contentAlignment = Alignment.Center){

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            content = content
        )
    }
}