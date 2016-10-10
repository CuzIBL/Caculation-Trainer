package homework_1;

public class Symbol extends Element{
	 String sym;
	public Symbol(int i){
		if(i==1){
			sym="+" ;
		}
		else if(i==2){
			sym="-" ;
		}
		else if(i==3){
			sym="*" ;
		}
		else if(i==4){
			sym="/" ;
		}
		else if(i==5){
			sym="=" ;
		}else{
			sym="" ;
		}
	}
	public int get(){
		if(sym.compareTo("+")==0){
			return 1;
		}
		if(sym.compareTo("-")==0){
			return 2;
		}
		if(sym.compareTo("*")==0){
			return 3;
		}
		if(sym.compareTo("/")==0){
			return 4;
		}
		if(sym.compareTo("=")==0){
			return 5;
		}else{
			return -1;
		}
	}
	public String getSym(){
		return sym;
	}
	public void display(){
		System.out.print(sym);
	}
}
