import java.io.*; 
import java.net.*; 

public class UDPServer { 
    public static void main(String args[]) throws Exception { 
        try { 
            Socket clientSocket = null;
            ServerSocket serverSocket = new ServerSocket(54321);
            DatagramSocket serverSocketforData = new DatagramSocket(54321);
            
            byte[] receiveData = new byte[128]; 
            byte[] sendData  = new byte[128]; 
            int i = 0;
            while(true) { 
                System.out.println ("Waiting for datagram packet");
                clientSocket = serverSocket.accept();
                
                packetThread connection = new packetThread("Thread " + i, serverSocketforData);
                connection.start();
                i++;
            } 
        } catch (SocketException ex) {
            System.out.println("UDP Port 54321 is occupied.");
            System.exit(1);
        }
    } 

    static class packetThread implements Runnable {
        private Thread t;
        private String threadName;
        private byte[] receiveData; 
        private byte[] sendData; 
        private DatagramSocket serverSocket;

        packetThread(String name, DatagramSocket server) throws Exception {
            threadName = name;
            receiveData = new byte[128];
            sendData = new byte[128];
            serverSocket = server; 
            System.out.println("Creating " +  threadName );
        }

        public void run()  {
            System.out.println("Running " +  threadName );
            try {
                task();
            } catch (Exception e){
                System.out.println("exception lang");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

        public void task() throws Exception {
            boolean check = true;
            int sequenceNumber = 0;
            int i = 0;
            while(check) { 
                //System.out.println(i);
                //i++;
                receiveData = new byte[128]; 

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
                                
                serverSocket.receive(receivePacket); 
                System.out.println(receivePacket.getLength());
                if(receivePacket.getLength() == 0) {
                    check = false;
                }
                String sentence = new String(receivePacket.getData()); 
                InetAddress IPAddress = receivePacket.getAddress(); 
                int port = receivePacket.getPort(); 

                System.out.println ("From: " + IPAddress + ":" + port);
                System.out.println ("Message: " + sentence);

                sequenceNumber += receiveData.length;
                String capitalizedSentence = "ACK" + sequenceNumber; 
                sendData = capitalizedSentence.getBytes(); 
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
                serverSocket.send(sendPacket); 
            }  
            System.out.println("done");
        }

        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
}  