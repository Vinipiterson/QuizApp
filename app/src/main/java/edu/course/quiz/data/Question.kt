package edu.course.quiz.data

import java.util.UUID
import edu.course.quiz.R

data class Question(
    val id: UUID = UUID.randomUUID(),
    val question: String,
    val image: Int? = null,
    val answers: MutableList<String>,
    val correctAnswer: Int
)

val QuizQuestions = listOf<Question>(
    // 1
    Question(
        question = "What game is this?",
        image = R.drawable.rdr,
        correctAnswer = 0,
        answers = mutableListOf(
            "Red Dead Redemption 2",
            "Roblox",
            "GTA V",
            "Uncharted 4",
            "The Sims 4"
        )
    ),
    // 2
    Question(
        question = "What is the best-selling video game of all time?",
        image = R.drawable.games,
        correctAnswer = 1,
        answers = mutableListOf(
            "Grand Theft Auto V",
            "Minecraft",
            "Tetris",
            "Call of Duty",
            "Super Mario Bros."
        )
    ),
    // 3
    Question(
        question = "Which game introduced the Battle Royale genre to the mainstream?",
        image = R.drawable.battleroyale,
        correctAnswer = 2,
        answers = mutableListOf(
            "Apex Legends",
            "Fortnite",
            "PUBG",
            "Call of Duty: Warzone",
            "Valorant"
        )
    ),
    // 4
    Question(
        question = "What is the main objective of Minecraft?",
        image = R.drawable.minecraft,
        correctAnswer = 1,
        answers = mutableListOf(
            "Defeat the Ender Dragon",
            "Build and survive",
            "Explore galaxies",
            "Capture monsters",
            "Race against opponents"
        )
    ),
    // 5
    Question(
        question = "What is the name of the fictional open-world city in Grand Theft Auto V?",
        image = R.drawable.lossantos,
        correctAnswer = 1,
        answers = mutableListOf(
            "Vice City",
            "Los Santos",
            "Liberty City",
            "San Fierro",
            "San Andreas"
        )
    )
)