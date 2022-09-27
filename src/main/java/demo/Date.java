package demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class Date {
  public static void main(String[] args) {  
    LocalDateTime myDateObj = LocalDateTime.now();  
    System.out.println("Before formatting: " + myDateObj);  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    
    String formattedDate = myDateObj.format(myFormatObj);  
    System.out.println("After formatting: " + formattedDate);  
    
//	String date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.SSS").format(new Date());
	File json = new File("var/json/oahcs/"+ formattedDate +"-HealthInformation.json");
//	PrintWriter out = new PrintWriter(new FileWriter(json, true));

	System.out.println(json.getAbsolutePath());
  }  
}  