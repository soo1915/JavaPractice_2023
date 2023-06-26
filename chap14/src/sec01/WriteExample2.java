package sec01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample2 {

	public static void main(String[] args) throws Exception {

		Writer writer = new FileWriter("C:/Temp/test7.txt");
		
		char[] array = {'A', 'B', 'C'};
		writer.write(array);
		
//		char a = 'A';
//		char b = 'B';
//		char c = 'C';
//		
//		writer.write(a);
//		writer.write(b);
//		writer.write(c);
		
		writer.flush();
		writer.close();
	}

}
