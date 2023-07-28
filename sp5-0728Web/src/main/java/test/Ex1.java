package test;

import java.util.Iterator;
import java.util.Properties;

public class Ex1 {

	public static void main(String[] args) {

		Properties prop = new Properties(); 
		prop.setProperty("key1", "값1");
		prop.setProperty("key2", "값2");
		prop.setProperty("key3", "값3");
//		String ss = prop.getProperty("key1");
//		System.out.println(ss);
		Iterator kit = prop.keySet().iterator();
		while(kit.hasNext()) {
			String com = (String) kit.next();
			String hcn = prop.getProperty(com);
			System.out.println(hcn);
		}
	}

}
