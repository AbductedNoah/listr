package com.nwplus.Listr.Book.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResponse(int numFound, int start, boolean numFoundExact, List<Book> docs, String q, String offset) {
	public BookResponse() {
		this(0, 0, true, null, null,null);
	}
}