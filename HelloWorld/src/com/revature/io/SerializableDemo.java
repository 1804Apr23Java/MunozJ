package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "src/serialzedThings/Movies";
		
	}
//	public static Object deserializeObject(String filename) {
//		Object o = null;
//		try {
//			FileInputStream fileIn = new FileInputStream(filename);
//			ObjectOutputStream in = new ObjectOutputStream(fileIn);
//			o = in.readObject();
//			in.close();
//			fileIn.close();
//		}
//		catch(FileNotFoundException f) {
//			f.printStackTrace();
//			}
//		return o;
//	}

	public static void serializbaleObject(String filename, Object o) {
		//use a file output stream to write bytestream to a file
		try {
			FileOutputStream fileout = new FileOutputStream(filename);
		//and use an Object output stream to represent an object as a byte stream
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(o);
			out.close();
			fileout.close();
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
			}
		catch(IOException e) {
			e.printStackTrace();
			}
		//endtry
	}
	
	
}
