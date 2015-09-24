
public class StackApp {
	public static void main(String[] args) {
		StackX theStack  = new StackX(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		theStack.push(60);
		
		while(!theStack.isEmpty()){
			long value = theStack.pop();
			System.out.print(value + " ");
		}
		
		System.out.println();
		System.out.println("theStack.isEmpty = " + theStack.isEmpty());
		
		if(!theStack.isEmpty()) theStack.push(1);
		if(!theStack.isEmpty()) theStack.push(2);
		if(!theStack.isEmpty()) theStack.push(3);
		if(!theStack.isEmpty()) theStack.push(4);
		if(!theStack.isEmpty()) theStack.push(5);
		if(!theStack.isEmpty()) theStack.push(6);
		if(!theStack.isEmpty()) theStack.push(7);
		
		System.out.println("theStack.isEmpty = " + theStack.isEmpty());
		while(!theStack.isEmpty()){
			long value = theStack.pop();
			System.out.print(value + " ");
		}
		
		System.out.println();

		
		
	}
}
