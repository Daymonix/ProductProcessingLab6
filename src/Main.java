import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Product> ps = new ArrayList<Product>();
		String data = "";
		data = readFile("in.txt");
		String[] ls = data.split(";");
		
		for(String s : ls) {
			if(!s.isEmpty()) {
				String[] ln = s.split(", ");
				ps.add(new Product( Long.parseLong(ln[0].trim()), ln[1], ln[2], ln[3], Double.parseDouble(ln[4]), Integer.parseInt(ln[5]), Integer.parseInt(ln[6])));
			}
		}
		
		Product[] sArr = ps.toArray(new Product[ps.size()]);
		Arrays.sort(sArr);
		data = "";
		for(int i = 0; i < sArr.length; i++) {
			data += sArr[i] + "\n";
		}
		writeFile("out.txt", data);
		
		System.out.println("Original list:");
		for(Product p : ps) {
			System.out.println(p);
		}
		System.out.println("");
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Enter the name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter price: ");
			String priceStr = sc.nextLine();
			double price = Double.parseDouble(priceStr.trim());
			
			System.out.print("Enter storage length: ");
			String storageLengthStr = sc.nextLine();
			int storageLength = Integer.parseInt(storageLengthStr.trim());
			
			
			
			System.out.println("List for only current name:");
			for(Product p : ps) {
				if(p.name.toLowerCase().trim().compareTo(name.toLowerCase().trim()) == 0) {
					System.out.println(p);
				}
			}
			System.out.println("");
			
			
			System.out.println("List for only current name with price which lower than " + price + ":");
			for(Product p : ps) {
				if(p.name.toLowerCase().trim().compareTo(name.toLowerCase().trim()) == 0 
						&& p.price < price) {
					System.out.println(p);
				}
			}
			System.out.println("");
			
			System.out.println("List of products with storrage length which bigger than " + storageLength + ":");
			for(Product p : ps) {
				if(p.storageLength > storageLength) {
					System.out.println(p);
				}
			}
			System.out.println("");
			
			
		} catch (Exception e) {
			System.out.println("Invalid value");
		}
		
		
		sc.close();
		
		
		
	}
	
	static String readFile(String path) {
		String r = "";
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			r = new String(encoded);
		} catch (Exception ex) {
			System.out.println("Invalid file or filename");
		}
		return r;
	}
	
	static void writeFile(String path, String data) {
		try {
			String str = data;
		    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		    writer.write(str);
		     
		    writer.close();
		} catch (Exception ex) {
			System.out.println("Invalid file or filename");
		}
	}
	
}
