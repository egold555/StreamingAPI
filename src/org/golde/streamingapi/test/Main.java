package org.golde.streamingapi.test;

import java.util.logging.Logger;

import org.golde.streamingapi.api.streamlabs.IThreadSocketStreamLabsListener;
import org.golde.streamingapi.api.streamlabs.ThreadSocketStreamLabs;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("MyApp");

		ThreadSocketStreamLabs streamLabs = new ThreadSocketStreamLabs(PRIVATE_VARIABLES.STREAMLABS_API_KEY, new IThreadSocketStreamLabsListener() {

			@Override
			public void connecting(String socketType, Object[] args) {
				logger.info("Connecting to " + socketType);
			}

			@Override
			public void connect_error(String socketType, Object[] args) {
				logger.severe("Failed to connect to " + socketType);

				for (int j = 0; j < args.length; ++j) {
					Object arg = args[j];

					logger.severe("---" + arg);
					if (arg instanceof Exception) {
						((Exception) arg).printStackTrace();
					}
				}
			}

			@Override
			public void connected(String socketType, Object[] args) {
				logger.info("Connected to " + socketType);
			}

			@Override
			public void disconnect(String socketType, Object[] args) {
				logger.severe("Disconnected from " + socketType);

				for (int j = 0; j < args.length; ++j) {
					Object arg = args[j];

					logger.severe("---" + arg);
					if (arg instanceof Exception) {
						((Exception) arg).printStackTrace();
					}
				}
			}

			@Override
			public void reconnecting(String socketType, Object[] args, boolean canReconnect, int reconnectionAttempt) {
				if(canReconnect) {
					logger.info("Reconnecting to " + socketType + " (#" + reconnectionAttempt + ")");
				}
				else {
					logger.severe("Failed to reconnect to " + socketType + " after " + (reconnectionAttempt - 1) + " tries. Will stop attempting to reconnect.");
				}

			}

			@Override
			public void reconnect_failed(String socketType, Object[] args) {
				logger.info("Failed to reconnect to " + socketType);
			}
			
			@Override
			public void onRawEvent(JSONObject obj) {
				logger.info("Raw Event: " + obj.toString());
			}


		});


		streamLabs.start();

		//Mock multi threaded application
		//We just sleep endlessly and let the new thread do all the work
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
