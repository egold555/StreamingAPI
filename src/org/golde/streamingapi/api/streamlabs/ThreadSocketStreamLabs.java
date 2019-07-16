package org.golde.streamingapi.api.streamlabs;

import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.golde.streamingapi.api.ThreadSocketAbstract;
import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;

public class ThreadSocketStreamLabs extends ThreadSocketAbstract {

	private final IThreadSocketStreamLabsListener listener;
	
	public ThreadSocketStreamLabs(String socketToken, IThreadSocketStreamLabsListener listener) {
		super(listener, socketToken);
		this.listener = listener;
	}

	@Override
	public String getSocketType() {
		return "Streamlabs";
	}

	@Override
	public String getSocketUrl() {
		return "https://sockets.streamlabs.com?token=" + this.getSocketToken();
	}

	@Override
	public Socket createSocket() throws URISyntaxException {
		Socket socket = this.getDefaultSocket();

        socket.on("event", (args) -> {

            for (int j = 0; j < args.length; ++j) {
                JSONObject obj = (JSONObject)args[j];
                
                //listener
                listener.onRawEvent(obj);
               
                
                try {
                	 parseJsonObject(obj);
                }
                catch(JSONException e) {
                	e.printStackTrace();
                }
            }

        });
        return socket;
	}

	private void parseJsonObject(JSONObject obj) throws JSONException{
		String type = obj.getString("type");
		if(type.equalsIgnoreCase("follow")) {
			onFollow(obj);
		}
		else if(type.equalsIgnoreCase("subscription")) {
			onSubscription(obj);
		}
		else if(type.equalsIgnoreCase("resub")) {
			onResub(obj);
		}
		else if(type.equalsIgnoreCase("donation")) {
			onDonation(obj);
		}
		else if(type.equalsIgnoreCase("host")) {
			onHost(obj);
		}
		else if(type.equalsIgnoreCase("bits")) {
			onBits(obj);
		}
		else if(type.equalsIgnoreCase("raid")) {
			onRaid(obj);
		}
		else if(type.equalsIgnoreCase("merch")) {
			onMerch(obj);
		}
		else if(type.equalsIgnoreCase("loyalty_store_redemption")) {
			onCloudbotRedemption(obj);
		}
	}


	private void onFollow(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onSubscription(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onResub(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onDonation(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onHost(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onBits(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onRaid(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onMerch(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}


	private void onCloudbotRedemption(JSONObject obj) {
		// TODO Auto-generated method stub
		
	}
	
}
