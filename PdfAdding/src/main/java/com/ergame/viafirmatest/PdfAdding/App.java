package com.ergame.viafirmatest.PdfAdding;

import com.ergame.viafirmatest.PdfAdding.controller.PdfAddingController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String path = args[0];
    	PdfAddingController.pdfAdding(path);
    }
}
