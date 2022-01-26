package ch01;

class OutClass{
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;

	public OutClass() {
		inClass = new InClass();
	}
	class InClass{
		int inNum = 100;

		void inTest() {
			System.out.println("OutClass num = " + num + "(�ܺ� Ŭ������ �ν��Ͻ� ����)");
			System.out.println("OutClass snum = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����");
			System.out.println("InClass inNum = " + inNum + "(���� Ŭ������ �ν��Ͻ� ����");
		}
	}

	public void usingClass() {
		inClass.inTest();
	}

	static class InStaticClass{
		int inNum = 100;
		static int sInNum = 200;

		void inTest() {
			System.out.println("InClass num = " + inNum + "(���� Ŭ������ �ν��Ͻ� ����)");//�ܺ� Ŭ������ �ν��Ͻ� ������ ��� �Ұ�
			System.out.println("InClass inNum = " + sInNum + "(���� Ŭ������ ����ƽ ����");
			System.out.println("OutClass snum = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����");
		}

		static void sTest()//�ܺ� Ŭ������ ������ ������ ��� ������ �� �־�� ��
		{
			//			System.out.println("InClass num = " + inNum + "(���� Ŭ������ �ν��Ͻ� ����)");//static �϶� �ν��Ͻ� ���� ��� �Ұ�
			System.out.println("InClass inNum = " + sInNum + "(���� Ŭ������ ����ƽ ����");
			System.out.println("OutClass snum = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����");

		}
	}
}
public class InnerTest {
	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		outClass.usingClass();

		System.out.println();
		//OutClass.InClass iinner = new OutClass.InClass(); <- ��� �Ұ�
		OutClass.InClass inner = outClass.new InClass();//���� Ŭ������ private�� �ƴ� ��� ����
		inner.inTest();

		System.out.println();
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();

		System.out.println();
		OutClass.InStaticClass.sTest();
	}

}