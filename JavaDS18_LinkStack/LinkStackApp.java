
public class LinkStackApp {
	public static void main(String[] args) {
		LinkStack theStack = new LinkStack();
		
		//����ѹջ
		theStack.push(20);
		theStack.push(40);
		theStack.displayStack();
		theStack.push(60);
		theStack.push(80);
		theStack.displayStack();
		
		//���Գ�ջ
		theStack.pop();
		theStack.pop();
		theStack.displayStack();
	}
}
