//File Handling
package Multexc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RewriAppend {
	public static void  createWriteFileUsingFileClass()throws IOException{
		File file=new File("C:\\Users\\syama\\Documents\\viswa\\files\\cre.txt");
		if(file.createNewFile()) {
			System.out.println("File created");
		}
		else {
			System.out.println("File already exist...");
		}
		FileWriter writer=new FileWriter(file,false);//write
		writer.write("hii hello.....");
		System.out.println("Write operation completed...");
		writer.close();
	}
	public static void  appendUsingFileClass()throws IOException{
		File file=new File("C:\\Users\\syama\\Documents\\viswa\\files\\cre.txt");
		FileWriter writer=new FileWriter(file,true);//append
		writer.write("heyyyyyy.....");
		System.out.println("data Appended Successfully...");
		writer.close();
	}
	public static void readFileReaderClass() throws IOException{ 
		FileReader reader= new FileReader("C:\\Users\\syama\\Documents\\viswa\\files\\cre.txt");
		int data;
		System.out.println("reading data from the file");
		while((data=reader.read())!=-1){
			System.out.print((char)data);
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		while(true) {
			System.out.println("File Operations");
			System.out.println("1.write 2.read 3.append exit(press any key)");
			Scanner sin=new Scanner(System.in);
			int i=sin.nextInt();
			if(i==1) {
				try {
					createWriteFileUsingFileClass();
				}
				catch(IOException e) {
					System.out.println("Exception:"+e);
				}
        	}
			else if(i==2) {
				try {
					readFileReaderClass();
				} 
				catch (IOException e) {
					System.out.println("File not available"+e);
				}
			}
			else if(i==3) {
				try {
					appendUsingFileClass();
				}
				catch(IOException e) {
					System.out.println("Exception:"+e);
				}
        	}
			else {
				System.out.println("Exit...");
				break;
			}
		}

	}

}
