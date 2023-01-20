package Entities;
 
public class ImportedProduct extends Product {
private Double customFree;

public ImportedProduct() {
	
}

public Double getCustomFree() {
	return customFree;
}

public void setCustomFree(Double customFree) {
	this.customFree = customFree;
}

public ImportedProduct(String name, Double price, Double customFree) {
	super(name, price);
	this.customFree = customFree;
}

public Double totalPrice() {
	return getPrice() + customFree;
}
@Override
public String priceTag() {
	return getName()
			+ " $ "
			+ String.format("%.2f", totalPrice())
			+ " Custom free: "
			+ String.format("%.2f", customFree);
			
}

}
