package javaDS05_ClassDataArray;

public class ClassDataApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ClassDataArray arr = new ClassDataArray(maxSize);
		arr.insert("Evans", "Patty", 24);
		arr.insert("bin", "wang", 26);
		arr.insert("shu", "peng", 47);
		arr.insert("bingli", "li", 14);
		arr.insert("wei", "wei", 50);
		arr.insert("chuan", "he", 229);
		arr.insert("zhen", "ren", 44);
		arr.insert("lulu", "bian", 214);
		arr.insert("Yangyang", "du", 454);
		
		arr.display();  //ï@Ê¾”µ“ş
		String searchKey = "Evans";   //Œ¢ĞÕ×÷éêPæI×Ö
		Person found;
		found = arr.find(searchKey);
		if(found!=null){
			System.out.print("Found ");
			found.displayPerson();
		}else
			System.out.println("Cann't find "+searchKey);
		
		//„h³ı
		System.out.println("Delting Evans, bin and shu");
		arr.delete("Evans");
		arr.delete("bin");
		arr.delete("shu");
		arr.display();
		
	}
}
