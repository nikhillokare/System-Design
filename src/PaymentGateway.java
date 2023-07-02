import javax.swing.plaf.nimbus.State;

public class PaymentGateway {

	
}
class User{
	String id;
	
	public void create(Transaction t) {
		
	}
}

class Transaction{
	State status;
	String id;
	Amount amount;
	Account senderAccount;
	Account receiverAccount;
	String desc;
	PaymentMethods paymentmethod;
	
	public void setStatus(State newState) { 
		State oldstate = newState;
		status = newState;
		status.notifyUsers();
	}
}
enum PaymentMethods{
	card,bank_tranfer,upi,gift
}

class RuleEngine{
	
	public boolean validate(Transaction t) {
		return false;
	}
	
	public boolean isFraud(Transaction t) {
		return false;
	}
}

class Bank{
	String id;
	String name;
	String metaData;
	
}
class Account{
	Bank bank;
	User user;
	String id;
	
}
class Amount{
	double value;
	Currency currency;
	
}
enum Currency{
	ind,usd
}

abstract class State{
	abstract void notifyUsers(senderAccount,receiverAccount);
}

void notifyUsers(Account senderAccount, Account receiverAccount, State oldstate) {
		// TODO Auto-generated method stub
		
	}

class Status{

	public void notifyUsers(Account senderAccount, Account receiverAccount) {
		
	}
	//successful,fail,inprogress,onhold
}

class SuccessfulTransaction extends State{

	@Override
	void notifyUsers(Account senderAccount, Account receiverAccount,State oldstate) {
		
		
	}

	
}

class FailsedTransaction extends State{

	@Override
	void notifyUsers() {
		
		
	}
	
}