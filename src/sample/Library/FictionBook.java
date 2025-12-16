package sample.Library;

public class FictionBook extends Book {
    /**
     *
     * @param title
     * @param author
     * @param yearPublish
     */
    public FictionBook(final String title,
            final String author, final int yearPublish) {
        super(title, author, yearPublish);
//        this.getInfo();
//        System.out.println("New Fiction Book Added: "
//                + "Title: " + title
//                + " Author: " + author
//                + "Year published: " + yearPublish);
    }
}
