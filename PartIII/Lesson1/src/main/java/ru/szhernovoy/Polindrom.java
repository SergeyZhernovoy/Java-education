package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 17.07.2016.
 */
public class Polindrom {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Polindrom pol = new Polindrom();
        boolean result = false;
        do {
            System.out.print("\nPlease , enter string polindrom (example KOMOK): ");
            try {
                result = pol.polindromTest(pol.getPolindrom(br.readLine()));
                if (result) {
                    System.out.println("This is a polindrom");
                }
                else{
                    System.out.println("This is not a polindrom");
                }

            } catch (StringLengthException exc) {
                System.out.println(exc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!result);
    }

    public String getPolindrom(String testString) throws StringLengthException {
        if (testString.length() != 5) {
            throw new StringLengthException(testString);
        }
        return testString;
    }

    public boolean polindromTest(String testString) {

        boolean result = false;
        char[] array = testString.toLowerCase().toCharArray();
        if (array[0] == array[4] && array[1] == array[3]) {
            result = true;
        }
        return result;
    }
}
