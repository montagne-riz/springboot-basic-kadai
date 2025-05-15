package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class ContactFormController {

	@PostMapping("/")
public String submitForm(@RequestParam("name")  String name,
		                 @RequestParam ("email") String email,
		                 @RequestParam ("message")String message,
		                 Model model) {
		
		 StringBuilder errorMessage = new StringBuilder();


		
		
		// 空フィールドチェック
        if (name.isEmpty()) {
            errorMessage.append("お名前を入力してください。<br>");
        }
        if (email.isEmpty()) {
            errorMessage.append("メールアドレスを入力してください。<br>");
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errorMessage.append("メールアドレスの形式が正しくありません。<br>");
        }
        if (message.isEmpty()) {
            errorMessage.append("お問い合わせ内容を入力してください。<br>");
        }

        // エラーメッセージがある場合、フォームを再表示
        if (errorMessage.length() > 0) {
            model.addAttribute("failureMessage", errorMessage.toString());
            return "contactFormView";
        }

         //エラ-がないときは確認画面へ
					
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("message", message);
        
        
        return "confirmFormView";
	
	}
		
	}	
	

