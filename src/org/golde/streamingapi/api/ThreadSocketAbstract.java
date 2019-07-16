package org.golde.streamingapi.api;

import java.net.URISyntaxException;
import java.util.logging.Logger;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.client.IO.Options;

public abstract class ThreadSocketAbstract extends Thread {

	private final String socketToken;
	private int reconnectAttempt = 0;
	protected Socket socket = null;
	private final IThreadSocketAbstractListener listener;

	public ThreadSocketAbstract(IThreadSocketAbstractListener listener, String socketToken) {
		this.setName("ThreadSocketAbstract - " + this.getSocketType() + " Integration");
		this.setDaemon(true);
		this.socketToken = socketToken;
		this.listener = listener;
	}

	@Override
	public void run() {
		try {
			this.socket = this.createSocket();
			this.socket.connect();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public void killSocket() {
		if (this.socket != null) {
			this.socket.disconnect();
			this.socket = null;
		}

	}

	public boolean isOpen() {
		return this.socket != null && this.socket.connected();
	}

	protected void resetReconnects() {
		this.reconnectAttempt = 0;
	}

	protected boolean canReconnect() {
		++this.reconnectAttempt;
		return this.reconnectAttempt <= 3;
	}

	protected String getSocketToken() {
		return this.socketToken;
	}

	protected Socket getDefaultSocket() throws URISyntaxException {
		Socket socket = IO.socket(this.getSocketUrl(), this.getOptions());

		socket.on("connecting", (args) -> {
			
			listener.connecting(this.getSocketType(), args);

		}).on("connect_error", (args) -> {
			
			listener.connect_error(this.getSocketType(), args);

		}).on("connect", (args) -> {
			
			this.resetReconnects();

			listener.connected(this.getSocketType(), args);

		}).on("disconnect", (args) -> {

			listener.disconnect(this.getSocketType(),  args);


		}).on("reconnecting", (args) -> {
			if (this.canReconnect()) {
				
				listener.reconnecting(this.getSocketType(), args, true, this.reconnectAttempt);

			} else {
				listener.reconnecting(this.getSocketType(), args, false, this.reconnectAttempt);
				
				socket.disconnect();

			}

		}).on("reconnect_failed", (args) -> {
			
			listener.reconnect_failed(this.getSocketType(), args);

		});
		return socket;
	}

	protected Options getOptions() {
		return null;
	}

	public abstract String getSocketType();

	public abstract String getSocketUrl();

	public abstract Socket createSocket() throws URISyntaxException;

}
