package com.nwplus.Listr.Book.Converters;

import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwplus.Listr.Book.Data.BookResponse;

@Service
public class BookResponseConverter {
	
	
	public BookResponse convertToBookResponse(HttpResponse<String> response) {
		BookResponse bookResponse = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			bookResponse = objectMapper.readValue(response.body(), BookResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return bookResponse;
	}
}