package org.golde.streamingapi.api.streamlabs.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObjBase {

	private final String event_id;
	private final AccountType acc;
	private final boolean isTest;
	private final String name;
	private final String _id;
	private final int priority;
	
	
	public enum AccountType {
		TWITCH, STREAMLABS, UNKNOWN
	}
	
	public AccountType getAccountType() {
		return acc;
	}
	
}
