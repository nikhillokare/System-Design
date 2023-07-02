package ChatApp;

import java.util.List;
import java.util.UUID;

class User{
	
	long lastActivity;
	String id;
	MessageQueue messagequeue;
	private String status;
	
	public long getPresence() {
		return lastActivity;
	}
	
	public void send(Message message) {
		messagequeue.publish(message);
	}
	
	public void receive(Message message) {
		messagequeue.receiveMessage(message);
	}
	
	public void edit(Message message) {
		messagequeue.publishEdit(message);
	}
	
	public void reply(Reply reply) {
		messagequeue.publish(reply);
	}
	
	public void react(Reaction reaction) {
		messagequeue.publish(reaction);
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public void JoinGroup(Group group) {
		group.addMember(this,this);
	}
    public void CreateGroup(Group group) {
    	group.addMember(this,this);
	}
    public void LeaveGroup(Group group) {
    	new Group(this,userList, metadata);
	}

}

class Group{
	List<User> userList;
	String id;
	String metadata;
	User creater;
	
	public Group(User user,List<User> userList,String metadata) {
		id=UUID.randomUUID().toString();
	    creater = user;
	    this.userList = userList;
	    this.metadata = metadata;
	 
	}
	
	public void addMember(User user,User adder) {
		if(userList.contains(adder)) {
			userList.add(user);
		}
	}
	public void removeMember(User user,User remover) {
		if(userList.contains(remover) && userList.contains(user)) {
			userList.add(user);
		}
	}
}
class Reaction{
	User user;
	String desc;
	Chat chat;
}
class Chat{
	String id;
	ChatType type;
	public void increment(Reaction reaction) {
		// TODO Auto-generated method stub
		
	}
}
class Reply{
	Message message;
	User user;
	String Desc;
	String id;
}

class Message{
	Attachment attachment;
	String body;
	User sender;
	Thread receiver;
	MessageStatus status;
	long editedAt;
	String id;
	
	public void status(MessageStatus seen) {
		
	}
	public Thread getThread() {
		return receiver;
	}
	public void addreply(Reply reply) {
		// TODO Auto-generated method stub
		
	}
}

class Attachment{ 
	int filesize;
	String fileextension;
} 
class Thread{
	String id;
	ThreadType threadtype;
	public Object messages;
	
	public ThreadType type() {
		 return threadtype;
	}
}
enum ThreadType{
	ONE_TO_ONE,GROUP
}

enum MessageStatus{
	RECEIVED,PARTIAL_RECEIVED
}
enum ChatType{
	MESSAGE, REPLY
}

class MessageQueue{

	public void publish(Reaction reaction) {
		reaction.chat.increment(reaction);
	}
	
    public void publish(Message message) {
    	message.getThread().messages.add(message);
	}


    public void publish(Reply reply) {
		reply.message.addreply(reply);
	}


	public void publishEdit(Message message) {
		
	}
	public void receiveMessage(Message message) {
		if(message.getThread().type().equals(ThreadType.ONE_TO_ONE)){
		      message.status(MessageStatus.RECEIVED) ;	
		}
		else {
			message.status(MessageStatus.PARTIAL_RECEIVED);
		}
		
	}
	
}
