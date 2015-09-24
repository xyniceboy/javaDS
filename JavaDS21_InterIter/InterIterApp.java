import java.io.*;

public class InterIterApp {
	public static void main(String[] args) throws IOException{
		LinkList theList = new LinkList();
		ListIterator iter1 = theList.getIterator();
		long value;  //利用这个值既可以从控制台输入，还可以从控制台输出
		iter1.insertAfter(20);
		iter1.insertAfter(40);
		iter1.insertAfter(60);
		iter1.insertBefore(10);
		iter1.insertBefore(30);
		iter1.insertBefore(50);
		
		//s: 显示链表内容
		//r: 重置 reset()
		//n：移动到下一个链节点
		//g：获取当前节点
		//b: 在当前节点前插入
		//a: 在当前节点之后插入
		//d: 删除当前节点
		while(true){
			System.out.println("Enter first letter of show,reset,next,get,before,after,delete: ");
			System.out.flush();
			int choice = getChar();
			switch(choice){
			case 's': 
				if(!theList.isEmpty())
					theList.displayList();
				else
					System.out.println("List is empty");
				break;
			case 'r':
				iter1.reset();
				break;
			case 'n':
				if(!theList.isEmpty() && !iter1.atEnd())
					iter1.nextLink();
				else 
					System.out.println("Cann't go to next link");
				break;
			case 'g':
				if(!theList.isEmpty()){
					value = iter1.getCurrent().dData;
					System.out.println("Returned: " + value);
				}else 
					System.out.println("List is empty");
				break;
			case 'b':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = getInt();     //用到了需要抛异常的方法，所以在大class main中也需要加上 IOExption
				iter1.insertBefore(value);
				break;
			case 'a':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = getInt();  
				iter1.insertAfter(value);
				break;
			case 'd':
				if(!theList.isEmpty()){
					value = iter1.deleteCurrent();
					System.out.println("Deleted: " + value);
				}else 
					System.out.println("Cann't delete");
				break;
				default:
					System.out.println("Invalid enter");
			}
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);  //将字符串 s 转换成 int
	}
}

/*测试过程
Enter first letter of show,reset,next,get,before,after,delete: 
show
20 40 50 30 10 60 
Enter first letter of show,reset,next,get,before,after,delete: 
r
Enter first letter of show,reset,next,get,before,after,delete: 
n
Enter first letter of show,reset,next,get,before,after,delete: 
n
Enter first letter of show,reset,next,get,before,after,delete: 
get
Returned: 50
Enter first letter of show,reset,next,get,before,after,delete: 
b
Enter value to insert: 100
Enter first letter of show,reset,next,get,before,after,delete: 
a
Enter value to insert: 7
Enter first letter of show,reset,next,get,before,after,delete: 
s
20 40 100 7 50 30 10 60 
Enter first letter of show,reset,next,get,before,after,delete: 
*/