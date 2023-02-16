package com.ergame.viafirmatest.PdfAdding.controller;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import com.ergame.viafirmatest.PdfAdding.service.EnvService;
import com.ergame.viafirmatest.PdfAdding.service.PdfBoxService;


public class PdfAddingController {
	
	public static void pdfAdding(String location) {
		Path path;
		if (location == "VIAFIRMA_PATH") {
			path = EnvService.getEnvVar(location);
		}
		else {
			path = Path.of(location);
		}

		List<File> pdfs = Stream.of(new File(path.toString()).listFiles())
				.filter(file -> file.getName().contains("."))
			    .filter(file -> isPdf(file))
			    .toList();
		if (pdfs.size() != 0) {
			pdfs.stream()
			.forEach(file -> PdfBoxService.addPagePdf(file));
		}
		else {
			//TODO LOG no archivos
		}
			    
	}
	
	private static Boolean isPdf(File file) {
		return "pdf" == file.getName().substring(file.getName().lastIndexOf(".") + 1);
	}

}
