package com.nwplus.Listr.Book.Controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwplus.Listr.Book.Data.BookResponse;
import com.nwplus.Listr.Book.Service.BookService;
 
@RestController()
@RequestMapping(value = "/books")
public class BooksController {
	
	private BookService bookService = new BookService();
	
	@GetMapping("/searchByTitle/{title}")
	public ResponseEntity<BookResponse> getBookByTitle(@PathVariable String title) {
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(bookService.searchBookByName(title));
	}
	
	@GetMapping("/coverByIsbn/{isbn}")
	public ResponseEntity<String> getCoverByIsbn(@PathVariable String isbn) {
		return ResponseEntity.ok()
				.contentType(MediaType.TEXT_PLAIN)
				.body(bookService.createIsbnUrl(isbn));
	}
	
}