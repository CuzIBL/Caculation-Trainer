package homework_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Device {//单次计算式生成与对错检验
	
	Fraction stdAns;
	Fraction Answer;//用户答案
	Element[] line=new Element[100];
	Element[] post=new Element[100];
	int length;
	int postLength;
	int i;
	
	public Device(int a){
		length=a;
	}
	public void getAnswer(int a ,int b){
		Answer=new Fraction (a,b);
	}
	
	public void Generate(){
		int a;
		int b;
		int c;
		Fraction tempFraction;
		Symbol tempSymbol;
		
		for(i=0;i<length;i++){
			a=(int)(1+Math.random()*(10));
			b=(int)(1+Math.random()*(10));
			tempFraction= new Fraction(a,b);
			tempFraction.simplify();
			line[2*i]=tempFraction;
			if(i<length-1){//Symbol +-*/
				c=(int)(1+Math.random()*(4));
				tempSymbol=new Symbol(c);
				line[2*i+1]=tempSymbol;
			}else{//Symbol =
				tempSymbol=new Symbol(5);
				line[2*i+1]=tempSymbol;
			}
		}
		for(int j=0;j<2*length;j++){
			line[j].display();
			System.out.print(" ");
		}
	}
	public void postFix(){//post数组用来存放后缀表达式，此方法先转后缀表达式
		int i;
		Element a;
		int postCount=0;
		Stack temp=new Stack();
		for(i=0;i<2*length-1;i++){
			a=line[i];
			if(a.getSym().compareTo("Fraction")==0){//如果扫描到一个数，则直接输出到post数组中
				
				post[postCount]=a;
				postCount++;
			}
			else{
				
				if(temp.empty()||Precedence(temp.get(),a)<0){
					temp.push(a);
				}
				else{
					
					while(!temp.empty()&&Precedence(temp.get(),a)>=0){
						post[postCount]=temp.get();
						postCount++;
						temp.pop();
					}
					temp.push(a);
				
				}
			}
			
		}
		while(!temp.empty()){
			post[postCount]=temp.get();
			postCount++;
			temp.pop();
		}
	    
		
		postLength=postCount;
	 
	}
	int Precedence(Element op1, Element op2)//若前比后高，则返回1，前比后底，返回-1，前后一致，返回0
	{
	    if (op1.sym.compareTo("(") == 0)
	    {
	        return -1;
	    }
	    
	    
	    
	    if (op1.getSym().compareTo("+") == 0 || op1.getSym().compareTo("-") == 0)
	    {
	        if (op2.getSym().compareTo("*") == 0 || op2.getSym().compareTo("/") == 0)
	        {
	            return -1;
	        }
	        else
	        {
	            return 0;
	        }
	    }

	    else if (op1.getSym().compareTo("*") == 0 || op1.getSym().compareTo("/") == 0)
	    {
	        if (op2.getSym().compareTo("+") == 0 || op2.getSym().compareTo("-") ==0 )
	        {
	            return 1;
	        }
	        else
	        {
	            return 0;
	        }
	    }
		return -2;
	}
	
	public Fraction caculate(){
		Stack temp = new Stack();
		int i;
		Element a;
		Fraction f1,f2,f3;
		Fraction result;
		for(i=0;i<postLength;i++){
			a=post[i];
			if(a.getSym().compareTo("Fraction")==0){
				temp.push(a);
			}
			else{
				f1=(Fraction)temp.get();
				temp.pop();
				f2=(Fraction)temp.get();
				temp.pop();
				if(a.getSym().compareTo("+")==0){
					f3=f2.add(f1);
					temp.push(f3);
				}
				else if(a.getSym().compareTo("-")==0){
					f3=f2.sub(f1);
					temp.push(f3);
				}
				else if(a.getSym().compareTo("*")==0){
					f3=f2.multi(f1);
					temp.push(f3);
				}
				else if(a.getSym().compareTo("/")==0){
					f3=f2.div(f1);
					temp.push(f3);
				}
			}
			
		}
		result=(Fraction)temp.get();
		result.simplify();
		return result;
	}

	@SuppressWarnings("resource")
	public boolean judge(){
		int up,down;
		
		Generate();
		postFix();
		Scanner reader=new Scanner(System.in);
		String ans=reader.nextLine();
		StringTokenizer st=new StringTokenizer(ans," /");
		up=Integer.parseInt(st.nextToken());
		if(st.hasMoreTokens()){
			down=Integer.parseInt(st.nextToken());
		}else{
			down=1;
		}
		Answer=new Fraction (up,down);
		stdAns=caculate();
		
		if(Answer.equal(stdAns)) return true;
		else return false;
	}
	public static void main(String argv[] ){
		Device device= new Device(2);
		System.out.println(device.judge());
	}
	
}
