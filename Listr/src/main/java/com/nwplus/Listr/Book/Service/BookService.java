package com.nwplus.Listr.Book.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.UriEncoder;

import com.nwplus.Listr.Book.Converters.BookResponseConverter;
import com.nwplus.Listr.Book.Data.BookResponse;

@Service
public class BookService{
	
	private final BookResponseConverter responseConverter = new BookResponseConverter();
	
	private static final String OPEN_API_SEARCH_TITLE = "https://openlibrary.org/search.json?title=";
	private static final String OPEN_API_COVER_ISBN = "https://covers.openlibrary.org/b/isbn/";
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	public BookResponse searchBookByName(String title) {
		HttpResponse<String> response = getHttpResponse(title);
		return responseConverter.convertToBookResponse(response);
	}
	
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public String createIsbnUrl(String isbn) {
		return OPEN_API_COVER_ISBN.concat(isbn).concat("-M.jpg");
	}

	/**
	 * 
	 * @param title
	 * @return
	 */
	private HttpResponse<String> getHttpResponse(String title) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(OPEN_API_SEARCH_TITLE + UriEncoder.encode(title)))
				.GET()
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		
		return response;
	}

}