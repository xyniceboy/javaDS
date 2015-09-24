//用递归实现汉诺塔问题

public class HanoiTower {
	static int nDisk = 3;
	public static void main(String[] args){
		doTowers(nDisk, 'A', 'B', 'C');
	}
	
	/*
	 * @param topN: the number of disks
	 * @param from
	 * @param inter
	 * @param to
	 */
	public static void doTowers(int topN, char from, char inter, char to){
		if(topN == 1)
			System.out.println("Disk 1 from " + from + " to " + to);
		else {
			doTowers(topN-1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN-1, inter, from, to);
		} 
			
	}
}
