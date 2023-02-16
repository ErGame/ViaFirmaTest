package com.ergame.viafirmatest.PdfAdding.service;

public class EnvService {
	
	public static String getEnvVar(String envName) {
		
		String path = null;
		
		try {
			path = System.getenv(envName);
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
