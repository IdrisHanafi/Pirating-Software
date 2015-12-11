
public class file
{
    String Name, IP;
    int Size;
    public file(String Name, int Size, String IP)
    {
        this.Name = Name;
        this.Size = Size;
        this.IP = IP;
    }

    public String toString()
    {
        String string = Name + " " + Size + " " + IP + " ";
        return string;
    }

    public byte[] toByteArray()
    {
        String string = Name + " " + Size + " " + IP + " ";
        byte[] bArr = new byte[(string.getBytes()).length]; 
        bArr = string.getBytes();
        return bArr;
    }
}