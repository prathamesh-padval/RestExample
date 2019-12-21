package com.rest.util;

import com.rest.entity.BookDetails;

public class EntityGenrator {

	public static BookDetails generateEntity(BookDetails dbDetails, BookDetails details) {

		dbDetails.setAuthor(checkNull(dbDetails.getAuthor()) ? details.getAuthor() : dbDetails.getAuthor());

		dbDetails.setBookName(checkNull(dbDetails.getBookName()) ? details.getBookName() : dbDetails.getBookName());

		dbDetails.setGenre(checkNull(dbDetails.getGenre()) ? details.getGenre() : dbDetails.getGenre());

		dbDetails.setPrice(checkNull(dbDetails.getPrice()) ? details.getPrice() : dbDetails.getPrice());

		dbDetails.setLanguage(checkNull(dbDetails.getLanguage()) ? details.getLanguage() : dbDetails.getLanguage());

		return dbDetails;

	}

	public static boolean checkNull(Object obj) {
		return obj == null ? true : false;
	}

}
