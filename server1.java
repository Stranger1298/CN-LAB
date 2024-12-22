import java.net.*;
import java.io.*;
public class server1
{    public static void main(String args[]) throws Exception
    {   
        // establishing the connection with the server
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server ready for connection");

        Socket sock = sersock.accept(); // binding with port: 4000
        System.out.println("Connection is successful");

        // reading the file name from client
        InputStream istream = sock.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(istream));
        String fname = br.readLine();

        // reading file contents
        BufferedReader contentRead = new BufferedReader(new FileReader(fname));

        // keeping output stream ready to send the contents
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        String str;
        
        while ((str = contentRead.readLine()) != null) // reading line-by-line from file
        {
            pwrite.println(str); // sending each line to client
        }
        sock.close(); sersock.close(); // closing network sockets
        pwrite.close(); br.close(); contentRead.close();
    }
}