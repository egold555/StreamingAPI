package org.golde.streamingapi.api.streamlabs.obj;

import lombok.Getter;

@Getter
public class ObjCloudBot extends ObjBase {

	private final String product;
	private final String imageHref;
	private final String from;
	private final String to;
	private final String message;
	
	public ObjCloudBot(String event_id, AccountType acc, boolean isTest, String name, String _id, int priority, String product, String imageHref, String from, String to, String message) {
		super(event_id, acc, isTest, name, _id, priority);
		this.product = product;
		this.imageHref = imageHref;
		this.from = from;
		this.to = to;
		this.message = message;
	}

}
