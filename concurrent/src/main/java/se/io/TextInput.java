package se.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextInput {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
