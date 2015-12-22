
public class Node {

	Node rowNext;
	Node colNext;
	Integer data;
	

	
	
	public void setRowData(Integer data) {
		this.data = data;
	}
	
	public Integer getRowData() {
		return data;
	}
	
	public void setRowNext(Node rowNext) {
		this.rowNext = rowNext;
	}
	
	public Node getRowNext() {
		return rowNext;
	}
	
	public void setColData(Integer data) {
		this.data = data;
	}
	
	public Integer getColData() {
		return data;
	}
	
	public void setColNext(Node colNext) {
		this.colNext = colNext;
	}
	
	public Node getColNext() {
		return colNext;
	}
	
	
	

}


