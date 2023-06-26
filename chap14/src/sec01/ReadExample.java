package sec01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("C:/Temp/test1.db");
		
		byte[] buffer = new byte[100];
		
		while(true) {
			int data = is.read(buffer);
			if(data == -1) break;
			for(int i = 0; i < data; i++) {
				System.out.println(buffer[i]);
			}
			
			//System.out.println(data);
			
		}
		is.close();
	}

}
