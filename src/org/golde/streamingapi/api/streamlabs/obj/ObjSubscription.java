package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjSubscription extends ObjBase {

	private final String sub_plan;
	private final int months;
	private final String message;
	private final Object emotes; //And who knows what this is
	
	public ObjSubscription(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, String sub_plan, int months, String message, Object emotes) {
		super(event_id, acc, isTest, name, _id, priority);
		this.sub_plan = sub_plan;
		this.months = months;
		this.message = message;
		this.emotes = emotes;
	}

}
