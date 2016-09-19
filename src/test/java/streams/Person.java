package streams;

/**
 * Created by Yaroslav on 19.09.16.
 */
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person person) {
        this.age = person.getAge();
        this.name = person.getName();
    }

    public Person(String name) {
        age = 18;
        this.name = name;
    }

    public Person(int age) {
        name = "default";
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInformation(){
        return "name = " + name + "  age = " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())){
            Person person = (Person)obj;
            return (name.equals(person.getName()) && (age == person.getAge()));
        }
        return false;
    }
}
