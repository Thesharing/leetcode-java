import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException { 
    	StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    	in.nextToken();
    	int res = (int)in.nval;
    	// ...
    	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    	out.println(res);
    	out.flush();
    }
}