package com.piyush.MorseCodeGenerator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!! 
 */
public class App {
	public static String projectPath = "C:\\Personal\\Project\\morseCodeGenerator\\";
	
//	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
//		mainMethod();
//	}

	public static void mainMethod() throws FileNotFoundException, IOException, ParseException{
		String message = getMessageFromUser();
		JSONObject json = readMorseJson();
		processMessage(message, json);
	}
	
	public static void methodConverter() throws FileNotFoundException, IOException, ParseException{
		String message = getMessageFromUser();
		JSONObject json = readMorseJson();
		processMessage(message, json);
	}

	private static JSONObject readMorseJson() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(
				new FileReader(projectPath + "src\\main\\resources\\com\\piyush\\MorseCodeResource\\morse-code.json"));
		return json;
	}

	@SuppressWarnings("resource")
	private static String getMessageFromUser() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter message");
		String message = myObj.nextLine();
		return message;
	}

	private static void processMessage(String message, JSONObject json) {
		System.out.printf("Morse code for the message is : ");
		message.chars().mapToObj(c -> (char) c).forEach(c -> {
			convertToMorseAndPrint(json, Character.toLowerCase(c));
		});
	}

	private static void convertToMorseAndPrint(JSONObject json, Character c) {
		Object value;
		if (Character.isSpaceChar(c)) {
			value = "  ";
		} else {
			value = (json.get(Character.toString(c))) + " ";
		}
		System.out.print(value);
	}
}
