package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.BookDetails;
import com.rest.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping(value="getBooks" , method = RequestMethod.GET)
	public ResponseEntity<?> getAllBooks() {
		try {
			List list = service.getBooks();
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.CONTINUE);
		}
	}
	
	@RequestMapping(value = "/getBook" ,  method = RequestMethod.POST)
	public ResponseEntity<?> getBook(@RequestParam("bookName") String bookName) {
		try {
			BookDetails details = service.getBook(bookName);
			return new ResponseEntity<>(details,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.CONTINUE);
			// TODO: handle exception
		}
	}
	
	@RequestMapping(value = "/insert" ,  method = RequestMethod.POST)
	public ResponseEntity<?> addBook(@RequestBody BookDetails details) {
		try {
			String result = service.addBook(details);
			return new ResponseEntity<>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.CONTINUE);
			// TODO: handle exception
		}
	}
	
	@RequestMapping(value = "/delete" ,  method = RequestMethod.POST)
	public ResponseEntity<?> deleteBook(@RequestParam("bookName") String bookName) {
		try {
			String result  = service.deleteBook(bookName);
			return new ResponseEntity<>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.CONTINUE);
			// TODO: handle exception
		}
	}

}
