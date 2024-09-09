package com.astooltech.advancedview.proteus.parser.adapterskit;


import com.astooltech.advancedview.R;

public class Book {
	private String bookName;
	private String bookAuthor;
	private String bookCategory;

	public Book(String bookName, String bookAuthor, String bookCategory) {
		this.setBookAuthor(bookAuthor);
		this.setBookCategory(bookCategory);
		this.setBookName(bookName);
	}

	//@InstantText(viewId = R.id.t_time)
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	//@InstantText(viewId = R.id.t_title)
	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

}
