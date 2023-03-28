package bank;

//מחלקה המתארת חשבון בנק פשוט
public class Account {
	private String name;
	private int shekels=0;
	
	//בנאי המאתחל את החשבון עם השם הנתון, ועם 0 שקלים בחשבון.
	public Account(String name) {
		this.name=name;
		this.shekels=0;
	}
	//מחזירה את מספר השקלים בחשבון.
	public int getShekels() {
		return shekels;
	} 
	//מחזירה את שם החשבון.
	public String getName() {
		return name;
	}
	//מתודה שמוסיפה שקלים לחשבון בהתאם לפרמטר שהמתודה מקבלת
	public void add(int amount) {
		shekels+=amount;
	}
	//מתודה שמחזירה את שם החשבון וכמה שקלים יש בו כרגע
	public String toString() {
		String res=name+" has "+shekels+" shekels";
		return res;
	}
	

}
