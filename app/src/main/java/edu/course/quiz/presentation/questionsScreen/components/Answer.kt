package edu.course.quiz.presentation.questionsScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Answer(
    id: Int,
    state: Int, // 0 = unrevealed, 1 = Selected, 2 = correct, 3 = wrong
    text: String,
    onClick: () -> Unit,
    ){
    if (state == 1){
        FilledTonalButton(onClick = { onClick() },
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp).padding(bottom = 8.dp)) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }else if (state == 2){
        Button(onClick = { onClick() },
            colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Green),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp).padding(bottom = 8.dp)) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }else if (state == 3){
        Button(onClick = { onClick() },
            colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp).padding(bottom = 8.dp)) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }else{
        OutlinedButton(onClick = { onClick() },
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp).padding(bottom = 8.dp)) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }
}