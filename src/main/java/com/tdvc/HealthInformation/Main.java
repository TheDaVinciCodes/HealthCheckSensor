/**
 * 
 */
package com.tdvc.HealthInformation;

/**
 * @author Gianluca Tanasi
 * 
 * The main class accesses the log class and lets the program play in a loop
 * and then letting it sleep for 1 minute before having the output
 */
public class Main
{

	public static void main(String[] args)
	{	
		while(true)
		{
			try 
			{
//				TimeUnit.MINUTES.sleep(30);
				new OSInfoLog();
				new OSInfoToJson();
				Thread.sleep(1000*60);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
