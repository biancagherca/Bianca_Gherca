package ro.sci.week_07;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private Long cnp;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private char gender;


    public Student(Long cnp, String firstName, String lastName, String dateOfBirth, char gender) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Student{" +
                "cnp=" + cnp +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }

    public Long getCnp() {
        return cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public int calculateAge(String birthDate, LocalDate currentDate) {
            if ((birthDate != null) && (currentDate != null)) {
                return Period.between(LocalDate.parse(birthDate), currentDate).getYears();
            } else {
                throw new IllegalArgumentException("age is not a number");
            }
        }
    }


