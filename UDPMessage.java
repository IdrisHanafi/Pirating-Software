import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

public class UDPMessage
{
    public UDPMessage(byte[] Packet)
    {

        String str = new String(Packet);
        StringTokenizer st = new StringTokenizer(str);
        
        String messageType = (st.nextToken()).toLowerCase();
        System.out.println(str);
        //if(messageType == "exit"){Exit(str);}
        //if(messageType == "update"){Update(str, }
        if(messageType == "query"){}
        if(messageType == "queryall"){}
        
        
    }
}
