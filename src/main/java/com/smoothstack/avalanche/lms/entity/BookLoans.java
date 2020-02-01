package com.smoothstack.avalanche.lms.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {
	
	@EmbeddedId
	private BookLoanKey bookLoanKey;
    
	@MapsId("bookId")
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@MapsId("branchId")
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@MapsId("cardNo")
	@ManyToOne
	@JoinColumn(name = "card_no")
	private Borrower borrower;
	
    @Column(name = "date_out")
	private Date dateOut;
    
    @Column(name = "date_due")
	private Date dateDue;
    
    @Column(name = "date_in")
	private Date dateIn;
    
    /*
     * Constructors
     */

	public BookLoans() {}

	public BookLoans(BookLoanKey bookLoanKey, Date dateOut, Date dateDue, Date dateIn) {

		this.bookLoanKey = bookLoanKey;
		this.dateOut = dateOut;
		this.dateDue = dateDue;
		this.dateIn = dateIn;
	}
    
    /*
     * Getters and Setters
     */
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	public BookLoanKey getBookLoanKey() {
		return bookLoanKey;
	}
	public void setBookLoanKey(BookLoanKey bookLoanKey) {
		this.bookLoanKey = bookLoanKey;
	}
	
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	
	public Date getDateDue() {
		return dateDue;
	}
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}
	
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	
	/*
	 * Equals / Hash-code
	 */
	@Override
	public boolean equals(Object o)
	{
		if( this == o) return true;
		if( o == null || getClass() != o.getClass())
			return false;
		BookLoans other = (BookLoans) o;
		return Objects.equals(getBook(), other.getBook()) && 
				Objects.equals(getBranch(), other.getBranch()) &&
				Objects.equals(getBorrower(), other.getBorrower()) &&
				Objects.equals(getDateOut(), other.getDateOut());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(bookLoanKey);
	}
}
