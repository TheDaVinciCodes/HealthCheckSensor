package com.tdvc.HealthInformation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

/**
 * The OSToJson class creates an ArrayList DiskInfo
 * and adds the informations of each drive in Lists. Creates CPU and RAM class as objects
 * and adds the values of log methods in parameters. Create OSSerialize class as object 
 * and adds the values of disk, CPU and RAM in parameters.
 * 
 * Creates HealthInformation object and serialize the OSInfoSerialize object to Json
 * and creates a JSON file out of it.
 */
public class OSInfoToJson {

	OSInfoToJson()
	{
		OSInfoMethods osim = new OSInfoMethods();
		
		LocalDateTime dateNow = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateNow.format(dateFormat);
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		String formattedTime = dateNow.format(timeFormat);
//		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
//		String formattedDateTime = dateNow.format(dateTimeFormat);

		String osname = osim.getSystemName();

		List<DiskInfo> disk = new ArrayList<>();
		disk.add(new DiskInfo(OSInfoLog.dname, OSInfoLog.dtype, OSInfoLog.dfsstr)); 

		CPUInfo	cpu = new CPUInfo(OSInfoLog.cpupstr, OSInfoLog.cpusstr);

		RAMInfo ram = new RAMInfo(OSInfoLog.ramstr);

		OSInfoSerialize osi = new OSInfoSerialize(formattedDate, formattedTime, osname, disk, cpu, ram);

		String HealthInformation = new Gson().toJson(osi);

		//		System.out.println(HealthInformation);

//		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
//		String date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.SSS").format(new Date());
//		File json = new File("var/json/oahcs/"+ date +"-HealthInformation.json");

		String dir = "var/json/oahcs/" + formattedDate + "/";
		String name = "HealthInformation";
//		String name = formattedDateTime + "-HealthInformation";

		File json = new File(dir + name + ".json");
//		File json = new File("var/json/oahcs/" + formattedDate + "/HealthInformation.json");
		json.isFile();
		
		try {
			if(!json.exists()) {
		        json.getParentFile().mkdirs();
				System.out.println("We had to make a new file.");	
		    }
			
			BufferedWriter out = new BufferedWriter(new FileWriter(json));
			out.write(HealthInformation);
			out.close();
			System.out.println("JSON written --> " + json.getAbsolutePath());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("JSON not written");
			e1.printStackTrace();
		}


//		File json = new File("var/json/oahcs/" + formattedDate + "/HealthInformation.json");
//		FileWriter fw;
//		try {
//			if(json.exists()==false){
//				System.out.println("We had to make a new file.");
//				json.createNewFile();
//			}
//			fw = new FileWriter(json, true);
//			fw.write(HealthInformation);
//			fw.close();
//			System.out.println("JSON written");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("JSON not written");
//			e.printStackTrace();
//		}
	}

}
