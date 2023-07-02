import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.net.ssl.SSLEngineResult.Status;

class Cutomer {
	String name;
	String email;
	Cart cart;
	List<Address> address;
	
	public void Returnitem() {
		
	}
	
	public void AddtoCart(Item item) {
		cart.addItem(item);
	}
	
	public List<Item>ViewItem(){
		return cart.getItemList();
		
	}
	public Order checkOut() {
	     List<Item> Itemlist = cart.getItemList();
	     return new Order(Itemlist,address.get(0), Order.AMAZON_ADDRESS);
		
	}
}

class Item{
	private Product product;
	private double amount;
	public double getAmount() {
		return amount;
	}
	
}
class Cart{
	private List<Item> items;

	public List<Item> getItemList() {
		return items;
	}
	public void addItem(Item item) {
		items.add(item);
	}
}

class Order{
	public static final Address AMAZON_ADDRESS = new Address();
	String id;
	List<Item> items;
	Double amount;
	Payment payment;
	Address destination;
	Address source;
	List<Delivery> delivery;
	Status status;
	
	public Order(List<Item> Itemlist, Address customeraddress,Address sourceaddress ) {
		id = UUID.randomUUID().toString();
		items = Itemlist;
	    amount = Itemlist.stream().mapToDouble(item->item.getAmount()).sum();
	    destination = customeraddress;
	    source = sourceaddress;
	    ArrayList deliveries = new ArrayList<>();
	}
	public void statusChange(OrderStatus orderstatus) {
		if(orderstatus == OrderStatus.paymeny_completed) {
			List<Address> deliveries;
			items.forEach(item->deliveries.add(new Delivery((List<Item>) Collections.singleton(item),this)));
		}
		if(orderstatus == OrderStatus.completed) {
			List<Address> deliveries;
			items.stream().map(item->new invoice(this,this)).collect(Collectors.toList());
		}
	}
}
enum OrderStatus{
	ckeckout,paymeny_completed,incompletred,in_flight,completed
}
 class Payment{
	 String id;
	 PaymentMethod paymentmethod;
	 String status;
	 
 }
 class Address{
	 String pincode;
	 String details;
	 
 }
 enum PaymentMethod{
	 upi,cc,cash,credits	 
}
class Product{
	String descp;
	String id;
}
class invoice{
	Order order;
	Item item;
	String invoice;
	Double price;
	Double taxes;
	
	public invoice(Order order,Item order2) {
		this.order = order;
		this.item = order2;
	}
}
class Delivery{
	public Delivery(List<Item> items,Order order) {
		this.items = items;
	}
	Order order;
	String id;
	List<Item> items;
	String status;
	String develiryupdate;
	
}