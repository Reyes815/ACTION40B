package sample.Library;

public class Book {
    /**
     * @field title of the book
     */
    private String title;
    /**
     * @field author of the book
     */
    private String author;
    /**
     * @field year the book was published
     */
    private int yearPublished;
    /**
     * @field isRented checks if books are rented out or not
     */
    private boolean isRented;
    /**
     * @method returns the private title field
     * @return returns title field
     */
    public String getTitle() {
        return title;
    }
    /**
     * @method setTitle sets the title of the book
     * @param newTitle takes in title of the new book
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }
    /**
     * @method getAuthoer returns the author of the book
     * @return returns author field
     */
    public String getAuthor() {
        return author;
    }
    /**
     * @method setAuthor sets the author of the book
     * @param newAuthor takes in author string
     */
    public void setAuthor(final String newAuthor) {
        this.author = newAuthor;
    }
    /**
     * @method getYearPublished returns the yearPublished field
     * @return yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }
    /**
     * @method setYearPublished sets the year published for the book
     * @param newYearPublished takes in a year integer
     */
    public void setYearPublished(final int newYearPublished) {
        this.yearPublished = newYearPublished;
    }
    /**
     * @method isRented checks book availability
     * @return returns boolean value
     */
    public boolean isRented() {
        return isRented;
    }
    /**
     * @method setRented sets the availability of the book
     * @param newIsRented takes in boolean value for the book
     */
    public void setRented(final boolean newIsRented) {
        this.isRented = newIsRented;
    }
    /**
     *
     * @param newTitle
     * @param newAuthor
     * @param newYearPublish
     */
    public Book(final String newTitle,
            final String newAuthor, final int newYearPublish) {
        this.setTitle(newTitle);
        this.setAuthor(newAuthor);
        this.setYearPublished(newYearPublish);
        this.setRented(false);
    }
    /**
     * @method rent sets book availability to true
     */
    public void rent() {
        setRented(true);
        //System.out.println(this.title + " is currently being rented");
    }
    /**
     * prints out book information.
     */
    public void getInfo() {
        System.out.print(this.title + " "
    + this.author + " " + this.yearPublished);
    }
}
