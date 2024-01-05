package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a library book which extends the book class.
 * 
 * @author Sasha Rybalkina
 * @version September 5, 2022
 */
public class LibraryBook extends Book {
	
	private String holder;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	public String getHolder() {
		return this.holder;
	}
	
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	public void checkIn() {
		holder = null;
		dueDate = null;
	}
	
	public void checkOut(String holder, GregorianCalendar dueDate) {
		this.holder = holder;
		this.dueDate = dueDate;
	}
}
