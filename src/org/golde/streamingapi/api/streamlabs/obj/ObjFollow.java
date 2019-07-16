package org.golde.streamingapi.api.streamlabs.obj;

public class ObjFollow extends ObjBase {

	public ObjFollow(String event_id, boolean isTest, String name, String _id, int priority) {
		super(event_id, AccountType.TWITCH, isTest, name, _id, priority);
	}

}
