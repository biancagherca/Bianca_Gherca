package ro.sci.week_09.streams;

import org.junit.Assert;
import org.junit.Test;
import ro.sci.week_09.IO.Athlete;
import ro.sci.week_09.IO.MainWeek09IO;

import static org.junit.Assert.*;

public class MainWeekJava8StreamsTest {
    @Test
    public void testCsvInput(){
        //given
        String inputLine = "Ivanov, Dan, 25/03/1956";
        //when
        Person result= MainWeekJava8Streams.getPersonFromCsvLine(inputLine);
        //then
        Assert.assertEquals("25/03/1956",result.getDateOfBirth());
        Assert.assertEquals("Ivanov", result.getFirstName());

    }

}