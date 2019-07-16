package org.golde.streamingapi.api.streamlabs.obj;

public class ObjBase {

	private final String event_id;
	private final AccountType acc;
	private final boolean isTest;
	private final String name;
	private final String _id;
	private final int priority;
	
	public ObjBase(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority){
		this.event_id = event_id;
		this.acc = acc;
		this.isTest = isTest;
		this.name = name;
		this._id = _id;
		this.priority = priority;
	}
	
	
	public enum AccountType {
		TWITCH, STREAMLABS
	}
	
	public AccountType getAccountType() {
		return acc;
	}
	
	public String getEventId() {
		return event_id;
	}
	
	public boolean isTest() {
		return isTest;
	}
	
	public String getName() {
		return name;
	}
	
	public String get_id() {
		return _id;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
