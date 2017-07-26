package future.fry.practice.random;

/**
 *
 * @author ranjeet
 */
public class SwapObj {

    public static void main(String[] args) {

        Person p1 = new Person("Ranjeet");
        Person p2 = new Person("Pruthivi");

        swap(p1, p2);

        System.out.println("Ranjeet :" + p1.name);
        System.out.println("Pruthivi :" + p2.name);
    }

    private static void swap(Person p1, Person p2) {
        Person tmp = p1;
        p1 = p2;
        p2 = tmp;
    }

    private static class Person {

        String name;

        public Person(String name) {
            this.name = name;
        }

    }
}
