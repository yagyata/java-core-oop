import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration(); // Different items have different loan periods

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private static final int LOAN_PERIOD = 14; // Books can be borrowed for 14 days

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_PERIOD;
    }

    @Override
    public void reserveItem() {
        System.out.println("Book '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem {
    private static final int LOAN_PERIOD = 7;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_PERIOD;
    }
}

class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_PERIOD = 5;
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_PERIOD;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B865", "The Great Gatsby", "F. Scott Fitzgerald"));
        items.add(new Magazine("M462", "Time Magazine", "Various Authors"));
        items.add(new DVD("D211", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println();
        }

        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println();
            }
        }
    }
}
