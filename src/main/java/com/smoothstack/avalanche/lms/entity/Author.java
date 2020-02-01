package com.smoothstack.avalanche.lms.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_author")
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "name")
	private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "tbl_book_authors",
    		joinColumns = @JoinColumn(name = "authorId", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(name = "bookId", referencedColumnName = "id"))
    private Set<Book> books;
    
    /*
     * Constructors
     */
    public Author() {}
	public Author(Long id, String name) {
		this.id = id;
		this.name = name;
	}

    /*
     * Getters
     */
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	/*
	 * Setters
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Equals/ HashCode
	 */
	@Override
	public boolean equals(Object o)
	{
		if( this == o) return true;
		if( o == null || getClass() != o.getClass())
			return false;
		Author other = (Author) o;
		return Objects.equals(getName(), other.getName());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(name);
	}
}
