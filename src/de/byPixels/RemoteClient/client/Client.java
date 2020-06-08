package de.byPixels.RemoteClient.client;

import de.byPixels.RemoteClient.gui.Console;
import de.byPixels.RemoteClient.utils.Crypter;
import de.byPixels.RemoteClient.utils.Utils;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket client;
    private String username;
    private String password;
    private boolean isAuth;

    public Client(final Socket socket, final String username, final String password) {
        this.isAuth = false;
        this.client = socket;
        this.username = username;
        this.password = password;
        final Thread readData = new Thread(new ReadData(this));
        readData.start();
        auth();
    }


    public void auth() {
        sendData(Crypter.encrypt("#AUTH" + username + ";" + password));
    }

    public void sendData(String data) {
        data = Crypter.encrypt(data);
        if (!this.client.isClosed()) {
            try {
                OutputStream outputStream = client.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream);
                writer.write(data + "\n");
                writer.flush();
            } catch (Exception e) {
                System.out.println("ERROR #1");
            }
        } else {
            System.out.println("Client Connection -> Closed");
            JOptionPane.showMessageDialog(null, "Connection Closed", "ERROR", 0);
        }
    }


    public void readData(String data) {
        if (data.equalsIgnoreCase("#ALREADY")) {
            JOptionPane.showMessageDialog(null, "Already Connected!", "ERROR", 0);
        }
        if (data.equalsIgnoreCase("#FAIL")) {
            JOptionPane.showMessageDialog(null, "Auth Failed!", "ERROR", 0);
        }
        if (data.equalsIgnoreCase("#OK")) {
            this.setAuth(true);
            if (Utils.getGui() != null) {
                Utils.getGui().dispose();
            }
            Console console = new Console();
            
        }

        if (data.equalsIgnoreCase("#PERM")) {
            JOptionPane.showMessageDialog(null, "No Permissions!", "ERROR", 0);
        }
        if (data.equalsIgnoreCase("#ERROR")) {
            JOptionPane.showMessageDialog(null, "AN ERROR ACCURED!", "ERROR", 0);
        }
        if (data.equalsIgnoreCase("#CMD")) {
            JOptionPane.showMessageDialog(null, "Command not listed!", "ERROR", 0);
        }
        if (data.startsWith("#LOGIN")) {
             String[] splitter = data.replace("#LOGIN", "").split(";");
             String username = splitter[0];
             String permission = splitter[1];
             JOptionPane.showMessageDialog(null, "Wellcome " + username +"\nPermissions: " + permission, "Logged in!", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public Socket getClient() {
        return this.client;
    }

    public boolean isAuth() {
        return this.isAuth;
    }

    public void setAuth(final boolean auth) {
        this.isAuth = auth;
    }
}
