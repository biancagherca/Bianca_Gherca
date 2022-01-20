package ro.sci.week_09.IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MainWeek09IO {

    static List<Athlete> athletes = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        csvAthletes();
        System.out.println("Final results:");
        Comparator<Athlete> athleteComparator = Comparator.comparing((Athlete::getSkiTime));
        athletes.sort(athleteComparator);
        for (Athlete athleteSorted : athletes) {
            System.out.println( athleteSorted.getAthleteName() + " " + athleteSorted.getSkiTime());
        }


    }

    private static void csvAthletes() {
        Athlete athlete;
        Athlete updatedAthlete;
        Path fileIn = new File("C:/Users/Bianca/Desktop/curs JAVA/git/Bianca_Gherca/src/main/resources/athletes.csv").toPath().toAbsolutePath();
        try (BufferedReader reader = Files.newBufferedReader(fileIn, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                athlete = getAthleteFromCsvLine(line);
                updatedAthlete = athleteAfterPenalties(athlete);
                athletes.add(updatedAthlete);
            }

        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }
        System.out.println(athletes.size() + " athletes");

    }


    public static Athlete athleteAfterPenalties(Athlete athlete) {
        String s = String.format("%s,%s,%s", athlete.getFirstShootingRange(), athlete.getSecondShootingRange(), athlete.getThirdShootingRange());
        String[] time = athlete.getSkiTime().split(":");
        int min = Integer.parseInt(time[0].trim());
        int sec = Integer.parseInt(time[1].trim());
        long count = containsCharO(s);
        for (int i = 0; i <count; i++) {
            if (count >= 6) {
                min++;
            } else if (sec >=50) {
                min++;
                sec = 50 - sec;
            } else   {
                sec = sec + 10;
            }

        }

        String newSkiTime = String.format("%s:%s", min, sec);
        return new Athlete(athlete.getAthleteNumber(), athlete.getAthleteName(), athlete.getCountryCode(), newSkiTime, athlete.getFirstShootingRange(), athlete.getSecondShootingRange(), athlete.getThirdShootingRange());
    }

    public static long containsCharO(String shootingRange) {
        char searchFor = 'o';
        return shootingRange.chars().filter(c -> c == searchFor).count();
    }

    public static Athlete getAthleteFromCsvLine(String line) {
        String[] tokens = line.split(",");
        if (tokens.length != 7) {
            throw new IllegalArgumentException();
        }
        int athleteNumber = Integer.parseInt(tokens[0].trim());
        return new Athlete(athleteNumber, tokens[1],
                tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
    }

}
