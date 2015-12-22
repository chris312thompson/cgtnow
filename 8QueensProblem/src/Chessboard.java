
public class Chessboard {
	
	Node[] rowHead = new Node[8];
	Node[] colHead= new Node[8];
	int numQueens;
	
	
	
	public Chessboard() {
		
		Node nodeA = new Node();
		Node nodeB = new Node();
		
		for (int j = 0; j < 8; j++)
			for (int i = 0; i < 8; i++){
				nodeA.setRowData(0);
				nodeB.setColData(0);
				rowHead[i] = nodeA;
				colHead[i] = nodeB;
				//rowHead[i].g
				
			}
	
	}
	
	public void start(){
		solve(0);
	}
	
	public boolean solve(int i) {
		if (numQueens == 8){
			System.out.println("Done");
			this.printBoard();
			return true;
		}
		else {
			for (int j = 0; j < 8; j++) {
				 for (int k = 0; k < 8; k++) {
					 if (validMove(j, k) == 0) {
						 this.placeQueen(j, k, 0);
						 numQueens++;
						 if (solve(numQueens)) {
							 return true;
						 }
						 else {
							 this.placeQueen(j, k, 1);
							 numQueens--;
						 }
					 }
				 }
			}
		}
		return false;
	}
	
		public boolean push(Integer x, Integer y) {
			
		Node nodeA = new Node(); 
		nodeA.setRowData(x);
		nodeA.setRowNext(rowHead[numQueens]);
		
		Node nodeB = new Node(); 
		nodeB.setColData(y);
		nodeB.setColNext(colHead[numQueens]);
		
		numQueens++;
		
		return false;
		}		
		
		public Integer pop() {
			if (stackEmpty()) {
				return null;
			}
			
			Node node = rowHead[numQueens];
			rowHead[numQueens] = rowHead[numQueens].getRowNext();
			numQueens--;
			return node.getRowData();
		}
			
		
	public boolean stackEmpty() {
		return numQueens == 0;
	}
	
	public Integer stackTop() {
		if(stackEmpty()) {
			return null;
		}
		
		return rowHead[numQueens].getRowData();
	}
	
	public  Integer getIndex(Integer x, Integer y) {
		if( x < 1 || y < 1 || x > 8 || y > 8) {
			System.out.println("Not valid!");
			return -1;
		}
		Node node = new Node();
		for (int j = 0; j < y; j++) {
			for (int i = 0; i <= x; i++) {
				node = rowHead[i].rowNext;
				if (i == x) {
					return rowHead[i].getRowData();
				}
				else if (j == y) {
					return colHead[j].getColData();
				}
			}	
			
		}
		return node.getRowData();
		
	}
	
	
	
	

	
	public Integer validMove(int x, int y) {
		
		for (int j = 0; j < 8; j++) {
			if (getIndex(j,x) == 1){
				return -1;
			}
			
			if (getIndex(j, y) == 1) {
				return -1;
			}
		}
		return 0;
	}
	
	public Integer placeQueen(Integer x, Integer y, int type) {
		Node node = new Node();
		if (type == 0 ) {
			node.setRowData(1);
			rowHead[x] = node;
			numQueens++;
			return 0;
		}
		else if (type == 1) {
			node.setRowData(0);
			return 0;
		}
		return -3;
	}

	public void printBoard(){
		
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				System.out.print(rowHead[i].getRowData() + " ");
			}
			System.out.println("");
		}
	}
	
	public int getNumQueens() {
		return numQueens;
	}
 	
	
	public static void main(String[] args) {
		Chessboard board = new Chessboard();
		board.start();
	}
}
