package com.example.demochatgpt.service;

import com.example.demochatgpt.dto.MessageDTO;
import com.example.demochatgpt.vm.MessageVM;
import com.theokanning.openai.completion.CompletionResult;

public interface ChatGPTService {
	
	CompletionResult chatGPT(MessageDTO dto);
	
}
