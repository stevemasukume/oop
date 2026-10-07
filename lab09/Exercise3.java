/*
 * Question from the lab manual:
 * Intermediate: Add equals/hashCode to a Book class by ISBN and prove a HashSet rejects duplicates.
 */
package lab09;
import java.util.*;
public class Exercise3 {
    static class Book{final String isbn,title;Book(String i,String t){isbn=i;title=t;}public boolean equals(Object o){return o instanceof Book b&&isbn.equals(b.isbn);}public int hashCode(){return isbn.hashCode();}}
    // Explanation: Book equality is based on ISBN, so HashSet treats books with the same ISBN as duplicates.
    public static void main(String[] args){Set<Book> books=new HashSet<>(List.of(new Book("1","Java"),new Book("1","Duplicate")));System.out.println("Unique books: "+books.size());}
}

