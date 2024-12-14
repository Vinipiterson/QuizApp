package edu.course.quiz.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.course.quiz.data.Question
import edu.course.quiz.data.QuizQuestions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    var name by mutableStateOf("")

    var selectedIndex by mutableIntStateOf(-1)
    var currentQuestionIndex by mutableIntStateOf(0)
    var currentQuestion by mutableStateOf(QuizQuestions[currentQuestionIndex])
    var currentProgress by mutableFloatStateOf(0.0f)

    var correctAnswers by mutableIntStateOf(0)
    var isVerified by mutableStateOf(false)

    fun ResetQuiz(){
        viewModelScope.launch{
            delay(500)
            selectedIndex = -1
            currentQuestionIndex = 0
            correctAnswers = 0
            isVerified = false
            RefreshCurrentQuestion()
            RefreshProgress()
        }
    }
    fun NextQuestion(){
        selectedIndex = -1
        isVerified = false
        currentQuestionIndex++
        currentQuestion = QuizQuestions[currentQuestionIndex]
        RefreshProgress()
    }
    fun RefreshProgress(){
        currentProgress = (currentQuestionIndex.toFloat()+1.0f)/5.0f
    }
    fun RefreshCurrentQuestion(){
        currentQuestion = QuizQuestions[currentQuestionIndex]
    }
}