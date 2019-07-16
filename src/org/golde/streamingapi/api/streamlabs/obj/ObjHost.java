package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjHost extends ObjBase {

	private final int viewers;
	
	public ObjHost(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, int viewers) {
		super(event_id, acc, isTest, name, _id, priority);
		this.viewers = viewers;
	}

}
