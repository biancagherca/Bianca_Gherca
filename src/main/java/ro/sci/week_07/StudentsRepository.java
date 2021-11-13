package ro.sci.week_07;

import ro.sci.week_07.Exceptions.AddStudentToList;
import ro.sci.week_07.Exceptions.AgeException;
import ro.sci.week_07.Exceptions.DeleteStudentFromList;
import ro.sci.week_07.Exceptions.InputIsEmpty;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsRepository {


    static List<Student> students = new ArrayList<>();

    public Student addStudent(Long id, String firstName, String lastName, String dateOfBirth, char gender) throws AddStudentToList {

        if (firstName == null) {
            throw new AddStudentToList(" First name is empty");
        }
        if (lastName == null) {
            throw new AddStudentToList("Last name is empty");
        }
        if (dateOfBirth.isEmpty()) {
            throw new AddStudentToList("Date of birth is empty");
        }
        if (gender != 'f' && gender != 'F' && gender != 'M' && gender != 'm') {
            throw new AddStudentToList("Gender should be M or F");
        }

        Student newStudent = new Student(id, firstName, lastName, dateOfBirth, gender);
        students.add(newStudent);
        return newStudent;

    }

    public static void deleteStudent(Long id, String firstName, String lastName, String dateOfBirth, char gender) throws DeleteStudentFromList {
        Student student = new Student(id, firstName, lastName, dateOfBirth, gender);
        if (id == null) {
            throw new DeleteStudentFromList("Student does not exist");
        }
        students.remove(student);
        System.out.println("Student removed");
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> retrieveStudent(int age) throws AgeException {
        List<Student> studentWithAgeX = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateAge(student.getDateOfBirth(), LocalDate.now()) == age) {

                studentWithAgeX.add(student);
            } else if (age < 0) {
                throw new AgeException("Age is negative");
            }
        }
        return studentWithAgeX;
    }
    public void listAllStudentsByLastName(){
        System.out.println("Students repository sorted by last name");

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2){
                return student1.getLastName().compareTo(student2.getLastName());
            }
        });
        students.forEach(System.out::println);
    }



}