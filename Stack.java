package homework_1;

public class Stack {
	private Element[] item;;
	int pointer;
	public  Stack (){
		pointer=0;
		item=new Element[100];
	}
	public void push(Element a){
		item[pointer]=a;
		pointer++;
	}
	public void pop(){
		pointer--;
	}
	public Element get(){
		return item[pointer-1];
	}
	public boolean empty(){
		if(pointer==0) return true;
		else return false;
	}
	
}
