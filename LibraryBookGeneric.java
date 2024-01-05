package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a library book which extends the book class and uses a generic type.
 * 
 * @author Sasha Rybalkina
 * @version September 5, 2022
 */
public class LibraryBookGeneric<Type> extends Book {
	
	private Type holder;
	
	private GregorianCalendar dueDate;
	
	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	public Type getHolder() {
		return this.holder;
	}
	
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	public void checkIn() {
		holder = null;
		dueDate = null;
	}
	
	public void checkOut(Type holder, GregorianCalendar dueDate) {
		this.holder = holder;
		this.dueDate = dueDate;
	}
}
