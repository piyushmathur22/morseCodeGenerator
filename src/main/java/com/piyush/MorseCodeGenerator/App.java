package com.piyush.MorseCodeGenerator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{	
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws ParseException, FileNotFoundException, IOException
    {
        System.out.println( "Hello World!" );
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.nextLine();
        
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(new FileReader("C:\\Softwares\\ProjectFolder\\project\\MorseCodeGenerator\\src\\main\\resources\\com\\piyush\\MorseCodeGenerator\\morse-code.json"));

        System.out.printf("Morse code for the message is : ");
        
        userName.chars()
        .mapToObj(c -> (char) c)
        .forEach(c -> {
            Object value = json.get(Character.toString(c));
            System.out.print(value);
        });
    }
}
