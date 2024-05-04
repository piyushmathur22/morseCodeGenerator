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
public class App {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter message");
		String message = myObj.nextLine();

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(new FileReader(
				"C:\\Softwares\\ProjectFolder\\project\\MorseCodeGenerator\\src\\main\\resources\\com\\piyush\\MorseCodeGenerator\\morse-code.json"));

		System.out.printf("Morse code for the message is : ");

		extracted(message, json);
	}

	private static void extracted(String message, JSONObject json) {
		message.chars().mapToObj(c -> (char) c).forEach(c -> {
			Object value;
			if (Character.isSpaceChar(c)) {
				value = " ";
			} else {
				value = json.get(Character.toString(c));
			}
			System.out.print(value);
			System.out.print(" ");
		});
	}
}