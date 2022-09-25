package javaTester;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cách khai báo 1 biến 
		// 1 - kiểu dữ liệu của biến
		// 2- tên biến
		// 3- giá trị của biến
		
		// 2 cách khai báo và gán giá trị
		// 1 - vừa khai báo vừa gán giá trị luôn:
		// String name = "Automation Testing";
		
		// 2 - khai báo trước rồi gán sau
		// String name;
		// name = "Automation Testing";
		
		
		// I - kiểu dữ liệu nguyên thủy (int/ long/ double (float)/ boolean)
		// Sô nguyên: byte/ short/ int / long (số mà không cần phần thập phân)
		byte bNumber = 5;
		
		short sNumber = 500;
		
		int iNumber = 6000;
		
		long lNumber = 123456789;
		
		
		
		
		// Sô thực: float/ double
		float salary = 15.5f;
		
		double point = 9.8d;	
		
		//Kí tự: char
		// Dấu nháy đơn ''
		// Chứa duy nhất 1 kí tự
		char a = 'a';
		
		//Logic: boolean
		boolean marriedStatus = true;
		marriedStatus = false;
		
		//II - Kiểu dữ liệu tham chiếu (Reference)
		// Chuỗi: String (Chữ/ số/ kí tự đăc biệt/...)
		// Dấu nháy đôi
		String emailInvalid = "afcfc@#$55.mail.com";
		
		// Class/ Interface (DateTime)
		Date date = new Date();
		
		WebDriver driver = new FirefoxDriver();
		
		// Đối tượng: Object 
		Object students;
		
		// Array: mảng (Khai báo số lượng dữ liệu trước) - Cố định số lượng
		int numbers[] = {15, 20, 45};
		String addresses [] = {"Da Nang", "Hoi An", "HCM"};
		
		// List/ Set/ Queue (Collection) - Động
		List<Integer> studentNumber = new ArrayList<Integer>();
		List<String> studentAddress = new ArrayList<String>();
		
		
		

	}

}
