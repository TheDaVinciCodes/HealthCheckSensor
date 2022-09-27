package com.tdvc.HealthInformation;

import java.util.List;

/**
 * @author Gianluca Tanasi
 * 
 * This class serializes the OS Information into JSON file
 *
 */
public class OSInfoSerialize {

	String date;
	String time;
	String name;

	List<DiskInfo> disk;
	CPUInfo cpu;
	RAMInfo ram;

	public OSInfoSerialize(String date, String time, String name, List<DiskInfo> disk, CPUInfo cpu, RAMInfo ram) 
	{
		this.date = date;
		this.time = time;
		this.name = name;
		this.disk = disk;
		this.cpu = cpu;
		this.ram = ram;
	}

}

class DiskInfo
{  
	String name;
	String type;
	String free_space;


	public DiskInfo(String name, String type, String free_space) 
	{
		this.name = name;
		this.type = type;
		this.free_space = free_space;
	}

}

class CPUInfo
{  
	String system;
	String process;


	public CPUInfo(String system, String process) 
	{
		this.system = system;
		this.process = process;
	}

}

class RAMInfo
{  
	String used_memory;


	public RAMInfo(String used_memory) 
	{
		this.used_memory = used_memory;
	}

}


