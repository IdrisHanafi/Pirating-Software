import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
import java.net.*;

public class Query
{
    public void Query(String fileName)
    {
        try {
            String serverHostname = new String ("10.2.40.254");                 //Network Info
            InetAddress IPAddress = InetAddress.getByName(serverHostname);      //
            int UDPport = 54321; 

            String Packet = "QUERY\r" + fileName;        
            byte[] packet = new byte[(Packet.getBytes()).length];
            packet = Packet.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(packet, packet.length, IPAddress, UDPport); 
            //SEND PACKET, WAIT FOR RESPONSE, PRINT

        }catch (UnknownHostException ex) {System.err.println(ex);}
    }
}
