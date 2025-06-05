package com.example.springkadaiform.controller;



import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller

public class ContactFormController {

	//フォームの表示
	@GetMapping("/form")
	public String showContactForm(Model model) {
		if (!model.containsAttribute("contactForm")) {
			
			//ビューにフォームクラスのインスタンスを渡す
			model.addAttribute("contactForm", new ContactForm());

		}

		return "contactFormView";
	}

	//確認画面の表示
	@GetMapping("/confirm")
	public String showConfirmPage(Model model) {
		return "confirmView";
	}

	
		@PostMapping("/form")
		public String submitForm(Model model, RedirectAttributes redirectAttributes,
				@Validated ContactForm form, BindingResult result) {
		   
			if (result.hasErrors()) {
		       
				
				
				//フォームクラスをリダイレクト情報に渡す（フォームの入力をリダイレクト先に一時的に保存できます）
		    	redirectAttributes.addFlashAttribute("contactForm", form);
		      
		    	//バリデーション結果をリダイレクト情報に受け渡す
		    	
		    	
		    	redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
		    			                   + Conventions.getVariableName(form), result);
		    	
		    	
		    	//contactFormにリダイレクトして、フォームクラスとエラーメッセージを表示
		    	return "redirect:/form";

		    }

			//バリデーションOKの時は確認画面へ
			model.addAttribute("contactForm", form);
			
			
			return "confirmView";

	}
		}

