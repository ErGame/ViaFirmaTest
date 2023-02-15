package com.ergame.viafirmatest.PdfAdding.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfBoxService {
	
	public static void addPagePdf(PDDocument document) {
		PDPage page = new PDPage();
		document.addPage(page);
	}

}
