package ro.sci.week_07;

import ro.sci.week_07.Exceptions.AddStudentToList;
import ro.sci.week_07.Exceptions.AgeException;
import ro.sci.week_07.Exceptions.DeleteStudentFromList;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWeek07 {

    static List<Student> students =new ArrayList<>();
    static StudentsRepository studentsRepository = new StudentsRepository();
    public static void main(String[] args) throws AddStudentToList, DeleteStudentFromList, AgeException {

        Student student1 ;
        Student student2;
        Student student3;
        Student student4;
        Student student5;
        Student student6;
        Student student7;
        //Add students
        student1= studentsRepository.addStudent(1991103016245L, "George", "Popescu", "1999-11-03", 'M');
        student2=studentsRepository.addStudent(1971203016245L,"Marius", "Pop", "1997-12-03", 'M');
        student3=studentsRepository.addStudent(2951007016245L,"Elena", "George", "1995-10-07", 'f');
        student4=studentsRepository.addStudent(2961208016245L,"Ioana", "Nitu", "1996-12-08", 'F');
        student5=studentsRepository.addStudent(2000608016245L,"Crina", "Baciu", "2000-06-08", 'F');
        student7=studentsRepository.addStudent(2000609016245L,"Elena", "Baciu", "2000-06-09", 'F');
        //throws exception
        //    student6=studentsRepository.addStudent(1975264853125L,null,"Maria","1997-25-06",'f');
        System.out.println(studentsRepository.getStudents() );

     //Delete students
       StudentsRepository.deleteStudent(1991103016245L, "Popescu", "George", "1999-11-03", 'M');

     //Retrieve students
        System.out.println("Retrieve all students with age: ");
        Scanner scanner=new Scanner(System.in);
        int age=scanner.nextInt();
        System.out.println(studentsRepository.retrieveStudent(age).toString());

        //list students

        studentsRepository.listAllStudentsByLastName();

    }
}
