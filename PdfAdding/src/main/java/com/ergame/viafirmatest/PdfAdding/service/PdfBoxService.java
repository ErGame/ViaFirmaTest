package com.ergame.viafirmatest.PdfAdding.service;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfBoxService {
	
	public static void addPagePdf(File file, Logger logger) {
		PDDocument pdf;
		try {
			pdf = PDDocument.load(file);
			PDPage page = new PDPage();
			pdf.addPage(page);
			pdf.save(file.getAbsolutePath());
			pdf.close();
			logger.log(Level.INFO, "File modified correctly: " + file.getName());
		} catch (IOException e) {
			logger.log(Level.SEVERE, "error loading the file: " + file.getName());

		}
		
	}

}
