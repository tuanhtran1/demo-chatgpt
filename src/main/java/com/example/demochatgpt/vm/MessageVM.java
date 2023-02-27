package com.example.demochatgpt.vm;

import com.theokanning.openai.Usage;
import com.theokanning.openai.completion.CompletionChoice;
import lombok.Data;

import java.util.List;

@Data
public class MessageVM {
	
	String id;
	
	String object;

	long created;
	
	/**
	 * The GPT-3 model used.
	 */
	String model;
	
	/**
	 * A list of generated completions.
	 */
	List<CompletionChoice> choices;
	
	/**
	 * The API usage for this request
	 */
	Usage usage;
}
