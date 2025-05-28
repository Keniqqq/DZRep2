import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private Integer age; // Может быть null
    private String address; // Может быть null

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(surname);
        if (hasAge()) sb.append(", возраст: ").append(age);
        if (hasAddress()) sb.append(", город: ").append(address);
        return sb.toString();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        if (this.hasAge()) {
            builder.setAge(0);
        }
        if (this.hasAddress()) {
            builder.setAddress(this.address);
        }
        return builder;
    }
}