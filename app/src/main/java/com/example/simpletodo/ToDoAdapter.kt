package com.example.simpletodo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemtodo_list.view.*

class ToDoAdapter(private val Todos:MutableList<ToDo>) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {

        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemtodo_list,
                parent,
                false)
        )


    }
    fun addToDo(todo: ToDo){
        
   Todos.add(todo)
        notifyItemInserted(Todos.size -1)
   }

    fun deleteDoneTodos()
    {
        Todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }




    private fun toggleStrikeThrough(tvToDoTitle: TextView,cbDone:Boolean)
    {
    if (cbDone)
    {
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
     } else
    {
        tvToDoTitle.paintFlags = tvToDoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
            var curTodo = Todos[position]

       holder.itemView.apply {
       tvTodoTitle.text = curTodo.title
           cbDone.isChecked = curTodo.isChecked
           toggleStrikeThrough(tvTodoTitle,cbDone.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked -> toggleStrikeThrough(tvTodoTitle,isChecked)
            curTodo.isChecked = !curTodo.isChecked}
       }
    }

    override fun getItemCount(): Int {

        return Todos.size
        }
    class ToDoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {


    }
}