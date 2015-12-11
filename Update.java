import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
import java.net.*;
public class Update
{
    public static void main(String args[]) throws Exception
    {
        try {
            String serverHostname = new String ("10.8.237.206");                 //Network Info
            InetAddress IPAddress = InetAddress.getByName(serverHostname);      //
            int UDPport = 54321;                                                //
            int msgSize = 128;                                                  //max segment size

            DatagramSocket clientSocket = new DatagramSocket(); 
            //DECIDE WHETHER TO UPDATE FROM CONSOLE OR FILE

            String Update = "UPDATE ";                                          //update header

            String Packet = "KENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKKENDALL SUCKSENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSKENDALL SUCKSS";
            int length = (Packet.getBytes()).length;                            //length of message to be sent
            String strLength = Integer.toString(length) + "\r";
            byte[] sendData = new byte[length];                                 //byteArray to hold data
            sendData = Packet.getBytes();                                       //

            int offset;                                                         //packet offset
            int numPackets;                                                     //number of packets to be sent                                    

            if((sendData.length%msgSize)!=0){numPackets = ((length / msgSize) +1);}     //determines # of packets
            else{numPackets = (length / msgSize);}                                      //
            System.out.println("numPackets " + numPackets);
            System.out.println();
            System.out.println();
            System.out.println();
            Socket clientsSocket = new Socket(IPAddress, UDPport);
            for( int pktNum=0; pktNum<numPackets;pktNum++){
                offset = pktNum * msgSize;                                              //offset of each segment

                String Header = Update + Integer.toString(offset) + " " + strLength;    //builds header w/ type, offset, len of message
                byte[] header =new byte[(Header.getBytes()).length];                    //
                header = Header.getBytes();                                             //header string to bytearray

                byte[] sendPkt = new byte[header.length + 128];                         //sets length of packet

                for(int j=0; j<header.length;j++){ sendPkt[j] = header[j];}             //adds header to packet

                int index=0;        //index for while loop
                while(((pktNum*msgSize) + index)< length && index<msgSize){             //adds message(128 bytes) to packets
                    sendPkt[header.length + index] = sendData[(pktNum*msgSize) + index];
                    index++;
                }

                DatagramPacket sendPacket = new DatagramPacket(sendPkt, sendPkt.length, IPAddress, UDPport); 
                clientSocket.send(sendPacket); 

                //SEND PACKET, WAIT FOR RESPONSE, PRINT

                String str = new String(sendPkt);                               //FOR
                StringTokenizer st = new StringTokenizer(str, "\r");            //TESTING
                while(st.hasMoreTokens()){                                      //PURPOSES  

                    String print = st.nextToken();
                    System.out.println(print); 
                }
            }
            clientsSocket.close();
            clientSocket.close();
        }catch (UnknownHostException ex) {System.err.println(ex);}
    }
}
