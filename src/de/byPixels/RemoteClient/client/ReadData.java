package de.byPixels.RemoteClient.client;

import de.byPixels.RemoteClient.utils.Crypter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadData extends Thread{
        Client client;

    public ReadData( Client client) {
        this.client = client;
    }

        @Override
        public void run() {
        while (!this.client.getClient().isClosed()) {
            try {
                final InputStream inputStream = this.client.getClient().getInputStream();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String data = null;
                while (!this.client.getClient().isClosed() && (data = reader.readLine()) != null) {
                    this.client.readData(Crypter.decode(data));
                }
            }
            catch (Exception e) {
                System.out.println("ERROR #4");
                try {
                    this.client.getClient().close();
                    this.stop();
                }
                catch (Exception error) {
                    System.out.println("ERROR #5");
                }
            }
        }
    }
    }
