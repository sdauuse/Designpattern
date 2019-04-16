package Observer_Pattern;
import java.util.*;
//��ĳ����������ս��Ϸ�У������ҿ��Լ���ͬһս��������ˣ���ս���е�ĳһ��Ա�ܵ����˹���ʱ���������������ѷ���֪ͨ��
//�����յ�֪ͨ��������Ӧ,ʹ�ù۲���ģʽ��Ʋ�ʵ�ָù��̣���ʵ��ս�ӳ�Ա֮���������
public class Observer_Pattern_Test_2 {
	public static void main(String args[]) {
		AllyControlCenter acc;
		acc=new ConcreteAllyControlCenter("��ӹȺ��");
		Observer_ player1,player2,player3,player4;
		
		player1=new Player("���");
		player2=new Player("���޼�");
		player3=new Player("�Ƿ�");
		player4=new Player("����");
		acc.join(player1);
		acc.join(player2);
		acc.join(player3);
		acc.join(player4);
		acc.notifyObserver(player1.getName());
	}
}
abstract class AllyControlCenter{
	protected String allName;//ս������
	protected ArrayList<Observer_> players=new ArrayList<Observer_>();//����һ���������ڴ洢ս�ӳ�Ա

	public ArrayList<Observer_> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Observer_> players) {
		this.players = players;
	}
	
	public void join(Observer_ obs) {
		System.out.println(obs.getName()+"����"+this.allName+"ս��");
		players.add(obs);
	}
	public void quit(Observer_ obs) {
		System.out.println(obs.getName()+"�˳�"+this.allName+"ս��");
		players.remove(obs);
	}
	public abstract void notifyObserver(String name);
}
class ConcreteAllyControlCenter extends AllyControlCenter{
	public ConcreteAllyControlCenter(String allName) {
		System.out.println(allName+"ս�Ӵ����ɹ�");
		System.out.println("--------------------------------------");
		this.allName=allName;
	}
	public void notifyObserver(String name) {
		System.out.println(this.allName+"ս�ӽ���֪ͨ������"+name+"�⵽���˹���");
		//�����۲��߼��ϣ�����ÿһ�����ѣ��Լ����⣩��֧Ԯ����
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
	public void help();//����֧Ԯ���ѷ���
	public void beAttacked(AllyControlCenter acc);//�����⵽��������
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
	//֧Ԯ���ѷ�����ʵ��
	public void help() {
		System.out.println("���ס,"+this.name+"������");
	}
	//���ܹ���������ʵ�֣������ܹ���ʱ������ս�ӿ����������֪ͨ����notifyObserver()��֪ͨ����
	public void beAttacked(AllyControlCenter acc) {
		System.out.println(this.name+"������");
		acc.notifyObserver(name);
	}
}
