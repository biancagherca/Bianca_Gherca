package week_09;

import org.junit.Assert;
import org.junit.Test;
import ro.sci.week_09.IO.Athlete;
import ro.sci.week_09.IO.MainWeek09IO;

public class MainWeek09_IO_Test {
    //MainWeek09IO main = new MainWeek09IO();
    @Test
    public void testCsvInput(){
        //given
        String inputLine = "5,Jakov Fak,SLO,30:,xxxxx,xxxox,xxoxx";
        //when
        Athlete result= MainWeek09IO.getAthleteFromCsvLine(inputLine);
        //then
        Assert.assertEquals(5,result.getAthleteNumber());
        Assert.assertEquals("30:40", result.getSkiTime());

    }
    @Test
    public void testAthletesUpdate(){
        //given
        Athlete  athlete = new Athlete(4, "Lukas Hofer", "ITA", "29:50", "xxoxx","oxxxx","oxxxx");
        //when
        Athlete result=MainWeek09IO.athleteAfterPenalties(athlete);
        //then
        Assert.assertEquals("30:20",result.getSkiTime());
    }

}
