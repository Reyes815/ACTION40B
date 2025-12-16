package sample.Library;
import java.util.ArrayList;

public final class BookRentalSystem {
    private BookRentalSystem() {
        super();
    }
    /**
     *
     */
    private static ArrayList<Book> library = new ArrayList<>();
    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        final int year1954 = 1954;
        final int year1960 = 1960;
        final int year2000 = 2000;
        final int year1997 = 1997;
        ArrayList<Book> newBooks = new ArrayList<>();
        newBooks.add(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", year1954));
        newBooks.add(new FictionBook("To Kill a Mockingbird",
                "Harper Lee", year1960));
        newBooks.add(new NonFictionBook("The Tipping Point",
                "M. Gladwell", year2000));
        newBooks.add(new NonFictionBook("Guns, Germs,"
                + " and Steel", "Jared Diamond ", year1997));
        addBooks(newBooks);

        ArrayList<Book> rentBooks = new ArrayList<>();
        rentBooks.add(library.get(0));
        rentBooks.add(library.get(1));
        rentBooks(rentBooks);
        displayBooks();
        displayRentedBooks();
        newBooks.add(null);
        ArrayList<Book> newList = getLibrary();
        int size = getLibrarySize();
        clearLibrary();

    }
    /**
     *
     * @param book adds new book using public method
     */
    public static void add(final Book book) {
        if (book != null) {
            library.add(book);
        }
    }
    /**
     * public method for getting specific book.
     * @param index to find book
     * @return book object
     */
    public static Book get(final int index) {
        return library.get(index);
    }
    /**
     *
     * @param newBooks
     */
    public static void addBooks(final ArrayList<Book> newBooks) {
        // TODO Auto-generated method stub
        for (Book book : newBooks) {
            library.add(book);
        }
    }
    /**
     *
     * @param rentedBooks
     */
    public static void rentBooks(final ArrayList<Book> rentedBooks) {
        System.out.println("Books Rented:");
        for (Book book : rentedBooks) {
            if (book.isRented()) {
                continue;
            }
            book.getInfo();
            book.rent();
        }
    }
    /**
     *
     */
    public static void clearLibrary() {
        library.clear();
    }
    /**
     *
     * @return library.size()
     */
    public static int getLibrarySize() {
        return library.size();
    }
    /**
    *
    * @return library
    */
   public static ArrayList<Book> getLibrary() {
       return library;
   }
    /**
     * display rented books.
     */
    public static void displayRentedBooks() {
        for (Book book : getLibrary()) {
            if (book.isRented()) {
                book.getInfo();
            }
        }
    }
    /**
     * display books.
     */
    public static void displayBooks() {
        for (Book book : getLibrary()) {
            book.getInfo();
        }
    }

}
