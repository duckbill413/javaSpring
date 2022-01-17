package linkedList;

public interface LinkedList<T> {
	boolean add(T value);//����Ʈ�� ��� �߰�
	void add(int index, T value);//����Ʈ�� Ư�� ��ġ�� ��Ҹ� �߰�
	T remove(int index);//����Ʈ�� index ��Ҹ� ����
	boolean remove(Object value);//����Ʈ��  Ư�� ��Ҹ� ����
	T get(int index);//����Ʈ�� Ư�� ��ġ ��Ҹ� ��ȯ
	void set(int index, T value);//����Ʈ�� Ư�� ��ġ ��Ҹ� �� ��ҷ� ��ü
	boolean contains(Object value);//����Ʈ�� Ư�� ��Ұ� �ִ��� Ȯ��
	int indexOf(Object value);//Ư�� ����� index�� ��ȯ
	int size();//����Ʈ�� ũ�⸦ ��ȯ
	boolean isEmpty();//����Ʈ�� ����ִ��� ��ȯ
	public void clear();//����Ʈ�� ����	
}
