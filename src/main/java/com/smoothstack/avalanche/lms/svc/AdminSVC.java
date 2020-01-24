package com.smoothstack.avalanche.lms.svc;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.*;
import com.smoothstack.avalanche.lms.entity.*;
import com.smoothstack.avalanche.lms.error.NotFoundException;

@Service
public class AdminSVC {

	@Autowired
	private AuthorDAO authorDAO;

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private PublisherDAO publisherDAO;

	@Autowired
	private BranchDAO branchDAO;

	@Autowired
	private BorrowerDAO borrowerDAO;

	@Autowired
	private BookLoansDAO loansDAO;

	/*
	 * Book Functions
	 */
	public List<Book> readAllBooks() {
		return bookDAO.findAll();
	}

	public void createBook(Book book) {
		if (book.getTitle() != null) {
			bookDAO.save(book);
		} else {
			throw new ConstraintViolationException("Invalid Request Body", null, "title");
		}
	}

	public void deleteBook(Long bookId) {
		if (bookDAO.existsById(bookId)) {
			bookDAO.deleteById(bookId);
		} else {
			throw new NotFoundException("BookId not found: " + bookId);
		}
	}

	public void updateBook(Book book) {
		if (bookDAO.existsById(book.getId())) {
			bookDAO.save(book);
		} else {
			throw new NotFoundException("BookId not found: " + book.getId());
		}
	}

	/*
	 * Author functions
	 */
	public List<Author> readAllAuthors() {
		return authorDAO.findAll();
	}

	public void createAuthor(Author author) {
		if (author.getName() != null) {
			authorDAO.save(author);
		} else {
			throw new ConstraintViolationException("Invalid Request Body", null, "authorName");
		}
	}

	public void deleteAuthor(Long authorId) {
		if (authorDAO.existsById(authorId)) {
			authorDAO.deleteById(authorId);
		} else {
			throw new NotFoundException("AuthorId not found: " + authorId);
		}
	}

	public void updateAuthor(Author author) {
		if (authorDAO.existsById(author.getId())) {
			authorDAO.save(author);
		} else {
			throw new NotFoundException("AuthorId not found: " + author.getId());
		}
	}

	/*
	 * Publisher Functions
	 */
	public List<Publisher> readAllPublishers() {
		return publisherDAO.findAll();
	}

	public void createPublisher(Publisher publisher) {
		if (publisher.getName() != null) {
			publisherDAO.save(publisher);
		} else {
			throw new ConstraintViolationException("Invalid Request Body", null, "publisherName");
		}
	}

	public void deletePublisher(Long publisherId) {
		if (publisherDAO.existsById(publisherId)) {
			publisherDAO.deleteById(publisherId);
		} else {
			throw new NotFoundException("PublisherId not found: " + publisherId);
		}
	}

	public void updatePublisher(Publisher publisher) {
		if (publisherDAO.existsById(publisher.getId())) {
			publisherDAO.save(publisher);
		} else {
			throw new NotFoundException("PublisherId not found: " + publisher.getId());
		}
	}

	/*
	 * Library Branch Functions
	 */
	public List<Branch> readAllBranches() {
		return branchDAO.findAll();
	}

	public void createBranch(Branch branch) {
		if (branch.getName() != null) {
			branchDAO.save(branch);
		} else {
			throw new ConstraintViolationException("Invalid Request Body", null, "branchName");
		}
	}

	public void deleteBranch(Long branchId) {
		if (branchDAO.existsById(branchId)) {
			branchDAO.deleteById(branchId);
		} else {
			throw new NotFoundException("BranchId not found: " + branchId);
		}
	}

	public void updateBranch(Branch branch) {
		if (branchDAO.existsById(branch.getId())) {
			if (branch.getName() != null) {
				branchDAO.save(branch);
			} else {
				throw new ConstraintViolationException("Invalid Request Body", null, "branchName");
			}
		} else {
			throw new NotFoundException("BranchId not found: " + branch.getId());
		}
	}

	/*
	 * Borrower Functions
	 */
	public List<Borrower> readAllBorrowers() {
		return borrowerDAO.findAll();
	}

	public void createBorrower(Borrower borrower) {
		if (borrower.getName() != null) {
			borrowerDAO.save(borrower);
		} else {
			throw new ConstraintViolationException("Invalid Request Body", null, "borrowerName");
		}
	}

	public void deleteBorrower(Long cardNo) {
		if (borrowerDAO.existsById(cardNo)) {
			borrowerDAO.deleteById(cardNo);
		} else {
			throw new NotFoundException("CardNo not found: " + cardNo);
		}
	}

	public void updateBorrower(Borrower borrower) {
		if (borrowerDAO.existsById(borrower.getCardNo())) {
			if (borrower.getName() != null) {
				borrowerDAO.save(borrower);
			} else {
				throw new ConstraintViolationException("Invalid Request Body", null, "borrowerName");
			}
		} else {
			throw new NotFoundException("BorrowerId not found: " + borrower.getCardNo());
		}
	}

	/*
	 * Loan Functions
	 */
	public List<BookLoans> readAllBookLoans() {
		return loansDAO.findAll();
	}

	public void updateBookLoan(BookLoans loan) {
		loansDAO.save(loan);
	}

}