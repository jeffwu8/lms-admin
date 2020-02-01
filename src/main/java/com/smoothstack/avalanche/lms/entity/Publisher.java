package com.smoothstack.avalanche.lms.entity;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "publisher")
	private Collection<Book> publisherBooks;

	/*
	 * Constructors
	 */
	public Publisher() {}
	public Publisher(Long id, String name, String address, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
	/*
	 * Equals and Hashcode
	 */
	@Override
	public boolean equals(Object o)
	{
		if( this == o) return true;
		if( o == null || getClass() != o.getClass())
			return false;
		Publisher other = (Publisher) o;
		return Objects.equals(getName(), other.getName())
				&& Objects.equals(getAddress(), other.getAddress())
				&& Objects.equals(getPhone(), other.getPhone());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(name, address, phone);
	}
}
