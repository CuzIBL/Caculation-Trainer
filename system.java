package homework_1;

import java.util.Scanner;

public class system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length;
		int correct=0;
		int incorrect=0;
		Device device;
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入算式长度（运算数个数）：");
		length=reader.nextInt();
		for(int i=0;i<10;i++){
			device=new Device(length);
			if(device.judge()){
				System.out.println("完全正确！");
				correct++;
			}else{
				System.out.println("计算错误！");
				incorrect++;
			}
		}
		System.out.println("正确数： "+correct+" 错误数： "+incorrect);
	}

}
