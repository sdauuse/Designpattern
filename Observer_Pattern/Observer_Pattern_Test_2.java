package Observer_Pattern;
import java.util.*;
//在某多人联机对战游戏中，多个玩家可以加入同一战队组成联盟，当战队中的某一成员受到敌人攻击时将给所有其他盟友发送通知，
//盟友收到通知后将作出响应,使用观察者模式设计并实现该过程，以实现战队成员之间的联动。
public class Observer_Pattern_Test_2 {
	public static void main(String args[]) {
		AllyControlCenter acc;
		acc=new ConcreteAllyControlCenter("金庸群侠");
		Observer_ player1,player2,player3,player4;
		
		player1=new Player("杨过");
		player2=new Player("张无忌");
		player3=new Player("乔峰");
		player4=new Player("段誉");
		acc.join(player1);
		acc.join(player2);
		acc.join(player3);
		acc.join(player4);
		acc.notifyObserver(player1.getName());
	}
}
abstract class AllyControlCenter{
	protected String allName;//战队名称
	protected ArrayList<Observer_> players=new ArrayList<Observer_>();//定义一个集合用于存储战队成员

	public ArrayList<Observer_> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Observer_> players) {
		this.players = players;
	}
	
	public void join(Observer_ obs) {
		System.out.println(obs.getName()+"加入"+this.allName+"战队");
		players.add(obs);
	}
	public void quit(Observer_ obs) {
		System.out.println(obs.getName()+"退出"+this.allName+"战队");
		players.remove(obs);
	}
	public abstract void notifyObserver(String name);
}
class ConcreteAllyControlCenter extends AllyControlCenter{
	public ConcreteAllyControlCenter(String allName) {
		System.out.println(allName+"战队创建成功");
		System.out.println("--------------------------------------");
		this.allName=allName;
	}
	public void notifyObserver(String name) {
		System.out.println(this.allName+"战队紧急通知，盟友"+name+"遭到敌人攻击");
		//遍历观察者集合，调用每一个盟友（自己除外）的支援方法
		for(Object obs:players) {
			if(!((Observer_)obs).getName().equalsIgnoreCase(name)) {
				((Observer_) obs).help();
			}
		}
	}
}

interface Observer_{
	public String getName();
	public void setName(String name);
	public void help();//声明支援盟友方法
	public void beAttacked(AllyControlCenter acc);//声明遭到攻击方法
}
class Player implements Observer_{
	private String name;
	public Player(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//支援盟友方法的实现
	public void help() {
		System.out.println("坚持住,"+this.name+"来救你");
	}
	//遭受攻击方法的实现，当遭受攻击时将调用战队控制中心类的通知方法notifyObserver()来通知盟友
	public void beAttacked(AllyControlCenter acc) {
		System.out.println(this.name+"被攻击");
		acc.notifyObserver(name);
	}
}
