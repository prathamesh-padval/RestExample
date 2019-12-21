package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.BookDetails;
import com.rest.repo.BookRepo;
import com.rest.util.EntityGenrator;

@Service
public class BookService {

	@Autowired
	BookRepo repo;

	public List getBooks() {
		return repo.findAll();
	}

	public BookDetails getBook(String name) {
		return repo.findByBookName(name);
	}

	public String addBook(BookDetails details) {

		BookDetails dbDetails = fetch(details);
		if (dbDetails != null) {
			dbDetails = EntityGenrator.generateEntity(dbDetails, details);
			repo.save(dbDetails);
			return "Book Updated Successfully...!!!";
		} else {
			repo.save(details);
			return "Book Added Successfully...!!!";
		}
	}

	public String deleteBook(String name) {
		BookDetails result = repo.findByBookName(name);
		System.out.println(result);
		repo.delete(result);
		return "Book Deleted...!!!";
	}

	private BookDetails fetch(BookDetails details) {
		return repo.findByBookNameAndAuthor(details.getBookName(), details.getAuthor());
	}

}
