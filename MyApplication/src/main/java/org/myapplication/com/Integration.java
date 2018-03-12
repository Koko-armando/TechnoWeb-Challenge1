package org.myapplication.com;

import java.io.File;


import org.jdom2.Document;

import org.jdom2.input.SAXBuilder;
import org.jdom2.transform.XSLTransformer;

public class Integration {
	
	public static void requete2() {

        try {
            SAXBuilder builder = new SAXBuilder();
            builder.setIgnoringElementContentWhitespace(true);
            Document documentSource = builder.build(new File("store.xml"));
            XSLTransformer transformer = new XSLTransformer("Req2Store.xslt");
            Document documentCible = transformer.transform(documentSource);
            MesMethodes.affiche(documentCible);
        }
        catch(Exception e) {}
    }
	
	public static void requete3() {

        try {
            SAXBuilder builder = new SAXBuilder();
            builder.setIgnoringElementContentWhitespace(true);
            Document documentSource = builder.build(new File("store.xml"));
            XSLTransformer transformer = new XSLTransformer("Req2Store.xslt");
            Document documentCible = transformer.transform(documentSource);
            MesMethodes.affiche(documentCible);
        }
        catch(Exception e) {}
    }
	
	public static void requete4() {

        try {
            SAXBuilder builder = new SAXBuilder();
            builder.setIgnoringElementContentWhitespace(true);
            Document documentSource = builder.build(new File("purshaseOrder.xml"));
            XSLTransformer transformer = new XSLTransformer("Req4PurchaseOrder.xslt");
            Document documentCible = transformer.transform(documentSource);
            MesMethodes.affiche(documentCible);
        }
        catch(Exception e) {}
    }
	public static void main(String [] args) {
		requete2();
		requete3();
		//requete4();
	}
}
