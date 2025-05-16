package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.longg.dto.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
	
	
	
	
	public void createFile(String logPath) {
	    try {
	      File myObj = new File(logPath);
	      myObj.createNewFile();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
    }
	
	
	public void writeToFile(String logPath, String content) {
		try {
			FileWriter myWriter = new FileWriter(logPath);
			myWriter.write(content);
		    myWriter.close();
	    } catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
	}
	
	public boolean isFileExisted(String logPath) {
		File f = new File(logPath);
		return f.exists();
	}

		
	
	
}
