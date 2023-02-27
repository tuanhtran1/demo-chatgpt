package com.example.demochatgpt.api;

import com.example.demochatgpt.dto.MessageDTO;
import com.example.demochatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class ChatGPTApi {
	
	@Autowired
	public ChatGPTService chatGPTService;
	

	@PostMapping("/chat-gpt")
	public String chatGPT(@RequestBody MessageDTO messageDTO){
		CompletionResult result = chatGPTService.chatGPT(messageDTO);
		return result.getObject().toString();
	}

}
