package org.golde.streamingapi.api.streamlabs;

import org.golde.streamingapi.api.IThreadSocketAbstractListener;
import org.golde.streamingapi.api.streamlabs.obj.ObjBits;
import org.golde.streamingapi.api.streamlabs.obj.ObjCloudBot;
import org.golde.streamingapi.api.streamlabs.obj.ObjDonation;
import org.golde.streamingapi.api.streamlabs.obj.ObjFollow;
import org.golde.streamingapi.api.streamlabs.obj.ObjHost;
import org.golde.streamingapi.api.streamlabs.obj.ObjMerch;
import org.golde.streamingapi.api.streamlabs.obj.ObjRaids;
import org.golde.streamingapi.api.streamlabs.obj.ObjResub;
import org.golde.streamingapi.api.streamlabs.obj.ObjSubscription;
import org.json.JSONObject;

public interface IThreadSocketStreamLabsListener extends IThreadSocketAbstractListener {

	public default void onRawEvent(JSONObject obj) {};
	public default void onFollow(ObjFollow obj) {};
	public default void onSubscription(ObjSubscription obj) {};
	public default void onResub(ObjResub obj) {};
	public default void onDonation(ObjDonation obj) {};
	public default void onHost(ObjHost obj) {};
	public default void onBits(ObjBits obj) {};
	public default void onRaid(ObjRaids obj) {};
	public default void onMerch(ObjMerch obj) {};
	public default void onCloudbotRedemption(ObjCloudBot obj) {};
}
