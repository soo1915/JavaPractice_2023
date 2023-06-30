package sec03.ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStorage {

	private List<Product> productList = new ArrayList<Product>();
	//private List<Board> boardList = new ArrayList<Board>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
	
	public void showMenu() throws Exception {
		while(true)	{
			System.out.println("----------------------------------------------------------------");
			System.out.println("1. 등록 | 2. 내용보기 | 3. 수정하기 | 4. 삭제하기 | 5. 파일저장 | 6. 종료");
			System.out.println("----------------------------------------------------------------");
			
			System.out.print("선택 : ");
			String selectNo = scanner.nextLine();
			switch(selectNo) {
			case "1" : registerProduct(); break;
			case "2" : showProducts(); break;
			case "5" : writeProduct(); break;
			case "6" : return;
			}
		}
	}
	
	public void registerProduct() {
		try {
			Product product = new Product();
			product.setPno(++counter);
			
			System.out.print("상품명 : ");
			product.setName(scanner.nextLine());
			
			System.out.print("가격 : ");
			product.setPrice(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("재고 :");
			product.setStock(Integer.parseInt(scanner.nextLine()));
			
			productList.add(product);
		} catch(Exception e) {
			System.out.println("등록 에러 " + e.getMessage());
		}
	}
	
	public void showProducts() {
		System.out.println("번호\t상품명\t가격\t재고\t");
		for(Product p : productList) {
			System.out.println(p.getPno() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getStock());
		} 
	}
	
	public void writeProduct() throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/productstorage.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(productList);
		oos.flush();
		oos.close();
	}
}
