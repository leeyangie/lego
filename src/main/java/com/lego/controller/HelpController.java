package com.lego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpController {

	 @GetMapping("/help")
	    public String helpList(Model model) {
	        // 필요한 데이터가 있으면 모델에 추가
	        // model.addAttribute("attributeName", attributeValue);
	        return "help/helpList";
    }
}
	
