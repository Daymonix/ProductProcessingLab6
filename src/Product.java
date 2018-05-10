
public class Product implements Comparable<Product> {
	
	public long id = -1;
	public String name = "";
	public String UPC = "";
	public String vendor = "";
	public double price = 0.0d;
	public int storageLength = 0;
	public int count = 0;
	
	public Product() {
		
	}
	
	public Product(long id, String name, String UPC, String vendor, double price, int storageLength, int count) {
		this.id = id;
		this.name = name;
		this.UPC = UPC;
		this.vendor = vendor;
		this.price = price;
		this.storageLength = storageLength;
		this.count = count;
	}
	
	
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + UPC + ", " + vendor + ", " + price + ", " + storageLength + ", " + count + ";";
	}
	
	@Override
	public int compareTo(Product p) { //for sorting by name
		return this.name.compareTo(p.name);
	}
}
