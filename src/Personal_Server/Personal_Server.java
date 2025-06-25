package Personal_Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Personal_Server {

    public static void main(String[] args) throws IOException , ClassNotFoundException {

        // Port number
        int serverPort = 600;

        GUI_Personal_Server show= new GUI_Personal_Server();
        
        // Variables
        ServerSocket serverSocket = new ServerSocket(serverPort);
        String date;
        String time;
        double Temperture;
        double HeartRate;
        double OxygenLevel;

        while (true) {

            // Waiting for incoming connection request
            System.out.println("Waiting for client on port number " + serverPort + "...");
            Socket socket = serverSocket.accept();

            // Create an input stream to recieve objects from the client
            ObjectInputStream objFromClient = new ObjectInputStream(socket.getInputStream());

            String[] sensorsData;

            System.out.println("Connected...");

            // While loop to send and receive data and messages
            while (true) {

                // Variable to indicate whether an object has been sent or not
                int sendAlert = 0;

                // Message to sent to the server
                String msg = "";
                String displayMsg = "";

                // Get object from Sensorclient
                sensorsData = (String[]) objFromClient.readObject();

                // If Sensorclient sent a null object then end the connection
                if (sensorsData == null) {
                    break;
                }

                // Fill the variables with the values coming from the object
                date = sensorsData[0];
                time = sensorsData[1];
                Temperture = Double.parseDouble(sensorsData[2]);
                HeartRate = Double.parseDouble(sensorsData[3]);
                OxygenLevel = Double.parseDouble(sensorsData[4]);

                // If temperature is higher than the normal rate, send data to the medical server
                if (Temperture > 38) {
                    System.out.println("At date: " + date + ",time " + time + ", Temperature is high " + Temperture);
                    System.out.println("An alert massage is sent to the Medical Server");
                    displayMsg = "At date: " + date + ",time " + time + ", Temperature is high " + Temperture + "\n";
                    msg += displayMsg;
                    show.tempToString(displayMsg);
                    show.setVisible(true);
                    sendAlert = 1;
                } else {
                    System.out.println("At date: " + date + ",time " + time + ", Temperature is normal");
                    displayMsg = "At date: " + date + ",time " + time + ", Temperature is normal\n";
                    msg += displayMsg;
                    show.tempToString(displayMsg);
                    show.setVisible(true);
                }

                // If heart rate is greater than the normal rate, send data to the medical server
                if (HeartRate > 100) {
                    System.out.println("At date: " + date + ",time " + time + ", Heart rate is above normal  " + HeartRate);
                    System.out.println("An alert massage is sent to the Medical Server");
                    displayMsg = "At date: " + date + ",time " + time + ", Heart rate is above normal  " + HeartRate + "\n";
                    msg += displayMsg;
                    show.heartToString(displayMsg);
                    show.setVisible(true);
                    sendAlert = 1;
                    
                // If heart rate is lower than the normal rate, send data to the medical server
                } else if (HeartRate < 60) {
                    System.out.println("At date: " + date + ",time " + time + ", Heart rate is below normal " + HeartRate);
                    System.out.println("An alert massage is sent to the Medical Server");
                    displayMsg = "At date: " + date + ",time " + time + ", Heart rate is below normal  " + HeartRate + "\n";
                    msg += displayMsg;
                    show.heartToString(displayMsg);
                    show.setVisible(true);
                    sendAlert = 1;
                    
                } else {
                    System.out.println("At date: " + date + ",time " + time + ", Heart rate is normal");
                    displayMsg = "At date: " + date + ",time " + time + ", Heart rate is normal\n";
                    msg += displayMsg;
                    show.heartToString(displayMsg);
                    show.setVisible(true);

                }

                // If oxygen level is low, send data to the medical server
                // Note : if the object(information like date,time,Oxygenlevel,...) never send to medical  ==>sendAlert=0 then send object send to medical srver sendAlert change to 1
                if (OxygenLevel < 95) {
                    System.out.println("At date: " + date + ",time " + time + ", Oxygen saturation is low " + OxygenLevel);
                    System.out.println("An alert massage is sent to the Medical Server");
                    displayMsg = "At date: " + date + ",time " + time + ", Oxygen saturation is low " + OxygenLevel + "\n";
                    msg += displayMsg;
                    show.oxToString(displayMsg);
                    show.setVisible(true);
                    sendAlert = 1;
                    
                } else {
                    System.out.println("At date: " + date + ",time " + time + ", Oxygen is normal");
                    displayMsg = "At date: " + date + ",time " + time + ", Oxygen is normal\n";
                    msg += displayMsg;
                    show.heartToString(displayMsg);
                    show.setVisible(true);
                }

                System.out.println("");

                if (sendAlert == 1) {
                    
                    // Server configuration for local testing (i.e., client and server on the same machine).
                    // Comment out the following two lines if running the client and server on different machines:
                    int medicalServerPort = 800;
                    String medicalServerName = "localhost";

                    // Server configuration for remote execution (i.e., client and server on different machines):
                    // Replace "IP Address here.." with the actual IP address of the server.
                    // Make sure the firewall allows incoming connections on the specified port (800).
                    /*
                    int medicalServerPort = 800;
                    InetAddress address = InetAddress.getByName("IP Address here..");
                    String medicalServerName = address.getHostName();
                    */

                    try{
                        // Create socket, to connet to the Medical Server
                        Socket medicalSocket = new Socket(medicalServerName, medicalServerPort);

                        // Create an output stream to send objects to the Mediaclserver
                        ObjectOutputStream obgToSend = new ObjectOutputStream(medicalSocket.getOutputStream());

                        // Create a buffered writer to send messages to the Mediaclserver
                        BufferedWriter msgToSend = new BufferedWriter(new OutputStreamWriter(medicalSocket.getOutputStream()));

                        obgToSend.writeObject(sensorsData);
                        msgToSend.write(msg);
                        msgToSend.flush();
                        medicalSocket.close();
                    } catch (IOException e){
                        System.err.println("Connection failed to " + medicalServerName + ":" + medicalServerPort);
                        e.printStackTrace();
                    }
                }
            }
            
            System.out.println("Connection ends...\n\n");
            socket.close();
            serverSocket.close();
        }
    }
}