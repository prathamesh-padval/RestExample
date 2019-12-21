package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.entity.BookDetails;

@Repository
public interface BookRepo extends JpaRepository<BookDetails, Integer>{

	BookDetails findByBookName(String name);

	int deleteByBookName(String name);

	BookDetails findByBookNameAndAuthor(String bookName, String author);

}
