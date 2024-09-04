package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpToBranchBackendApplication {

	public static void main(String[] args) {
		String password = null;
				try { 
					password = new Scanner(new File("C:\\Software\\pass.txt")).nextLine(); } catch
		  (FileNotFoundException e) { e.printStackTrace(); } Properties prop =
		  System.getProperties(); prop.setProperty("spring.datasource.password",
		  password);
		 
				SpringApplication.run(EmpToBranchBackendApplication.class, args);
			}

}
