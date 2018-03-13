package org.myapplication.com;

import java.util.Iterator;

public class Item {
String itemid;
String name;
String warehouse_country;

public String getItemid() {
	return itemid;
}


public void setItemid(String itemid) {
	this.itemid = itemid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getWarehouse_country() {
	return warehouse_country;
}


public void setWarehouse_country(String warehouse_country) {
	this.warehouse_country = warehouse_country;
}

public boolean compareItem(Item item) {
	   return  this.getItemid().equals(item.getItemid());
	  
	}

}



