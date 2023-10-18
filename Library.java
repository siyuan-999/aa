import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    String Address;

    private Library(String LibraryAddress){
        Address = LibraryAddress;



    }
   public static class Book{
        String title;
        boolean borrowed;
        private void borrowed(){
            borrowed = false;
        }
        public Book(String book){
            title = book;
        }
    }
    ArrayList<Book> books = new ArrayList<>();





    private void addBook(Book book){

        books.add(book);
    }


    public static void printOpeningHours (){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }
     public void printAddress(){
        System.out.println(Address);
    }
    public void borrowBook(String bookname) {
        int i , j = 0;
        for (i = 0; i < books.size(); i++) {
            if (bookname.equals(books.get(i).title)) {
                j++;
                break;
            }

        }
        if (j == books.size()) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else {
            if (!books.get(i).borrowed) {
                System.out.println("You successfully borrowed : " + books.get(i).title);
                books.get(i).borrowed = true;
            } else {
                System.out.println("Sorry, this book is already borrowed.");
            }
        }

    }


    public void printAvailableBooks(){
        int i, j = 0;
        for (i = 0 ; i < books.size();i++) {
            if (!books.get(i).borrowed) {
                System.out.println(books.get(i).title);
                j++;
            }
        }
        if (j == books.size() ){
            System.out.println("No book in catalog");
        }

    }
    public boolean returnBook(String bookname){
        int i;
         for(i = 0 ; i <books.size();i++){
             if (bookname.equals(books.get(i).title)) {
                 System.out.println("You successfully returned : " + bookname);
                 books.get(i).borrowed = false;
                 return books.get(i).borrowed;
             }
         }
         return books.get(i).borrowed;
    }




    public static void main(String[] args) {
// Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
// Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
// Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
// Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
// Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
// Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
// Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();







    }


}