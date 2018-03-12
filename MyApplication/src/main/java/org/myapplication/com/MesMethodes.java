package org.myapplication.com;
import java.io.FileOutputStream;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class MesMethodes {
	
	public static void affiche(Document document) {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		}
		catch( Exception e) {}
	}
	
	public static void enregistre(Document document,String fichier)
	{
	   try
	   {
	      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	      sortie.output(document, new FileOutputStream(fichier));
	   }
	   catch (java.io.IOException e){}
	}


}
