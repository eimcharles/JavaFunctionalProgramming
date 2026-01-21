package com.eimc.streams.exerciseFour;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Gender gender;

    public Person(String firstName, String lastName, String email, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    String getEmail() {
        return email;
    }

    int getAge() {
        return age;
    }

    Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, age, gender);
    }

    @Override
    public String toString() {
        return "Person { firstName = '%s', lastName = '%s', email = '%s', age = %d, gender = %s}"
                .formatted(firstName, lastName, email, age, gender);
    }

}
