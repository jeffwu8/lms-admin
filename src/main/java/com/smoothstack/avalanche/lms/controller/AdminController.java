package com.smoothstack.avalanche.lms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.avalanche.lms.entity.*;
import com.smoothstack.avalanche.lms.svc.AdminSVC;

@RestController
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
@RequestMapping(path = "/lms/admin")
public class AdminController {
	@Autowired
	AdminSVC adminService;

	/*
	 * Author Mappings
	 */
	@GetMapping(path = "/authors")
	public List<Author> readAllAuthors() {
		return adminService.readAllAuthors();
	}

	@PostMapping(path = "/author")
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
		adminService.createAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.CREATED);
		return response;
	}

	@PutMapping(path = "/authors/{authorId}")
	public ResponseEntity<Author> updateAuthor(@Valid @RequestBody Author author,
			@Valid @PathVariable Long authorId) {
		adminService.updateAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}

	@DeleteMapping(path = "/authors/{authorId}")
	public ResponseEntity<Author> deleteAuthor(@Valid @PathVariable Long authorId) {
		adminService.deleteAuthor(authorId);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}

	/*
	 * Book Mappings
	 */
	@GetMapping(path = "/books")
	public List<Book> readAllBooks() {
		return adminService.readAllBooks();
	}

	@PostMapping(path = "/book")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		adminService.createBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.CREATED);
		return response;
	}

	@PutMapping(path = "/books/{bookId}")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @Valid @PathVariable Long bookId) {
		adminService.updateBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}

	@DeleteMapping(path = "/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@Valid @PathVariable Long bookId) {
		adminService.deleteBook(bookId);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}

	/*
	 * Publisher Mappings
	 */
	@GetMapping(path = "/publishers")
	public List<Publisher> readAllPublishers() {
		return adminService.readAllPublishers();
	}

	@PostMapping(path = "/publisher")
	public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody Publisher publisher) {
		adminService.createPublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.CREATED);
		return response;
	}

	@PutMapping(path = "/publishers/{publisherId}")
	public ResponseEntity<Publisher> updatePublisher(@Valid @RequestBody Publisher publisher,
			@Valid @PathVariable Long publisherId) {
		adminService.updatePublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}

	@DeleteMapping(path = "/publishers/{publisherId}")
	public ResponseEntity<Publisher> deletePublisher(@Valid @PathVariable Long publisherId) {
		adminService.deletePublisher(publisherId);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}

	/*
	 * Branch Mappings
	 */
	@GetMapping(path = "/branches")
	public List<Branch> readAllBranches() {
		return adminService.readAllBranches();
	}

	@PostMapping(path = "/branch")
	public ResponseEntity<Branch> createBranch(@Valid @RequestBody Branch branch) {
		adminService.createBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.CREATED);
		return response;
	}

	@PutMapping(path = "/branches/{branchId}")
	public ResponseEntity<Branch> updateBranch(@Valid @RequestBody Branch branch,
			@Valid @PathVariable Long branchId) {
		adminService.updateBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}

	@DeleteMapping(path = "/branches/{branchId}")
	public ResponseEntity<Branch> deleteBranch(@Valid @PathVariable Long branchId) {
		adminService.deleteBranch(branchId);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}

	/*
	 * Borrower Mappings
	 */
	@GetMapping(path = "/borrowers")
	public List<Borrower> readAllBorrowers() {
		return adminService.readAllBorrowers();
	}

	@PostMapping(path = "/borrower")
	public ResponseEntity<Borrower> createBorrower(@Valid @RequestBody Borrower borrower) {
		adminService.createBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.CREATED);
		return response;
	}

	@PutMapping(path = "/borrowers/{cardNo}")
	public ResponseEntity<Borrower> updateBorrower(@Valid @RequestBody Borrower borrower,
			@Valid @PathVariable Long cardNo) {
		adminService.updateBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}

	@DeleteMapping(path = "/borrowers/{cardNo}")
	public ResponseEntity<Borrower> deleteBorrower(@Valid @PathVariable Long cardNo) {
		adminService.deleteBorrower(cardNo);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}

	/*
	 * Loan Mappings
	 */
	@GetMapping(path = "/loans")
	public List<BookLoans> readAllLoans() {
		return adminService.readAllBookLoans();
	}

	@PutMapping(path = "/loans:renew")
	public ResponseEntity<BookLoans> updateBookLoan(@Valid @RequestBody BookLoans bookLoan) {
		adminService.updateBookLoan(bookLoan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
		return response;
	}
}
