package sample.Library;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookRentalSystemTest {
    /**
     * for checking of string output.
     */
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        BookRentalSystem.clearLibrary();

        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    @Order(1)
    @DisplayName("Book Creation")
    @Test
    void testAddBooksPrintedOutputOfAddedBook() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        ArrayList<Book> returnedList = BookRentalSystem.getLibrary();

        assertEquals(BookRentalSystem.getLibrarySize(), 1,
                "Book should be added");
        assertTrue(BookRentalSystem.getLibrary().contains(BookRentalSystem.
                get(0)), "The library should contain the added book.");
        assertEquals(BookRentalSystem.get(0).isRented(), false,
                "Book should not be rented");
        assertNotNull(returnedList);
        assertFalse(returnedList.isEmpty());
        assertEquals(BookRentalSystem.getLibrarySize(), returnedList.size());
    }

    @Order(2)
    @DisplayName("Rent Book")
    @Test
    void testRentBooksPrintedOutputOfRentedBook() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));

        BookRentalSystem.get(0).rent();

        assertEquals(BookRentalSystem.get(0).isRented(),
                true,  "Book should be rented");
    }

    @Order(3)
    @DisplayName("Add Books")
    @Test
    void testAddBooksAdd1FictionAnd1NonFictionLibrarySizeEquals2() {
        ArrayList<Book> newBooks = new ArrayList<>();
        newBooks.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        newBooks.add(new FictionBook("To Kill a Mockingbird",
                "Harper Lee", 1960));

        BookRentalSystem.addBooks(newBooks);

        assertEquals(BookRentalSystem.getLibrarySize(), 2,
                "Book should be added");
    }

    @Order(4)
    @DisplayName("Add 2 Books with Valid Index and Rent 1 then Check isRented")
    @Test
    void testRentBooksAdd2BooksThenRent1isRentEqualsTrueFor1() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        BookRentalSystem.add(new FictionBook("To Kill a Mockingbird",
                "Harper Lee", 1960));

        BookRentalSystem.get(0).rent();

        assertEquals(BookRentalSystem.get(0).isRented(),
                true,  "Book should be rented");
        assertEquals(BookRentalSystem.get(1).isRented(),
                false,  "Book should not be rented");
    }

    @Order(5)
    @DisplayName("Rent Books with Invalid Index")
    @Test
    void testRentBookAdd1BookThenRentInvalidIndexOutOfBoundsError() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            BookRentalSystem.get(1).rent();
        }, "Accessing index 1 should throw an IndexOutOfBoundsException.");
    }

    @Order(6)
    @DisplayName("Add 2 Books and compare output")
    @Test
    void testDisplayAllBooks() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        BookRentalSystem.add(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.displayBooks();
        String expectedOutput =
                "The Lord of the Rings J.R.R. Tolkien 1954"
                + System.lineSeparator()
                + "The Tipping Point M. Gladwell 2000";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(7)
    @DisplayName("Add 2 Books Rent 1 then Display Rented Books")
    @Test
    void testDisplayRentedBooks() {
        BookRentalSystem.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        BookRentalSystem.add(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.get(0).rent();
        BookRentalSystem.displayRentedBooks(BookRentalSystem.getLibrary());
        String expectedOutput =
                "Books rented:"
                + System.lineSeparator()
                + "The Lord of the Rings J.R.R. Tolkien 1954";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(8)
    @DisplayName("Add null")
    @Test
    void testAddBookNull() {
        BookRentalSystem.add(null);

        // Assert: Verify that the size has not increased
        assertEquals(0, BookRentalSystem.getLibrarySize(),
        "Adding a null item should not increase the library size.");
    }
}
