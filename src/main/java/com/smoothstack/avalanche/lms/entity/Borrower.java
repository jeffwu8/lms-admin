package com.smoothstack.avalanche.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_borrower")
public class Borrower {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardNo;
    
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "borrower", 
			cascade = CascadeType.ALL)
	private List<BookLoans> loanBooks;
    /*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
     */
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
