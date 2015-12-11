import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
import java.net.*;

public class Exit
{
    public Exit()
    {
        try {
            String serverHostname = new String ("10.2.40.254");                 //Network Info
            InetAddress IPAddress = InetAddress.getByName(serverHostname);      //
            int UDPport = 54321; 

            String header = "EXIT\r";        
            byte[] packet = new byte[(header.getBytes()).length];
            packet = header.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(packet, packet.length, IPAddress, UDPport); 
            //SEND PACKET, WAIT FOR RESPONSE, PRINT        

        }catch (UnknownHostException ex) {System.err.println(ex);}
    }
}

