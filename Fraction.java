package homework_1;

public class Fraction extends Element{
	int upN;
	int downN;
	String sym="Fraction";
	
	public Fraction(int up, int down){
		if(down!=0){
			upN=up;
			downN=down;
		}
	}
	
	public Fraction add(Fraction a){
		return new Fraction(upN*a.downN+downN*a.upN,downN*a.downN);
	}
	public Fraction sub(Fraction a){
		return new Fraction(upN*a.downN-downN*a.upN,downN*a.downN);
	}
	public Fraction multi(Fraction a){
		return new Fraction (upN*a.upN,downN*a.downN);
	}
	public Fraction div(Fraction a){
		return new Fraction (upN*a.downN,downN*a.upN);
	}
	
	public void simplify(){
		int m=upN;
		int n=downN;
		
		while (m % n != 0) {   

            int temp = m % n;   

            m = n;   

            n = temp;   

        }
		upN/=n;
		downN/=n;
	}
	
	public void display(){
		if(downN==upN){
			System.out.print("1");
		}
		else if(downN==1){
			System.out.print(upN);
		}
		else System.out.print(upN+"/"+downN);
	}
	
	public boolean equal(Fraction a){
		if(a.downN==downN&&a.upN==upN){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String getSym() {
		// TODO Auto-generated method stub
		return sym;
	}
	
}
