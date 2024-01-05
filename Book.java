package assign02;

/**
 * This class represents a book, in which the ISBN, author, and title cannot
 * change once the book is created.  All ISBNs are unique.
 * 
 * @author Erin Parker and Sasha Rybalkina
 * @version September 5, 2022
 */
public class Book {

	private long isbn;
	private String author;
	private String title;

	/**
	 * Creates a book from the given ISBN, author, and title.
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public Book(long isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}

	/**
	 * Accessor method for the author field.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Accessor method for the isbn field.
	 * 
	 * @return the ISBN
	 */
	public long getIsbn() {
		return this.isbn;
	}

	/**
	 * Accessor method for the title field.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Two books are considered equal if they have the same ISBN, author, and
	 * title.
	 * 
	 * @param other - the object begin compared with this book
	 * @return true if other object is a Book type and is equal to this book, false otherwise
	 */
	public boolean equals(Object other) {
		
		if(!(other instanceof Book))
			return false;
		
		Book o = (Book)other;
		
		if(o.getIsbn() == this.getIsbn() && o.getAuthor().equals(this.getAuthor()) && o.getTitle().equals(this.getTitle()))
			return true;
		
		return false;
	}

	/**
	 * Returns a textual representation of this book.
	 */
	public String toString() {
		return isbn + ", " + author + ", \"" + title + "\"";
	}
}