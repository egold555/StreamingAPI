# StreamingAPI

This is a **WIP** project. **It is not fully ready for people to use yet!** Use at your own risk.

## Supported Serives:
  * StreamLabs (Twitch Donations)

## Services TODO:
  * Streamlabs (Youtube Donations)
  * Twitch Chat
  * Youtube CHat
  * StreamElements
  * Mixer
  
  
## How To Use
### StreamLabs (Twitch Donations)
```java

/*
This is subject to change. Worked as of 7/15/2019.
This WILL break in future versions.
TODO: Update Github with new API
*/

//Imports
import java.util.logging.Logger;

import org.golde.streamingapi.api.streamlabs.IThreadSocketStreamLabsListener;
import org.golde.streamingapi.api.streamlabs.ThreadSocketStreamLabs;
import org.json.JSONObject;

//Code
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
  if (canReconnect) {
   logger.info("Reconnecting to " + socketType + " (#" + reconnectionAttempt + ")");
  } else {
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

```
