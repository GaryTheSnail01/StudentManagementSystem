package Classes;

import Utils.SystemUtils;

public class Person {
    private String name;
    private int age;
    private String email;


    public Person(String name, int age, String email) {
        if (name == null || name.trim().isEmpty()) { // Checking to see if name is empty or if it contains only spaces
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.name = name.trim(); // Removing any leading or trailing spaces
        this.age = age;
        this.email = email.trim();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName() {
        name = SystemUtils.readNonEmptyString("Enter name: ");
    }

    public void setAge() {
        age = SystemUtils.readPositiveInt("Enter age: ");
    }

    public void setEmail() {
        this.email = SystemUtils.readEmailString("Enter email: ");
    }
}
