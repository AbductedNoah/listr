package com.nwplus.Listr.Book.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(@JsonProperty("author_name") List<String> author, String title, List<String> isbn,
		@JsonProperty("cover_edition_key") String coverId,@JsonProperty("first_sentence") List<String> firstSentence,
		@JsonProperty("ratings_average") Integer rating, String coverImageURL) {
	
	public Book withCoverImageURL(String coverUrl) {
		return new Book(author, title, isbn, coverId, firstSentence, rating, coverUrl);
	}
	
}