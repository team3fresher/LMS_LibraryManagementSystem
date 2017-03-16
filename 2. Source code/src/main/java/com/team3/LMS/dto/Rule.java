package com.team3.LMS.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rules")
public class Rule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rule_id")
	private int ruleId;

	@Column(name = "borrowing_time")
	private int borrowingTime;

	@Column(name = "fine_per_day")
	private int finePerDay;

	@Column(name = "min_left")
	private int minLeft;

	@OneToMany(mappedBy = "rule")
	private List<Book> books;

	public Rule() {
	}
	
	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public int getBorrowingTime() {
		return this.borrowingTime;
	}

	public void setBorrowingTime(int borrowingTime) {
		this.borrowingTime = borrowingTime;
	}

	public int getFinePerDay() {
		return this.finePerDay;
	}

	public void setFinePerDay(int finePerDay) {
		this.finePerDay = finePerDay;
	}

	public int getMinLeft() {
		return this.minLeft;
	}

	public void setMinLeft(int minLeft) {
		this.minLeft = minLeft;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setRule(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setRule(null);

		return book;
	}

}