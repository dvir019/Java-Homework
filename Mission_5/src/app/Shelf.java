package app;

import java.util.ArrayList;

public class Shelf {
	private int shelfNumber;
	private ArrayList<Book> books;

	// Min values
	private static final int SHELF_NUMBER_MIN = 0;

	// Default values
	private static final int SHELF_NUMBER_DEFAULT = 0;

	public Shelf(int shelfNumber) {
		init();
		setShelfNumber(shelfNumber);
	}

	public Shelf() {
		this(SHELF_NUMBER_DEFAULT);
	}

	public int getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(int shelfNumber) {
		// TODO - Check what to do if negative
		if (shelfNumber < SHELF_NUMBER_MIN) {
			this.shelfNumber = SHELF_NUMBER_DEFAULT;
		} else {
			this.shelfNumber = shelfNumber;
		}
	}

	public void init() {
		books = new ArrayList<Book>();
	}

	public int getNumberOfBooks() {
		return books.size();
	}

	public int getNumberOfPages() {
		int pagesCounter = 0;
		for (Book book : books) {
			pagesCounter += book.getPages();
		}
		return pagesCounter;
	}
}