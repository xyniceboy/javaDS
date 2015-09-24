
public class PriorityQApp {
	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(2);
		thePQ.insert(57);
		thePQ.insert(12);
		
		while(!thePQ.isEmpty()){
			long item = thePQ.remove();
			System.out.print(item + " ");
		}
	}
}
