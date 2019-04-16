package Observer_Pattern;

import java.util.ArrayList;

public class Observer_Pattern_Test_1 {
	public static void main(String args[]) {
		Subject subject=new ConreteSubject();
		Observer observer=new ConreteObserver();
		subject.Attach(observer);
		subject.Notify();
	}
}
abstract class Subject{
	//����һ���۲��߼������ڴ洢���й۲��߶���
	protected ArrayList<Observer> observers=new ArrayList<Observer>();
	
	//ע�᷽����������۲��߼���������һ���۲���
	public void Attach(Observer observer) {
		observers.add(observer);
	}
	//ע��������������۲��߼���ɾ��һ���۲���
	public void DeAttach(Observer observer) {
		observers.remove(observer);
	}
	//��������֪ͨ����
	public abstract void Notify();
}
class ConreteSubject extends Subject{
	//ʵ��֪ͨ����
	public void Notify() {
		//�����۲��߼���,����ÿһ���۲��ߵ���Ӧ����
		for(Observer obs:observers) {
			obs.update();
		}
	}
}
interface Observer{
	public void update();
}
class ConreteObserver implements Observer{
	//ʵ����Ӧ����
	public void update() {
		//������Ӧ����
	}
}
