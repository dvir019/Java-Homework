package app;

import java.util.ArrayList;

public class Library {
	// TODO - check if ArrayList<Shelf> is fine
	private String libraryName;
	private ArrayList<Shelf> shelves;

	private static final int NUMBER_OF_SHELVES = 10;

	// Default values
	private static final String EMPTY_LIBRARY_DEFAULT = "";

	public Library(String libraryName) {
		this.libraryName = libraryName;
		init();
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	private void init() {
		shelves = new ArrayList<Shelf>();
		for (int i = 0; i < NUMBER_OF_SHELVES; i++) {
			shelves.add(new Shelf(i));
		}
	}

	public int getNumberOfBooks() {
		int booksCounter = 0;
		for (Shelf shelf : shelves) {
			booksCounter += shelf.getNumberOfBooks();
		}
		return booksCounter;
	}

	public int getNumberOfPages() {
		int pagesCounter = 0;
		for (Shelf shelf : shelves) {
			pagesCounter += shelf.getNumberOfPages();
		}
		return pagesCounter;
	}

	public boolean addBook(Book book, int shelfNumber) {
		if (shelfNumber > 0 && shelfNumber <= NUMBER_OF_SHELVES) {
			return shelves.get(shelfNumber - 1).addBook(book);
		}
		return false;
	}

	public boolean addBook(Book book) {
		for (int i = 1; i <= NUMBER_OF_SHELVES; i++) {
			if (addBook(book, i)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeBook(int shelfNumber, int bookNumber) {
		if (shelfNumber > 0 && shelfNumber <= NUMBER_OF_SHELVES) {
			return shelves.get(shelfNumber - 1).removeBook(bookNumber);
		}
		return false;
	}

	public boolean isEmpty() {
		for (Shelf shelf : shelves) {
			if (!shelf.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public void print(boolean extended) {
		if (extended) {
			System.out.println(extendedToString());
		} else {
			System.out.println(toString());
		}
	}

	public String extendedToString() {
		String str = toString();
		if (str.equals(EMPTY_LIBRARY_DEFAULT)) {
			return String.format("%s is empty.", libraryName);
		}
		return str;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return EMPTY_LIBRARY_DEFAULT;
		}
		String str = String.format("%s contains %d books summing %d pages.\nThe books on the %s are:\n", libraryName,
				getNumberOfBooks(), getNumberOfPages(), libraryName);
		for (Shelf shelf : shelves) {
			str = str + "\t" + shelf.toString() + "\n";
		}
		return str;
	}
}