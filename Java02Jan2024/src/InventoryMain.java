import java.util.Date;

public class InventoryMain {

	public static void main(String[] args) {
		Product product1=new Product(101, "HP P", 40000, 45000, 20, 0, "Laptop", new Date(System.currentTimeMillis()));
		System.out.println(product1);
		product1.sell(5);
		System.out.println(product1);
		product1.profitDetails();

	}

}
