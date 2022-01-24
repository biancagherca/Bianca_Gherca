package ro.sci.week_09.streams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MainWeekJava8Streams {
    public static List<Person> persons = new ArrayList<>();
    public static List<Person> sortedListByMonth = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        csvReadPersons();
        System.out.println("Please enter a number between 1-12 to sort the list by month");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        Comparator<Person> sortByFirstName = Comparator.comparing((Person::getFirstName));
        Comparator<Person> sortByLastName = Comparator.comparing((Person::getLastName));
        sortedListByMonth = persons.stream()
                .filter(person -> returnPersonByMonth(person, month) != null)
                .sorted(sortByFirstName.thenComparing(sortByLastName))
                .collect(Collectors.toList());
        writeToCsv();
    }

    private static void csvReadPersons() {
        Path fileIn = new File("C:/Users/Bianca/Desktop/curs JAVA/git/Bianca_Gherca/src/main/resources/PersonsIn.csv").toPath();
        try (BufferedReader reader = Files.newBufferedReader(fileIn, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                persons.add(getPersonFromCsvLine(line));
            }
        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }

    }

    public static Person getPersonFromCsvLine(String line) {

        String[] tokens = line.split(",");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Corrupted data");
        }
        return new Person(tokens[0].trim(), tokens[1].trim(), tokens[2].trim());

    }

    private static Person returnPersonByMonth(Person person, int filter) {
        String[] dateOfBirth = person.getDateOfBirth().split("/");
        int month = Integer.parseInt(dateOfBirth[1].trim());
        if (month == filter) {
            return new Person(person.getFirstName(), person.getLastName());
        }
        return null;
    }

    public static void writeToCsv() {
        File csvOutputFile = new File("C:/Users/Bianca/Desktop/curs JAVA/git/Bianca_Gherca/src/main/resources/PersonsOut.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            sortedListByMonth.forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

