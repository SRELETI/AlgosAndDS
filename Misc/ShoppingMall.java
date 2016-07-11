
public class ShoppingMall {

	private int bill;
	private String custName;
	private String custPhone;
	
	public Discount ds;
	public void setCustName(String name) { custName = name; }
	public String getCustName() { return custName; }
	
	public void setCustPhone(String phone) { custPhone = phone; }
	public String getCustPhone() { return custPhone; }
	
	public void calculateBill(int totalVal) {
		bill = (int) (totalVal-(totalVal*ds.getDiscount()));
	}
	
	public int getFinalBill() { return bill; }
}
