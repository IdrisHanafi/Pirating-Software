import java.io.*;

public class MP3breakdown
{
    int bCount = 0;
    byte[] bFile;
    //int fSize;
    public static void main(String[] args) {
        try{
            RandomAccessFile rFile = new RandomAccessFile("C:\\Users\\user\\Desktop\\MP3breakdown\\Maid with the Flaxen Hair.mp3", "rw");
            RandomAccessFile wFile = new RandomAccessFile("C:\\Users\\user\\Desktop\\MP3breakdown\\She got a nice weave.mp3", "rw");

            long fSize = rFile.length();
            int intSize = (int)fSize;
            //for( int i=0; i<fSize;i++){System.out.println(i);}
            
            byte[] bFile = new byte[intSize];
            rFile.readFully(bFile);
            wFile.write(bFile);
            System.out.println(intSize);
            System.out.println("\n\n" + bFile.length);
            System.out.println("\n\n" + bFile[0]);
            System.out.println("\n\n" + bFile[1]);
            System.out.println("\n\n" + bFile[2]);
            System.out.println("\n\n" + bFile[3]);
            rFile.close();
            wFile.close();
        }catch(Exception e){}
    }

}
