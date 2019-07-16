package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjBits extends ObjBase {
	
	private final int amount;
	private final String currency;
	private final String message;
	
	public ObjBits(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, int amount, String currency, String message) {
		super(event_id, acc, isTest, name, _id, priority);
		this.amount = amount;
		this.currency = currency;
		this.message = message;
	}


}
