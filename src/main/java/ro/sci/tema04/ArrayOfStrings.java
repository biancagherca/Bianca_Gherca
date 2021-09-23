package ro.sci.tema04;

public class ArrayOfStrings {
    public static void main(String[] args) {
        String[] arrayOfStrings = {"Hello", ",", "my", "name", "is", "Bianca", "Gherca"};
        String concatanatedString = "";
        for (String arrayOfString : arrayOfStrings) {
            concatanatedString = concatanatedString + arrayOfString + " ";
        }
        System.out.println(concatanatedString);
    }
}
