package org.myapplication.com;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;



public class Validation {
	private static  Document store;
    private static Document purshaseOrder;
    
    
public Validation(String storefilename,String purshahefilename) {
		 try {
			    SAXBuilder sxb=new SAXBuilder();
			    store=sxb.build(new File(storefilename));
			    purshaseOrder=sxb.build(new File(purshahefilename));
				}
				catch (final Exception e) {
				    e.printStackTrace();
				}
   } 
   


public  Item getItemFomStoreNode(Element  element) {
	Item item=new Item();
	item.setItemid(element.getAttributeValue("item-id"));
	
    List child = element.getChildren();
	for (int i=0; i<child.size();i++) {
		Element node=(Element) child.get(i);
		if(node.getName().equals("name"))  item.setName(node.getValue());
		//if(node.getNodeName().equals("stock")) {item.setWarehouse_country(node.);
	
		} 
				
return item;	
	
}	
	
public  Item getItemFomPurchaseNode(Element  element) {
	Item item=new Item();
	
	item.setItemid(element.getAttributeValue("itemID"));
	
    List child = element.getChildren();
	for (int i=0; i<child.size();i++) {
		Element node=(Element) child.get(i);
		if(node.getName().equals("productName"))  item.setName(node.getValue());
		//if(node.getNodeName().equals("stock")) {item.setWarehouse_country(node.);
	
		} 
				
return item;	
	
}		

public  ArrayList<Item> getItemsFromStore(){
	ArrayList<Item> items=new ArrayList<Item>();
	 Element racine = store.getRootElement() ;
	 List lesitems = racine.getChildren();
	 
	for(int i=0; i<lesitems.size();i++) {
		
		if(((Element)lesitems.get(i)).getName().equals("item"))
	items.add(getItemFomStoreNode((Element)lesitems.get(i)));
	
	} 
	
	
return items;

	
}	
	

public  ArrayList<Item> getItemsFrompurchaseOrder(){
	ArrayList<Item> results=new ArrayList<Item>();
    Element racine = purshaseOrder.getRootElement();
	 List orders = racine.getChildren();
	 Iterator it= orders.iterator();

	 while (it.hasNext()) {
		 List ordersChild= ((Element)it.next()).getChildren();
		Iterator it1=ordersChild.iterator();
		for(int i=0;i<ordersChild.size();i++) {
				if((((Element) ordersChild.get(i)).getName()).equals("items") ) {
					// System.out.println(((Element)  ordersChild.get(i)).getName());
					List items =((Element) ordersChild.get(i)).getChildren();
					Iterator it3=items.iterator();
					while(it3.hasNext()) {
					results.add(getItemFomPurchaseNode((Element) it3.next()));
					}
					
				}
			
			
		}
		 
 
		 
	 }

return results;
	
	
	

	
}	
	


public  boolean valider() {
	
	 ArrayList<Item> itemsfromStore= getItemsFromStore();
	 ArrayList<Item> itemsfromPurshase= getItemsFrompurchaseOrder();
	 boolean response=true;
	 
	
	 
for(int i=0;i<itemsfromPurshase.size();i++) {
	boolean rep=false;
	for(int j=0;j<itemsfromStore.size();j++){
		
		rep=rep||(((Item)itemsfromStore.get(j)).compareItem((Item)itemsfromPurshase.get(i))) ;
		
	}	
	
response=response&&rep;	
}
	
return response;
}



public static void main(String[] arg) {
	Validation valider=new Validation("store.xml","purshaseOrder.xml");
	 ArrayList<Item> itemsfromPurshase= valider.getItemsFrompurchaseOrder();
	 ArrayList<Item> itemsfromStore= valider.getItemsFromStore();

	 Iterator it=itemsfromStore.iterator();
	 Iterator it1=itemsfromPurshase.iterator();
	 while (it.hasNext()) {
		 Item itm=(Item) it.next();
		 System.out.println(""+ itm.getItemid());
		 System.out.println("......");

		 
	 }
	 
	System.out.println("**************************");
	
	 while (it1.hasNext()) {
		 Item itm=(Item) it1.next();
		 System.out.println(""+ itm.getItemid());

	 }
	 
	System.out.println("**********"+valider.valider()+"****************");
	
}

}
