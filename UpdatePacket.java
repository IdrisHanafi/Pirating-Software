import java.util.StringTokenizer;

public class UpdatePacket
{

    String Packet, IP;
    int currPacket, totalPacket, count;
    public UpdatePacket(String Packet)
    {
        this.Packet = Packet;
    }

    public void deconstruct()
    {
        StringTokenizer tokenizer = new StringTokenizer(Packet);  //tokenizer

        String tempPacket = tokenizer.nextToken();                  //Header information
        IP = tokenizer.nextToken();                                 //
        currPacket = Integer.parseInt(tokenizer.nextToken());       //
        totalPacket = Integer.parseInt(tokenizer.nextToken());      //
        file[] file = new file[100];                                //

        while(tokenizer.hasMoreTokens()){                          //payload
            String Name = tokenizer.nextToken();                       //
            int Size = Integer.parseInt(tokenizer.nextToken()); 
            String IP = " ";       //
            file[count] = new file(Name, Size, IP);            
            System.out.println(file[count].toString());
            count++;
        }
    }
}
