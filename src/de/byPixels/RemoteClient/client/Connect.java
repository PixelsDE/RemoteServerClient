package de.byPixels.RemoteClient.client;

import de.byPixels.RemoteClient.utils.Utils;

import java.net.Socket;

public class Connect {


    public Connect( String adresse,  int port,  String username,  String password) {
		try {
			 Socket socket = new Socket(adresse, port);
			 Client client = new Client(socket, username, password);
			Utils.setClient(client);
		}
		catch (Exception e) {
			System.out.println("FEHLER #1");
		}
	}
	}
