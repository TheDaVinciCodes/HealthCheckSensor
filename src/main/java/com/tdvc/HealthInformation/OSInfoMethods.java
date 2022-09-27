/**
 * 
 */
package com.tdvc.HealthInformation;

import java.io.File;
import java.lang.management.*;

import com.sun.management.OperatingSystemMXBean;

/**
 * @author Gianluca Tanasi
 * 
 * This class has been created to get the OS Information 
 * from the java classes: OperatingSystemMXBean, MemoryMXBean, Runtime and File
 */
public class OSInfoMethods 
{
	File cDrive = new File("C:");
	MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
	OperatingSystemMXBean osmxb = 
			(OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	Runtime runtime = Runtime.getRuntime();

	//--------------OS Info Methods----------------//
	double getSystemLoadAvarage()
	{
		return osmxb.getSystemLoadAverage();
	}

	public String getSystemName()
	{
		return osmxb.getName();
	}

	String getSystemArch()
	{
		return osmxb.getArch();
	}

	int getSystemAvailableProcessors()
	{
		return osmxb.getAvailableProcessors();
	}

	String getSystemVersion()
	{
		return osmxb.getVersion();
	}

	//----------C-Drive Usage Methods-----------//
	long getDiskTotSpace()
	{
		return cDrive.getTotalSpace();
	}

	long getDiskFreeSpace()
	{
		return cDrive.getFreeSpace();
	}

	long getDiskUsableSpace()
	{
		return cDrive.getUsableSpace();
	}

	long getDiskUsedSpace()
	{
		return cDrive.getTotalSpace() - cDrive.getFreeSpace();
	}


	//----------RAM Usage Methods-----------//
	long getRamTotalMemory()
	{
		return osmxb.getTotalPhysicalMemorySize();
	}

	long getRamFreeMemory()
	{
		return osmxb.getFreePhysicalMemorySize();
	}

	public long getRamUsedMemory()
	{
		return osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize();
	}

	long getRamTotalSwapSpace()
	{
		return osmxb.getTotalSwapSpaceSize();
	}

	long getRamFreeSwapSpace()
	{
		return osmxb.getFreeSwapSpaceSize();
	}

	long getRamUsedSwapSpace()
	{
		return osmxb.getTotalSwapSpaceSize() - osmxb.getFreeSwapSpaceSize();
	}

	long getRamInitialHeapMemory()
	{
		return memoryMXBean.getHeapMemoryUsage().getInit();
	}

	long getRamUsedHeapMemory()
	{
		return memoryMXBean.getHeapMemoryUsage().getUsed();
	}

	long getRamMaxHeapMemory()
	{
		return memoryMXBean.getHeapMemoryUsage().getMax();
	}

	long getRamCommittedMemory()
	{
		return memoryMXBean.getHeapMemoryUsage().getCommitted();
	}

	//----------CPU Usage Methods-----------//
	long getCpuProcessTotMemory()
	{
		return runtime.maxMemory();
	}

	long getCpuProcessFreeMemory()
	{
		return runtime.maxMemory() - 
				(runtime.totalMemory() - runtime.freeMemory());
	}

	long getCpuProcessUsedMemory()
	{
		return runtime.totalMemory() - runtime.freeMemory();
	}	


	//----------Disk, RAM AND CPU Methods in %-----------//
	double getDiskFreeSpacePercent()
	{
		return (double)cDrive.getFreeSpace() / cDrive.getTotalSpace() * 100;
	}

	double getDiskUsedSpacePercent()
	{
		return (double)(cDrive.getTotalSpace() - cDrive.getFreeSpace())
				/ cDrive.getTotalSpace() * 100;
	}

	double getRamFreeMemoryPercent()
	{
		return (double)osmxb.getFreePhysicalMemorySize() / 
				osmxb.getTotalPhysicalMemorySize() * 100;
	}

	public double getRamUsedMemoryPercent()
	{
		return (double)(osmxb.getTotalPhysicalMemorySize() - 
				osmxb.getFreePhysicalMemorySize()) / 
				osmxb.getTotalPhysicalMemorySize() * 100;
	}	

	public double getCpuProcessLoadPercent()
	{
		return (double)osmxb.getProcessCpuLoad() * 100;
	}

	public double getCpuSystemLoadPercent()
	{
		return (double)osmxb.getSystemCpuLoad() * 100;
	}

}
