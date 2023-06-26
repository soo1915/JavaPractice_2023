package sec01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample3 {

	public static void main(String[] args) throws Exception {

		Reader reader = new FileReader("C:/Temp/test7.txt");
		
		char[] buffer = new char[100];
		while(true) {
			int readCharNum = reader.read(buffer);
			System.out.println(readCharNum);
			if(readCharNum == -1) break;
			for(int i = 0; i < readCharNum; i++) {
				System.out.println(buffer[i]);
			}
		}
		
//		while(true) {
//			int data = reader.read();
//			if(data == -1) break;
//			System.out.println((char)data);
//			
//		}
		reader.close();
	}

}
