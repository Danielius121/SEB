package sample;

import java.io.*;
import java.util.Scanner;

public class Main {
    static ValidateIBAN validateIBAN;

    private static String FilePath;
    private static String FileLine;
    private static Scanner S = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("1 - Duomenu ivedimas rankiniu budu \n2 - Duomenu nuskaitymas is failo");
        String userChoice = S.nextLine();
        if(Integer.parseInt(userChoice)==1) manuallyType();
        else readAndWrite();

    }
    private static void manuallyType()
    {
        while (true) {
            System.out.println("Iveskite banko saskaita:");
            System.out.println(validateIBAN.checkIBAN(readLine()));
        }
    }
    private static void readAndWrite() throws IOException {
        System.out.println("Iveskite duomenu failo kelia");
        FilePath = S.nextLine();
        File fileToRead = new File(FilePath);
        BufferedReader br = new BufferedReader(new FileReader(fileToRead));
        FileWriter myWriter = new FileWriter(getCorrectFileNameExtension());
        while ((FileLine = br.readLine()) != null) {
            myWriter.write(getString());

        }
        br.close();
        myWriter.close();
    }

    private static String getCorrectFileNameExtension()
    {
        return FilePath.substring(0, FilePath.lastIndexOf('.')) + ".out";
    }
    private static String getString()
    {
        return FileLine + ";" + validateIBAN.checkIBAN(FileLine) + "\n" ;
    }

    private static String readLine()
    {
        String IBAN;
        Scanner S = new Scanner(System.in);
        IBAN = S.nextLine();
        IBAN.replace(" ", "");
        IBAN.toUpperCase();
        return IBAN;
    }
}