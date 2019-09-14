package app;

import java.util.ArrayList;

public class Shelf {
	private int shelfNumber;
	private ArrayList<Book> books;

	// Max values
	private static final int BOOKS_MAX = 5;
	private static final int PAGES_MAX = 1500;

	// Min values
	private static final int SHELF_NUMBER_MIN = 0;
	private static final int BOOKS_MIN = 0;

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

	public boolean addBook(Book book) {
		if (getNumberOfBooks() < BOOKS_MAX && getNumberOfPages() < PAGES_MAX) {
			books.add(book);
			return true;
		}
		return false;
	}

	public boolean removeBook(int bookIndex) {
		if (bookIndex > 0 && bookIndex <= getNumberOfBooks()) {
			books.remove(bookIndex - 1);
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return getNumberOfBooks() == 0;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return ("");
		String str = String.format("The books on the shelf number $d are:\n", shelfNumber);
		for (Book book : books) {
			str = str + "\t" + book.toString() + "\n";
		}
		return (str);
	}
}