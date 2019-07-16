package org.golde.streamingapi.api.streamlabs;

import org.golde.streamingapi.api.IThreadSocketAbstractListener;
import org.json.JSONObject;

public interface IThreadSocketStreamLabsListener extends IThreadSocketAbstractListener {

	public default void onRawEvent(JSONObject obj) {};
	public default void onFollow() {};
	public default void onSubscription() {};
	public default void onResub() {};
	public default void onDonation() {};
	public default void onHost() {};
	public default void onBits() {};
	public default void onRaid() {};
	public default void onMerch() {};
	public default void onCloudbotRedemption() {};
}
