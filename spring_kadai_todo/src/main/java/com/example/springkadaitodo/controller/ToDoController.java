package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller

public class ToDoController{ 
		private final ToDoService toDoService;
	
		public ToDoController(ToDoService toDoService) {
	        this.toDoService = toDoService;
	    }
	
		 
		
		
	    @GetMapping("/todo")
	    public String todoList(Model model) {
	        List<ToDo> todos = toDoService.getToDoList();
	        System.out.println("取得したtodos: " + todos); // 追加


	        model.addAttribute("todos", todos); //ビューにユーザーリストを渡す
	        return "todoView"; //todoView.htmlを返す
	    }

}