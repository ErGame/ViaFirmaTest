package com.ergame.viafirmatest.PdfAdding.service;

import java.nio.file.Path;

public class EnvService {
	
	public static Path getEnvVar(String envName) {
		
		Path path = null;
		
		try {
			String pathStr = System.getenv(envName);
			path = Path.of(pathStr);
		}
		catch (SecurityException se){
			//TODO LOG de excepcion
		}
		if(path != null) {
			//TODO LOG de existente
		}else {
			//TODO LOG de no existente
		}
				
		return path;
	}

}
