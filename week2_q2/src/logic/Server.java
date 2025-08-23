package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.setOwner(owner);
		this.setMemberList(new ArrayList<User>());
		this.setChannelList(new ArrayList<Channel>());
		
		this.addUser(owner);
		
		this.setName(name);
		if (template == TemplateType.BASIC) this.addChannel(owner, "general");
		else if (template == TemplateType.GAMING) this.addChannel(owner, "gaming");
		else if (template == TemplateType.STUDY) this.addChannel(owner, "homework-help");
	}
	
	public Channel addChannel(User user, String channelName) {
		if (this.owner != user) return null;
		Channel channel = new Channel(channelName);
		channelList.add(channel);
		return channel;
	}
	
	public User addUser(User user) {
		if (memberList.contains(user)) return null;
		memberList.add(user);
		user.addJoinedServersList(this);
		return user;
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if (kicker != owner) throw new Exception("Only the owner can kick users.");
		else if (!memberList.contains(kicked) || kicked == owner) return false;
		else {
			kicked.getJoinedServersList().remove(this);
			memberList.remove(kicked);
			return true;
		}
	}
	
	public boolean isMemberInServer(User userToCheck) {
		return memberList.contains(userToCheck);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank()) this.name = this.getOwner().getName() + " home";
		else this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(ArrayList<Channel> channelList) {
		this.channelList = channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<User> memberList) {
		this.memberList = memberList;
	}
	
	
}
