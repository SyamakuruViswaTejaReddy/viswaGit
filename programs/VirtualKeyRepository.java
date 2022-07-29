//Virtual Key for your Repositories
package Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VirtualKeyRepository {

	public static void retriveCurrentFiles(ArrayList<String>arr) {
    //This retriveCurrentFiles() is used to fetch the files in ascending order...  
		if(arr.isEmpty())//if the folder is empty...
        	System.out.println("Empty directory");
        else {
        	System.out.println("...Retrive Current file names in ascending order...");
        	int arrlength =  arr.size();
        	String temp;
        	for (int i = 0; i < arrlength; i++) {   //Logic for sorting...
        		for (int j = 1; j < arrlength; j++) {
        			if (arr.get(j-1).compareTo(arr.get(j))>=0) {
        				temp = arr.get(j-1);
        				arr.set(j-1, arr.get(j)); 
        				arr.set(j,temp);
        			}
        		}
        	}
        	Iterator<String> ltr=arr.iterator(); //Iterator is used for traversing all the file names to print.
        	while(ltr.hasNext())
        		System.out.println(ltr.next());
        }
	}
	
	public static void  AddWriteFile(String s)throws IOException{
		//This AddWriteFile() is used for adding a new file and wish to add data into the file.
		Scanner sc=new Scanner(System.in);
		File file=new File(s);
		if(file.createNewFile()) {
			System.out.println("File:"+s+" Added Successfully");
		}
		else {
			System.out.println("File already exist...");
		}
		System.out.println("Do you want to add data into the file(Y/N):");
		char c=sc.next().charAt(0);
		if(c=='y'||c=='Y') {
			FileWriter writer=new FileWriter(file,false);//write
			Scanner sin=new Scanner(System.in);
			System.out.println("Add data which you want:");
			String st=sin.nextLine();
			writer.write(st);
			System.out.println("Data successfully added...");
			writer.close();
		}
		
	}
	
	public static void deleteFile(String s) throws IOException{
		//This deleteFile() deletes the file if exist.
		Path path= Paths.get(s);
		if(Files.deleteIfExists(path))
			System.out.println("File:"+s+" deleted");
		else
			System.out.println("File not exist to delete");
	}
	
	public static void readFile(String s) throws IOException{
		//This readFile() reads content from the file.
		FileReader reader= new FileReader(s);
		int data;
		System.out.println("reading data from the file:"+s);
		while((data=reader.read())!=-1){
			System.out.print((char)data);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		ArrayList<String> arr=new ArrayList<String>();//It is used for storing file names to maintain order. 
		while(true){
			System.out.println("1.Retrive Current file names in ascending order...");
			System.out.println("2.Business Level Operation Menu");
			System.out.println("3.Exit from the Application");
			System.out.println("Enter your Choice:");
			Scanner sin=new Scanner(System.in);
			int i=sin.nextInt();
			if(i==1) {  //Retrive current filename in ascending order.
				retriveCurrentFiles(arr);
				}
			else if(i==2) {   //Business level operation menu.
				while(true) {
					System.out.println("...Business Level Operation Menu...");
					System.out.println("1.Add file 2.Delete File 3.Search file 4.Exit from BLO Menu");
					System.out.println("Enter your choice:");
					int ins=sin.nextInt();
					if(ins==1) {  //Add file and its contents to the directory.
						
						try {
							System.out.println("please provide name of the file which you want to add:");
							Scanner sc=new Scanner(System.in);
							String s=sc.nextLine();
							AddWriteFile(s);
							arr.add(s);
						}
						catch(IOException e) {
							System.out.println("Exception:"+e);
						}
		        	}
					else if(ins==2) { //Delete a file from the directory.

						try {
							System.out.println("please provide name of the file you want to delete:");
							Scanner sc=new Scanner(System.in);
							String s=sc.nextLine();
							deleteFile(s);
							arr.remove(s);
						}
						catch(IOException e) {
							System.out.println("Exception:"+e);
						}
						
					}
					else if(ins==3) { // searching a file and showing its content.
						try {
							System.out.println("please provide name of the file you want to search:");
							Scanner sc=new Scanner(System.in);
							String s=sc.nextLine();
							int len=arr.size();
							int c=0;
							Iterator<String> ltr=arr.iterator();
							while(ltr.hasNext()) {
								if(s.compareTo(ltr.next())==0) { //Searching Technique.
									System.out.println("File:"+s+" found...");
									c=1;
									break;
								}
							}
							if(c==0)
								System.out.println("File not found...");
							else {
								System.out.println("Do you want read contents from the file(Y/N):");
								//Scanner sc=new Scanner(System.in);
								char ch=sc.next().charAt(0);
								if(ch=='y' || ch=='Y') {
									readFile(s);
								}
							}
						} 
						catch (IOException e) {
							System.out.println("File not available"+e);
						}
		        	}
					else if(ins==4) {  //Exit from the Business Level Operations Menu.
						System.out.println("Exit from BLO Menu...");
						break;
					}
					else {
						System.out.println("You entered Invalid Choice...");

					}
					
				}

				
			}
			
			else if(i==3) {    //Exit from the Application.
				System.out.println("Exit from the Application...");
				break;
			}
			else {
				System.out.println("You entered Invalid Choice...");

			}
		}

	}

}

