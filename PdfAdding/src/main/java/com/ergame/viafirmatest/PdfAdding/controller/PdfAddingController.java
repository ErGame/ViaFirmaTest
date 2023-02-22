package com.ergame.viafirmatest.PdfAdding.controller;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.ergame.viafirmatest.PdfAdding.service.PdfBoxService;


public class PdfAddingController {
	
	public static void pdfAdding(String location) {
		
		Logger logger = Logger.getLogger("PdfAdding");
		
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

}
