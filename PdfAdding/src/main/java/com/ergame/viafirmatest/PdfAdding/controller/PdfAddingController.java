package com.ergame.viafirmatest.PdfAdding.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.ergame.viafirmatest.PdfAdding.service.PdfBoxService;


public class PdfAddingController {
	
	public static void pdfAdding(String location) {
		
		Logger newLogger = Logger.getLogger("PdfAdding");
		Logger logger = loggerInitialazing(newLogger);
		
		Path path = Path.of(location);
		
		logger.log(Level.INFO, "Modifying PDFs in " + path.toString());

		List<File> pdfs = Stream.of(new File(path.toString()).listFiles())
				.filter(file -> file.getName().contains("."))
			    .filter(file -> isPdf(file))
			    .toList();
		if (pdfs.size() != 0) {
			pdfs.stream()
			.forEach(file -> PdfBoxService.addPagePdf(file, logger));
		}
		else {
			logger.log(Level.WARNING, "No pdf in this location");
		}
			    
	}
	
	private static Boolean isPdf(File file) {
		
		return file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("pdf");
	}
	
	private  static Logger loggerInitialazing(Logger logger) {
		
		
		Path logPath = Path.of(System.getProperty("user.dir")).resolve("log").resolve("log");
		new File(Path.of(System.getProperty("user.dir")).resolve("log").toString()).mkdir();
		try {
			FileHandler handler = new FileHandler(logPath.toString());
			logger.addHandler(handler);
			logger.log(Level.INFO, "Log file created correctly: " + logPath.toString());
		} catch (SecurityException e) {
			logger.log(Level.WARNING, "Security error. Handler can´t be created");
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Input/Output error. Handler can´t be created");
			e.printStackTrace();
		}
		return logger;
	}

}
