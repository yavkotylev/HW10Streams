package streams;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class OldPerson {
    private final static int MINIMUM_PENSION = 8902;
    private final int pension;
    private final int age;
    private final String name;

    public OldPerson(int pension, int age, String name) {
        this.pension = pension;
        this.age = age;
        this.name = name;
    }

    public OldPerson(Person person) {
        this.pension = MINIMUM_PENSION;
        this.age = person.getAge();
        this.name = person.getName();
    }

    public int getPension() {
        return pension;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static int getMinimumPension() {
        return MINIMUM_PENSION;
    }
}
