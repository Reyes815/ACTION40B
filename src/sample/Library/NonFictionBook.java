package sample.Library;

public class NonFictionBook extends Book {
    /**
     *
     * @param title
     * @param author
     * @param yearPublish
     */
    NonFictionBook(final String title,
            final String author, final int yearPublish) {
        super(title, author, yearPublish);
//        this.getInfo();
//        System.out.println("New Non-Fiction Book Added: "
//                + "Title: " + title
//                + " Author: " + author
//                + "Year published: " + yearPublish);
    }
}
