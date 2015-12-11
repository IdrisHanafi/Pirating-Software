import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

public class QueryResponse
{
    String fileName, IP;
    int Port;
    public QueryResponse(String fileName, String IP, int Port)
    {
        
        this.fileName = fileName;
        this.IP = IP;
        this.Port = Port;
        try {
            Scanner scan = new Scanner(new File("C:\\Users\\user\\Desktop\\files.txt"));
            file[] file = new file[1000];
            int i=0;
            while(scan.hasNext()){
                String Name = scan.next();
                int Size = scan.nextInt();
                String fileIP = scan.next();
                if(fileName == Name){
                    file[i] = new file(Name, Size, IP);
                    file[i].toByteArray();
                    i++;
                }
            }
        } catch (FileNotFoundException ex) {}
    }
}
