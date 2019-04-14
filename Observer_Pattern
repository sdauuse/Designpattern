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
	//定义一个观察者集合用于存储所有观察者对象
	protected ArrayList<Observer> observers=new ArrayList<Observer>();
	
	//注册方法，用于向观察者集合中增加一个观察者
	public void Attach(Observer observer) {
		observers.add(observer);
	}
	//注销方法，用于向观察者集合删除一个观察者
	public void DeAttach(Observer observer) {
		observers.remove(observer);
	}
	//声明抽象通知方法
	public abstract void Notify();
}
class ConreteSubject extends Subject{
	//实现通知方法
	public void Notify() {
		//遍历观察者集合,调用每一个观察者的响应方法
		for(Observer obs:observers) {
			obs.update();
		}
	}
}
interface Observer{
	public void update();
}
class ConreteObserver implements Observer{
	//实现响应方法
	public void update() {
		//具体响应方法
	}
}
