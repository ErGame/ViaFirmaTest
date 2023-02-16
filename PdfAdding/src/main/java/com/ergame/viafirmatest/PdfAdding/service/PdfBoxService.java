package com.ergame.viafirmatest.PdfAdding.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfBoxService {
	
	public static void addPagePdf(File file) {
		PDDocument pdf;
		try {
			pdf = PDDocument.load(file);
			PDPage page = new PDPage();
			pdf.addPage(page);
			pdf.save(file.getAbsolutePath());
			pdf.close();
		} catch (IOException e) {
			// TODO Error de carga
		}
		
	}

}
