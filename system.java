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
		System.out.println("��������ʽ���ȣ���������������");
		length=reader.nextInt();
		for(int i=0;i<10;i++){
			device=new Device(length);
			if(device.judge()){
				System.out.println("��ȫ��ȷ��");
				correct++;
			}else{
				System.out.println("�������");
				incorrect++;
			}
		}
		System.out.println("��ȷ���� "+correct+" �������� "+incorrect);
	}

}
