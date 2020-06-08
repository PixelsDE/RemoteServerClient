package de.byPixels.RemoteClient.utils;

import de.byPixels.RemoteClient.client.Client;
import de.byPixels.RemoteClient.gui.GUI;

public class Utils {

	
	private static GUI gui = null;

	private static Client client = null;

	public static Client getClient() {
		return client;
	}

	public static void setClient(Client client) {
		Utils.client = client;
	}

	public static GUI getGui() {
	return gui;
}

public static void setGui(GUI gui) {
	Utils.gui = gui;
}
}
