package io.github.randatic.collegeapp.Model;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public class Sibling extends FamilyMember {

    private int age;

    public Sibling () {
        super("Barbara", "Fisher");
        age = 10;
    }

    public Sibling (String firstName, String lastName, int age) {
        super(firstName, lastName);
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + Integer.toString(age);
    }

    //Getters & Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
