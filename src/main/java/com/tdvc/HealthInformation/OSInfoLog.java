/**
 * 
 */
package com.tdvc.HealthInformation;

import static com.tdvc.HealthInformation.OSInfoUtils.bytesToHumanReadableValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;				


/**
 * @author Gianluca Tanasi
 * 
 * Logger Class created to get the OS-Information in different levels
 * using Log4j2 and getting logs as a .log file and as a console's output as well 
 *
 */
public class OSInfoLog
{	
	static OSInfoMethods osim = new OSInfoMethods();	
	
//	static Logger logger = LogManager.getLogger(OSLog.class);
	static Logger logger = LoggerFactory.getLogger(OSInfoLog.class);
	
	static String dname, dtype, dfsstr, cpusstr, cpupstr, ramstr;

	public OSInfoLog()
	{	 
		diskLog();
		ramLog();
		cpuLog();
	}

	
	//----Free Drive Space----//
	/** Calls the classes File in lists and FileSystemView
	 *  to get the disk free space usage converted in byte's unit and percentage 
	 *  in list of roots with a description of it.
	 *  
	 *  If the free space is under 5% it will output a warn log.
	 *  If it's under 50% it will output a an info log.
	 *  If over 50% it will output a debug log.
	 *  If there is an error querying space it will output an error log.
	 */
	static void diskLog()
	{
		File [] drives = File.listRoots();								
		FileSystemView fileType= FileSystemView.getFileSystemView();				

		if (drives.length > 0 && drives != null){

			for (File drive : drives) 
			{
				dname = fileType.getSystemDisplayName(drive);
				dtype = fileType.getSystemTypeDescription(drive);
				String dfsb = bytesToHumanReadableValue(drive.getFreeSpace());
				double dfsp = (double)drive.getFreeSpace() / drive.getTotalSpace() * 100;
				dfsstr = String.format("%s (%.0f%%)", dfsb, dfsp);

				String dlog = dname + " (" + dtype + ") Free disk space: " + dfsstr;

				try 
				{
					if(dfsp < 5)																
					{
						logger.warn(dlog);
					}
					else if(dfsp < 50)														
					{

						logger.info(dlog);
					}
					else
					{
						logger.debug(dlog);
					}
				}
				catch (Exception e)
				{
					logger.error("error querying space: " + e.toString());
				}
			}
		}
	}

	
	//----CPU-Usage----//
	/** Calls the class OSInfoMethods to get the CPU usage (System and Process)
	 *  converted in byte's unit and percentage.
	 *  
	 *  If the CPU system usage is over 90% it will output a warn log.
	 *  If over 40% it will output a an info log.
	 *  If under 40% it will output a debug log.
	 *  If there is an error querying space it will output an error log.
	 */
	static void cpuLog()
	{
		double cpus = osim.getCpuSystemLoadPercent();	
		double cpup = osim.getCpuProcessLoadPercent();
		cpusstr = String.format("%.1f%%", cpus);
		cpupstr = String.format("%.1f%%", cpup);

		String clog = "CPU Load (System/Process): " + cpusstr + " | " + cpupstr;

		try 
		{
			if(cpus > 90)																
			{
				logger.warn(clog);
			}
			else if(cpus > 40)													
			{
				logger.info(clog);
			}
			else
			{
				logger.debug(clog);											
			}
		}
		catch (Exception e) 
		{
			logger.error("error querying space: " + e.toString());
		}
	}

	//----RAM-Usage----//
	/** Calls the class OSInfoMethods to get the RAM used space usage
	 *  converted in byte's unit and percentage.
	 *  
	 *  If the RAM used space usage is over 95% it will output a warn log.
	 *  If over 50% it will output a an info log.
	 *  If under 50% it will output a debug log.
	 *  If there is an error querying space it will output an error log.
	 */
	static void ramLog()
	{
		String ramb = bytesToHumanReadableValue(osim.getRamUsedMemory());
		double ramp = osim.getRamUsedMemoryPercent();
		ramstr = String.format("%s (%.0f%%)", ramb, ramp);

		String rlog = "Used RAM space: " + ramstr;

		try 
		{
			if(ramp > 95)
			{
				logger.warn(rlog);															
			}
			else if(ramp > 50)
			{
				logger.info(rlog);															
			}
			else
			{
				logger.debug(rlog);														
			}
		}
		catch (Exception e) 
		{
			logger.error("error querying space: " + e.toString());							
		}
	}

	/**
	 * The serialize method creates a class DiskInfo as an ArrayList
	 * and adds the informations of each drive in Lists. Creates CPU and RAM class as objects
	 * and adds the values of log methods in parameters. Create OSSerialize class as object 
	 * and adds the values of disk, CPU and RAM in parameters.
	 * 
	 * Creates HealthInformation object and serialize the OSInfoSerialize object to Json
     * and creates a JSON file out of it.
	 */
//	void serialize() {
//		
//		String osname = osim.getSystemName();
//		
//		List<DiskInfo> disk = new ArrayList<>();
//		disk.add(new DiskInfo(dname, dtype, dfsstr)); 
//		
//		CPUInfo	cpu = new CPUInfo(cpupstr, cpusstr);
//		
//		RAMInfo ram = new RAMInfo(ramstr);
//		
//		OSInfoSerialize osi = new OSInfoSerialize(osname, disk, cpu, ram);
//		
//		String HealthInformation = new Gson().toJson(osi);
//
////		System.out.println(HealthInformation);
//
//		FileWriter fw;
//		try {
//			fw = new FileWriter("var/json/oahcs/HealthInformation.json");
//			fw.write(HealthInformation);
//			fw.close();
////			System.out.println("JSON written");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
