package edu.course.quiz.presentation.finalScreen

import edu.course.quiz.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.course.quiz.model.QuizViewModel
import edu.course.quiz.presentation.FinalScreen
import edu.course.quiz.presentation.components.QuizCard
import edu.course.quiz.ui.theme.QuizTypography

@Composable
fun FinalScreen(
    viewModel: QuizViewModel,
    onGoBackToHomeScreen: () -> Unit
){
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primaryContainer) { innerPadding ->

        QuizCard(innerPadding = innerPadding){
            Column(Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val isPieceOfShit = viewModel.correctAnswers < 3

                Text(text = if (isPieceOfShit) "${viewModel.name} you dumb piece of shit" else "Congratulations ${viewModel.name}!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 4.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = QuizTypography.titleLarge
                )
                Text(text = "You got ${viewModel.correctAnswers} answers correct",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 4.dp),
                    textAlign = TextAlign.Center
                )

                Image(painter = painterResource(if (isPieceOfShit) R.drawable.poop else R.drawable.trophy),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Button(onClick = {
                    viewModel.ResetQuiz()
                    onGoBackToHomeScreen()
                                 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 4.dp, bottom = 16.dp),
                ) {
                    Text("Restart")
                }
            }
        }
    }
}