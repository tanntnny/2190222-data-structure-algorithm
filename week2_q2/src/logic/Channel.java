package logic;

import java.util.ArrayList;

public class Channel {
	private String name;
	private ArrayList<Message> messageList;
	
	public Channel(String name) {
		this.setName(name);
		this.setMessageList(new ArrayList<Message>());
	}
	
	public void addMessage(Message message) {
		this.getMessageList().add(message);
	}
	
	public int getMessageCount() {
		return this.getMessageList().size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank()) this.name = "off-topic";
		else this.name = name;
	}

	public ArrayList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<Message> messageList) {
		this.messageList = messageList;
	}
	
	
}
