package com.tdvc.HealthInformation;

import static com.tdvc.HealthInformation.OSInfoUtils.bytesToHumanReadableValue;

import java.io.File;
import java.io.PrintStream;

import javax.swing.filechooser.FileSystemView;

public class OSInfoOut {

	static OSInfoMethods osim = new OSInfoMethods();

	static PrintStream o = System.out;

	public static void main(String[] args) 
	{
		infoOut();
		diskOut();
		ramOut();
		cpuOut();
		percentageOut();
		driveListOut();
	}

	static void infoOut()
	{
		o.println("-----------OS Info------------");
		o.println("Load Avarage:             " + osim.getSystemLoadAvarage());
		o.println("Name:               " + osim.getSystemName());
		o.println("Arch:                    " + osim.getSystemArch());
		o.println("Available Processors:        " + osim.getSystemAvailableProcessors());
		o.println("Version:                  " + osim.getSystemVersion());
	}

	static void diskOut()
	{
		o.println("\n----------Disk Usage----------");
		o.println(String.format("Tot Space:           %s", bytesToHumanReadableValue(osim.getDiskTotSpace())));
		o.println(String.format("Free Space:          %s", bytesToHumanReadableValue(osim.getDiskFreeSpace())));
		o.println(String.format("Usable Space:        %s", bytesToHumanReadableValue(osim.getDiskUsableSpace())));
		o.println(String.format("Used Space:          %s", bytesToHumanReadableValue(osim.getDiskUsedSpace())));
	}

	static void ramOut()
	{
		o.println("\n----------RAM Usage-----------");
		o.println(String.format("Tot Physical Space:    %s", bytesToHumanReadableValue(osim.getRamTotalMemory())));
		o.println(String.format("Free Physical Space:   %s", bytesToHumanReadableValue(osim.getRamFreeMemory())));
		o.println(String.format("Used Physical Space:   %s", bytesToHumanReadableValue(osim.getRamUsedMemory())));
		o.println(String.format("Tot Swap Space:        %s", bytesToHumanReadableValue(osim.getRamTotalSwapSpace())));
		o.println(String.format("Free Swap Space:       %s", bytesToHumanReadableValue(osim.getRamFreeSwapSpace())));
		o.println(String.format("Used Swap Space:       %s", bytesToHumanReadableValue(osim.getRamUsedSwapSpace())));
		o.println(String.format("Initial Memory:        %s", bytesToHumanReadableValue(osim.getRamInitialHeapMemory())));
		o.println(String.format("Used Heap Memory:      %s", bytesToHumanReadableValue(osim.getRamUsedHeapMemory())));
		o.println(String.format("Max Heap Memory:       %s", bytesToHumanReadableValue(osim.getRamMaxHeapMemory())));
		o.println(String.format("Committed Memory:      %s", bytesToHumanReadableValue(osim.getRamCommittedMemory())));
	}

	static void cpuOut()
	{
		o.println("\n----------CPU Usage-----------");
		o.println(String.format("Tot Memory:            %s", bytesToHumanReadableValue(osim.getCpuProcessTotMemory())));
		o.println(String.format("Free Memory:           %s", bytesToHumanReadableValue(osim.getCpuProcessFreeMemory())));
		o.println(String.format("Used Memory:           %s", bytesToHumanReadableValue(osim.getCpuProcessUsedMemory())));
		
	}

	static void percentageOut()
	{
		o.println("\n-----------Usage %------------");
		o.println(String.format("Free Disk Space:        %.2f%%", osim.getDiskFreeSpacePercent()));
		o.println(String.format("Used Disk Space:        %.2f%%", osim.getDiskUsedSpacePercent()));
		o.println(String.format("Free RAM Space:         %.2f%%", osim.getRamFreeMemoryPercent()));
		o.println(String.format("Used RAM Space:         %.2f%%", osim.getRamUsedMemoryPercent()));
		o.println(String.format("Process CPU Load:       %.2f%%", osim.getCpuProcessLoadPercent()));
		o.println(String.format("Systeme CPU Load:       %.2f%%", osim.getCpuSystemLoadPercent()));
	}
	
	static void driveListOut()
	{
		File [] drives = File.listRoots();
		FileSystemView fileType= FileSystemView.getFileSystemView();
		
		System.out.println("\n-----------Disk List------------");
		
		if (drives.length > 0 && drives != null){
			
			for (File drive : drives) 
			{
				String dr = drive.getAbsolutePath();
				String fs = bytesToHumanReadableValue(drive.getFreeSpace());
				double fsp = (double)drive.getFreeSpace() / drive.getTotalSpace() * 100;
				String std = fileType.getSystemTypeDescription(drive);
				String sdn = fileType.getSystemDisplayName(drive);

				System.out.println("Drive Name: " + dr);
				System.out.println("Drive Free Space: " + fs + " | " + Math.round(fsp) + "%");
				System.out.println("Type Description: " + std);
				System.out.println("Display Name: " + sdn);
			}
			
		}
		
	}
}
