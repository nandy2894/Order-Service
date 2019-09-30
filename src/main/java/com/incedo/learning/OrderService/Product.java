package com.incedo.learning.OrderService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
int prodCode;
String prodName;
int prodPrice;
public int getProdCode() {
	return prodCode;
}
public void setProdCode(int prodCode) {
	this.prodCode = prodCode;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public int getProdPrice() {
	return prodPrice;
}
public void setProdPrice(int prodPrice) {
	this.prodPrice = prodPrice;
}

public Product(int prodCode, String prodName, int prodPrice) {
	super();
	this.prodCode = prodCode;
	this.prodName = prodName;
	this.prodPrice = prodPrice;
}
@Override
public String toString() {
	return "Product [prodCode=" + prodCode + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
}


}
