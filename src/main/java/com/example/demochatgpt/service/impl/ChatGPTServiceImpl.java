package com.example.demochatgpt.service.impl;

import com.example.demochatgpt.dto.MessageDTO;
import com.example.demochatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {
	
	private final static String TOKEN = "TOKEN-HERE";
	@Override
	public CompletionResult chatGPT(MessageDTO dto) {
		OpenAiService service = new OpenAiService(TOKEN);
		
		System.out.println("\nCreating completion...");
		CompletionRequest completionRequest = CompletionRequest.builder()
				.model("text-davinci-003")
				.prompt("Somebody once told me the world is gonna roll me")
				.echo(true)
				.user("testing")
				.n(3)
				.build();
		CompletionResult result = service.createCompletion(completionRequest);
		result.getChoices().forEach(System.out::println);
		System.out.println("\nCreating Image...");
		CreateImageRequest request = CreateImageRequest.builder()
				.prompt("A cow breakdancing with a turtle")
				.build();
		
		System.out.println("\nImage is located at:");
		System.out.println(service.createImage(request).getData().get(0).getUrl());
		return result;
	}
}
