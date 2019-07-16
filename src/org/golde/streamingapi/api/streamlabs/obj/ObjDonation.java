package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjDonation extends ObjBase {

	private final int amount;
	private final String currency;
	private final String from;
	private final String to;
	private final String message;
	private final String formatted_amount;
	private final int from_user_id;
	
	public ObjDonation(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, int amount, String currency, String from, String to, String message, String formatted_amount, int from_user_id) {
		super(event_id, acc, isTest, name, _id, priority);
		this.amount = amount;
		this.currency = currency;
		this.from = from;
		this.to = to;
		this.message = message;
		this.formatted_amount = formatted_amount;
		this.from_user_id = from_user_id;
	}

}
