
public class Ticket {
	int ID;
	double Price; // each event has several/different types of tickets, which is identified as different price.
	int Amount; //each type of tickets has different amount available 
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
}
