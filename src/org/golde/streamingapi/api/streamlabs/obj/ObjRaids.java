package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjRaids extends ObjBase {

	private final int raiders;
	
	public ObjRaids(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, int raiders) {
		super(event_id, acc, isTest, name, _id, priority);
		this.raiders = raiders;
	}

}
