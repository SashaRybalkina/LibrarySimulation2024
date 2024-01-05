package assign02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * This class contains tests for Library.
 * 
 * @author Erin Parker and Sasha Rybalkina
 * @version September 2, 2020
 */
public class LibraryTester {

	private Library emptyLib, smallLib, mediumLib;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyLib = new Library();
		
		smallLib = new Library();
		smallLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		smallLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		smallLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		mediumLib = new Library();
		mediumLib.addAll("src/assign02/Mushroom_Publishing.txt");
	}
	
	/**
	 * My tests
	 */
	
	@Test
	public void testMediumLibraryLookupISBN() {
		assertNull(mediumLib.lookup(9781843192022L));
	}
	
	@Test
	public void testMediumLibraryLookupHolder() {
		mediumLib.checkout(9781843192022L, "Justin Bieber", 5, 12, 2022);
		mediumLib.checkout(9781843192039L, "Justin Bieber", 6, 27, 2022);
		mediumLib.checkout(9781843193319L, "Denald Tramp", 2, 15, 2023);
		ArrayList<LibraryBook> booksCheckedOut = mediumLib.lookup("Justin Bieber");
		ArrayList<LibraryBook> booksCheckedOut2 = mediumLib.lookup("Denald Tramp");
		
		assertNotNull(booksCheckedOut);
		assertNotNull(booksCheckedOut2);
		assertEquals(2, booksCheckedOut.size());
		assertEquals(1, booksCheckedOut2.size());
		assertEquals(new Book(9781843192022L, "Roger Taylor", "Whistler"), booksCheckedOut.get(0));
		assertEquals(new Book(9781843192039L, "William Fitzmaurice", "Operation: Sergeant York"), booksCheckedOut.get(1));
		assertEquals(new Book(9781843193319L, "Alan Burt Akers", "Transit to Scorpio"), booksCheckedOut2.get(0));
		assertEquals("Justin Bieber", booksCheckedOut.get(0).getHolder());
		assertEquals("Justin Bieber", booksCheckedOut.get(1).getHolder());
		assertEquals("Denald Tramp", booksCheckedOut2.get(0).getHolder());
	}

	@Test
	public void testMediumLibraryCheckout() {
		assertTrue(mediumLib.checkout(9781843192022L, "Justin Bieber", 5, 12, 2022));
		assertTrue(mediumLib.checkout(9781843192039L, "Justin Bieber", 6, 27, 2022));
		assertTrue(mediumLib.checkout(9781843193319L, "Denald Tramp", 2, 15, 2023));
	}

	@Test
	public void testMediumLibraryCheckinISBN() {
		mediumLib.checkout(9781843192022L, "Justin Bieber", 5, 12, 2022);
		mediumLib.checkout(9781843192039L, "Justin Bieber", 6, 27, 2022);
		mediumLib.checkout(9781843193319L, "Denald Tramp", 2, 15, 2023);
		assertTrue(mediumLib.checkin(9781843192022L));
		assertTrue(mediumLib.checkin(9781843192039L));
		assertTrue(mediumLib.checkin(9781843193319L));
	}

	@Test
	public void testMediumLibraryCheckinHolder() {
		assertFalse(mediumLib.checkin("Justin Bieber"));
		assertFalse(mediumLib.checkin("Denald Tramp"));
	}

	/**
	 * End of my tests
	 */

	@Test
	public void testEmptyLookupISBN() {
		assertNull(emptyLib.lookup(978037429279L));
	}
	
	@Test
	public void testEmptyLookupHolder() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLib.lookup("Jane Doe");
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}
	
	@Test
	public void testEmptyCheckout() {
		assertFalse(emptyLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
	}

	@Test
	public void testEmptyCheckinISBN() {
		assertFalse(emptyLib.checkin(978037429279L));
	}
	
	@Test
	public void testEmptyCheckinHolder() {
		assertFalse(emptyLib.checkin("Jane Doe"));
	}

	@Test
	public void testSmallLibraryLookupISBN() {
		assertNull(smallLib.lookup(9780330351690L));
	}
	
	@Test
	public void testSmallLibraryLookupHolder() {
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		ArrayList<LibraryBook> booksCheckedOut = smallLib.lookup("Jane Doe");
		
		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());
	}

	@Test
	public void testSmallLibraryCheckout() {
		assertTrue(smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));
	}

	@Test
	public void testSmallLibraryCheckinISBN() {
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		assertTrue(smallLib.checkin(9780330351690L));
	}

	@Test
	public void testSmallLibraryCheckinHolder() {
		assertFalse(smallLib.checkin("Jane Doe"));
	}
}