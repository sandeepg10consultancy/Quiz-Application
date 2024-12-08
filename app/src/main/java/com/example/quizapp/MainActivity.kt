package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.screens.QuestionsViewModel
import com.example.quizapp.ui.theme.QuizAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {

            }
        }
    }
}

@Composable
fun TriviaHome(viewModel: QuestionsViewModel){

    Questions(viewModel)
}

@Composable
fun Questions( viewModel: QuestionsViewModel){
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true){
        Log.d("Loading","Questions are Loading")
    }else {
        Log.d("Loading","Success full")
        questions?.forEach { questionItem ->
            Log.d("Result","Questions: ${questionItem.question}")
        }

    }


}