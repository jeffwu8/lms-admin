package com.smoothstack.avalanche.lms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {
	
	@EmbeddedId
	private BookLoanKey bookLoanKey;
    
    @Column(name = "date_out")
	private Date dateOut;
    
    @Column(name = "date_due")
	private Date dateDue;
    
    @Column(name = "date_in")
	private Date dateIn;
    /*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
     */
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
}
