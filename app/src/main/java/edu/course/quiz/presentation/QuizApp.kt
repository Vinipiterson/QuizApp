package edu.course.quiz.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.course.quiz.model.QuizViewModel
import edu.course.quiz.presentation.finalScreen.FinalScreen
import edu.course.quiz.presentation.questionsScreen.QuestionsScreen
import edu.course.quiz.presentation.welcomeScreen.WelcomeScreen
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlin.coroutines.coroutineContext

@Composable
fun QuizApp(){
    val viewModel: QuizViewModel = viewModel<QuizViewModel>()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WelcomeScreen
    ){
        composable<WelcomeScreen>{
            WelcomeScreen(viewModel = viewModel,
                onMoveToQuestionsScreen = {
                    viewModel.correctAnswers = 0
                navController.navigate(QuestionsScreen)
            })
        }
        composable<QuestionsScreen>{
            QuestionsScreen(viewModel = viewModel,
                onMoveToFinalScreen = {
                    navController.navigate(FinalScreen)
                })
        }
        composable<FinalScreen>{
            FinalScreen(viewModel,
                onGoBackToHomeScreen = {
                    navController.navigate(WelcomeScreen)
                }
            )
        }
    }
}

@Serializable
object WelcomeScreen
@Serializable
object QuestionsScreen
@Serializable
object FinalScreen