package app;

public class Book {
	private String name;
	private String author;
	private int year;
	private int pages;

	// Max values
	private static final int YEAR_MAX = 2019;

	// Min values
	private static final int YEAR_MIN = 0;
	private static final int PAGES_MIN = 0;

	// Default values
	private static final String NAME_DEFAULT = "";
	private static final String AUTHOR_DEFAULT = "";
	private static final int YEAR_DEFAULT = 0;
	private static final int PAGES_DEFAULT = 0;

	public Book(String name, String author, int year, int pages) {
		set(name, author, year, pages);
	}

	public Book() {
		this(NAME_DEFAULT, AUTHOR_DEFAULT, YEAR_DEFAULT, PAGES_DEFAULT);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		// TODO - Check what to do if negative or greater then 2019
		if (year > YEAR_MAX || year < YEAR_MIN) {
			this.year = YEAR_DEFAULT;
		} else {
			this.year = year;
		}
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		// TODO - Check what to do if negative
		if (pages < PAGES_MIN) {
			this.pages = PAGES_DEFAULT;
		} else {
			this.pages = pages;
		}
	}

	public void set(String name, String author, int year, int pages) {
		setName(name);
		setAuthor(author);
		setYear(year);
		setPages(pages);
	}

	public boolean isEmpty() {
		return name.equals(NAME_DEFAULT) && author.equals(AUTHOR_DEFAULT) && year == YEAR_DEFAULT
				&& pages == PAGES_DEFAULT;
	}

	public void print() {
		String bookStr = toString();
		if (!bookStr.isEmpty())
			System.out.println(bookStr);
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		return String.format("Book Name: %s by %s. %d pages. Year: %d", name, author, pages, year);
	}
}