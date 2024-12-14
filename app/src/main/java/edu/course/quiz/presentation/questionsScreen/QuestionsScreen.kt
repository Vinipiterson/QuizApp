package edu.course.quiz.presentation.questionsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.course.quiz.data.Question
import edu.course.quiz.data.QuizQuestions
import edu.course.quiz.model.QuizViewModel
import edu.course.quiz.presentation.questionsScreen.components.Answer
import edu.course.quiz.ui.theme.QuizTypography

@Composable
fun QuestionsScreen(
    viewModel: QuizViewModel,
    onMoveToFinalScreen: () -> Unit
){
    viewModel.RefreshProgress()

    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primaryContainer) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            contentAlignment = Alignment.Center){

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ) {
                Column(Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    LinearProgressIndicator(
                        progress = {viewModel.currentProgress},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp).padding(top = 16.dp, bottom = 4.dp)
                    )

                    Text(text = viewModel.currentQuestion.question,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .padding(top = 4.dp, bottom = 4.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = QuizTypography.titleLarge
                    )
                    viewModel.currentQuestion.image.let {
                        Image(painter = painterResource(viewModel.currentQuestion.image ?: -1),
                            contentDescription = null,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    viewModel.currentQuestion.answers.forEachIndexed { id, answer ->
                        Answer(id = id,
                            text = answer,
                            onClick = { if (!viewModel.isVerified) viewModel.selectedIndex = id },
                            state =
                                if (viewModel.selectedIndex == id){
                                    if (!viewModel.isVerified) { if (viewModel.selectedIndex == id) 1 else 0}
                                    else if (viewModel.selectedIndex == viewModel.currentQuestion.correctAnswer) 2
                                    else 3
                                } else if (viewModel.currentQuestion.correctAnswer == id && viewModel.isVerified) 2
                                    else 0
                        )
                    }

                    Button( onClick = { HandleActionButtons(viewModel = viewModel,
                        onMoveToFinalScreen = {onMoveToFinalScreen() })
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 16.dp)) {
                        Text(text = if (!viewModel.isVerified) "Verify"
                        else if(viewModel.currentQuestion.id == QuizQuestions.last().id) "Finish"
                        else "Next")
                    }
                }
            }
        }
    }
}

fun HandleActionButtons(viewModel: QuizViewModel, onMoveToFinalScreen: () -> Unit){
    if (viewModel.selectedIndex == -1)
        return

    if (!viewModel.isVerified) {
        viewModel.isVerified = true
        if(viewModel.currentQuestion.correctAnswer == viewModel.selectedIndex) viewModel.correctAnswers++
        return
    }
    if (viewModel.currentQuestion.id != QuizQuestions.last().id){
        viewModel.NextQuestion()
        return
    }
    onMoveToFinalScreen()
}