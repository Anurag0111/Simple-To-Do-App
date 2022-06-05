package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.simpletodo.R


class MainActivity : AppCompatActivity() {
    var contentHasLoaded = false
    private lateinit var todoAdapter : ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        todoAdapter = ToDoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)
       btnAddToDo.setOnClickListener {
           val todotitle = etTodoTitle.text.toString()
           if (todotitle.isNotEmpty())
           {
               val todo = ToDo(todotitle)
               todoAdapter.addToDo(todo)
               etTodoTitle.text.clear()

           }
           btnDeleteToDo.setOnClickListener{
               todoAdapter.deleteDoneTodos()

           }

       }
    }





}