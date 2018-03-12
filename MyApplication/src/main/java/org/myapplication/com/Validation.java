package org.myapplication.com;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Validation {
	private org.jdom.Document store;
    private org.jdom.Document purshaseOrder;


public org.jdom.Document getstore() {
	return store;
}

public org.jdom.Document getpurchaseOrder() {
	return purshaseOrder;
}



public  void setSDocument(String xmlfile) {
		try {
	    SAXBuilder sxb=new SAXBuilder();
		store=sxb.build(new File("store.xml"));

		}
		catch (final Exception e) {
		    e.printStackTrace();
		}
	}			
	
public  void setPDocument(String xmlfile) {
	try {
		SAXBuilder sxb=new SAXBuilder();
		purshaseOrder=sxb.build(new File("purshaseOrder.xml"));    
	}
	catch (final Exception e) {
	    e.printStackTrace();
	}
}			

	
public  Item getItemFomStoreNode(org.jdom.Element  itm) {
	Item item=new Item();
	item.setItemid(itm.getAttributeValue("item-id"));
	
    List child = itm.getChildren();
	for (int i=0; i<child.size();i++) {
		org.jdom.Element node=(org.jdom.Element) child.get(i);
		if(node.getName().equals("name"))  item.setName(node.getValue());
		//if(node.getNodeName().equals("stock")) {item.setWarehouse_country(node.);
	
		} 
				
return item;	
	
}	
	
public  Item getItemFomPurchaseNode(org.jdom.Element  itm) {
	Item item=new Item();
	
	item.setItemid(itm.getAttributeValue("itemID"));
	
    List child = itm.getChildren();
	for (int i=0; i<child.size();i++) {
		Element node=(Element) child.get(i);
		if(node.getNodeName().equals("p:productName"))  item.setName(node.getNodeValue());
		//if(node.getNodeName().equals("stock")) {item.setWarehouse_country(node.);
	
		} 
				
return item;	
	
}		

public  ArrayList<Item> getItemsFromStore(){
	ArrayList<Item> items=new ArrayList<Item>();
	org.jdom.Element racine = store.getRootElement() ;
	 List lesitems = racine.getChildren();
	 
	for(int i=0; i<lesitems.size();i++) {
	items.add(getItemFomStoreNode((org.jdom.Element)lesitems.get(i)));
	
	} 
	
	
return items;

	
}	
	

public  ArrayList<Item> getItemsFrompurchaseOrder(){
	ArrayList<Item> items=new ArrayList<Item>();
	org.jdom.Element racine = purshaseOrder.getRootElement();
	 List Allrootchild = racine.getChildren();
	for(int i=0; i<Allrootchild.size();i++) {
		
		 List Allorderchild=((org.jdom.Element)Allrootchild.get(i)).getChildren();
		 for(int j=0; j<Allorderchild.size();j++) {
			 if(((org.jdom.Element)Allrootchild.get(j)).getName().equals("p:item")) items.add(getItemFomPurchaseNode((org.jdom.Element)Allrootchild.get(j)));
		 
		 }
	} 
	
	
return items;
	
	
	

	
}	
	


public  boolean valider() {
	
	 ArrayList<Item> itemsfromStore= getItemsFromStore();
	 ArrayList<Item> itemsfromPurshase= getItemsFrompurchaseOrder();
	 boolean response=true;
	 
	 Iterator it= itemsfromStore.iterator();
	 Iterator it1= itemsfromPurshase.iterator();

while (it.hasNext()) {
	boolean rep=false;
	while (it1.hasNext()) {
		
		if (((Item)it.next()).compareItem((Item)it1.next())) rep=true;
		
	}	
	
response=response&&rep;	
}
	
return response;
}



public static void main(String[] arg) {
	Validation valider=new Validation();
	valider.setSDocument("store.xml");
	valider.setPDocument("purshaseOrder.xml");
	//System.out.println(""+valider.valider());
	
	
	
}

}
