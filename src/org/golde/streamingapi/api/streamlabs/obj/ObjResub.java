package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjResub extends ObjBase {

	private final String sub_plan;
	private final int amount;
	private final int months;
	private final Object emotes;
	private final int streak_months;
	private final String message;
	
	public ObjResub(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, String sub_plan, int amount, int months, Object emotes, int streak_months, String message) {
		super(event_id, acc, isTest, name, _id, priority);
		this.sub_plan = sub_plan;
		this.amount = amount;
		this.months = months;
		this.emotes = emotes;
		this.streak_months = streak_months;
		this.message = message;
	}

}
