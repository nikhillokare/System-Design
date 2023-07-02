public class PaymentGatewayOk {
	
}

class User1{
	String id;
	
	public void create(Transaction1 t) {
		
	}
}

class Transaction1{
	Status Status;
	String id;
	Amount1 amount;
	Account1 senderAccount;
	Account1 receiverAccount;
	String description;
	PaymentMethod1 paymentmethod;
	
	public void SetState(Status newState) {
		Status = newState;	
		Status.notifyUsers(senderAccount,receiverAccount);
	}
}

enum PaymentMethod1{
	CARD,BANK_TRANSFER,UPI,GIFT;
}

class RuleEngine1{
	public boolean validate(Transaction1 t) {
		return false;
	}
	public boolean isFraud(Transaction1 t) {
		return false;
	}
}

class Bank1{
	String id;
	String name;
	String metaData;
} 

class Account1{
	Bank bank;
	User user;
	String id;
	
}
class Amount1{
	double value;
	Currency1 currency;
}

enum Currency1{
	INR,UDS;
}

class State1{

	public void notifyUsers(Account1 senderAccount, Account1 receiverAccount) {
	     
	}	//SUCCESSFULL, FAILED, INPROGRESS, IN_HOLD;
}

class SuccessfulTransaction extends State1 {
	
}
class failedTranction{
	
}