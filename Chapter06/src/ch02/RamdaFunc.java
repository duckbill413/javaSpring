package ch02;

public class RamdaFunc {
	public static void main(String[]args) {
		Add add = (x, y)->{return x+y;}; // ���ٽ� ǥ��
		System.out.println(add.add(2,  3));
		add = (x, y)->x+y;
		System.out.println(add.add(5,  8)); // �߰�ȣ�� ���� ���� (������ �������� �ʰ� �߰�ȣ ���� �Ұ�)
	}
}
