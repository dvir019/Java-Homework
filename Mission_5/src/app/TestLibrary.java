package app;

public class TestLibrary {
	public static void main(String[] args) {
		Book book = new Book();
		System.out.println(book);
		book.set("Hey", "Dani Din", 9875, 200);
		System.out.println(book);
	}
}