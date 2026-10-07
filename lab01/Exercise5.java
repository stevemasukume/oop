/*
 * Question from the lab manual:
 * Challenge: Create Address and Person classes where a Person has an Address. Print a person city using a chained dot expression, and show what happens when the address is null.
 */
package lab01;

public class Exercise5 {
    record Address(String city) {}
    record Person(String name, Address address) {}

    // Explanation: The chained expression follows Person to Address; the null case is handled explicitly to avoid an unchecked crash.
    public static void main(String[] args) {
        Person person = new Person("Rudo", new Address("Harare"));
        System.out.println(person.name() + " lives in " + person.address().city());
        Person withoutAddress = new Person("Farai", null);
        try {
            System.out.println(withoutAddress.address().city());
        } catch (NullPointerException e) {
            System.out.println("Cannot read a city from a null address.");
        }
    }
}

