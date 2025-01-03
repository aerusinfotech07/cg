import java.util.Date;

public class Product {
	
	private int productId;
	private String productName;
	private float unitPrice;
	private float sellingPrice;
	private int totalQuantity;
	private int soldQuantity;
	private String catagory;
	private Date launchdate;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, float unitPrice, float sellingPrice, int totalQuantity,
			int soldQuantity, String catagory, Date launchdate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.sellingPrice = sellingPrice;
		this.totalQuantity = totalQuantity;
		this.soldQuantity = soldQuantity;
		this.catagory = catagory;
		this.launchdate = launchdate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", sellingPrice=" + sellingPrice + ", totalQuantity=" + totalQuantity + ", soldQuantity="
				+ soldQuantity + ", catagory=" + catagory + ", launchdate=" + launchdate + "]";
	}
	
	public void buy(int quantity)
	{
		this.totalQuantity=this.totalQuantity+quantity;
	}
	
	public void sell(int quantity)
	{
		this.totalQuantity=this.totalQuantity-quantity;
		this.soldQuantity=this.soldQuantity+quantity;
	}
	
	
	public void profitDetails()
	{
		float profitValue=this.soldQuantity*(this.sellingPrice-this.unitPrice);
		
		System.out.println("Total Profit is "+profitValue);
	}
	
	

}
