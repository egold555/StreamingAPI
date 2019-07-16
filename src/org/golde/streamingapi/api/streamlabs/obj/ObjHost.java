package org.golde.streamingapi.api.streamlabs.obj;

public class ObjHost extends ObjBase {

	private final int viewers;
	
	public ObjHost(String event_id, boolean isTest, String name, String _id, int priority, int viewers) {
		super(event_id, AccountType.TWITCH, isTest, name, _id, priority);
		this.viewers = viewers;
	}
	
	public int getViewers() {
		return viewers;
	}

}
