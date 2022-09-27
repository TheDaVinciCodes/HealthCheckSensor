package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("Test String");
//
//		File f = new File("var/json/oahcs/test.zip");
//		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
//		ZipEntry e = new ZipEntry("mytext.txt");
//		out.putNextEntry(e);
//
//		byte[] data = sb.toString().getBytes();
//		out.write(data, 0, data.length);
//		out.closeEntry();
//
//		out.close();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Test String");
		
		File f = new File("var/json/oahcs/test.zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("mytext.txt");
		out.putNextEntry(e);
		
		byte[] data = sb.toString().getBytes();
		out.write(data, 0, data.length);
		out.closeEntry();
		
		out.close();

	}

}
