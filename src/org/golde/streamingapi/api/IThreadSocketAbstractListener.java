package org.golde.streamingapi.api;

public interface IThreadSocketAbstractListener {

	public default void connecting(String socketType, Object[] args) {};
	
	public default void connect_error(String socketType, Object[] args) {};
	
	public default void connected(String socketType, Object[] args) {};
	
	public default void disconnect(String socketType, Object[] args) {};
	
	public default void reconnecting(String socketType, Object[] args, boolean canReconnect, int reconnectionAttempt) {};
	
	public default void reconnect_failed(String socketType, Object[] args) {};
}
