package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Entity
@Table(name = "tbl_book")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "title")
	private String title;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Author> authors;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@OneToMany(mappedBy = "bookLoanKey.book")
	private List<BookLoans> loanBooks;

	/*
	 * Getters
	 */
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Set<Author> getBookAuthors() {
		return authors;
	}
	public Publisher getPublisher() {
		return publisher;
	}

	/*
	 * Setters
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBookAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
