package bank;


//מחלקה שבה כל חשבון זוכר את כל ההיסטוריה שלו
public class ProAccount extends Account{
    private int [] arrHistory;

	//Account בנאי זהה לשל 
	public ProAccount(String name) {
		super(name); //קריאה לבנאי של מחלקת העל חשבון
		arrHistory=new int[0]; //איתחול מערך שישמור היסטוריה
		}
	//אבל גם זוכרת את כמות השקלים לאחר הפעולה Accountמתודה שפועלת כמו ב
	@Override
    public void add(int amount) {
		  int len=arrHistory.length; //שמירת אורך המערך
		  int [] newArr=new int[len+1]; //יצירת מערך חדש על מנת להוסיף ערך חדש להיסטוריה
		  for (int i=0;i<len;i++) { //העתקת המערך הישן למערך החדש הגדול ב1
			  newArr[i]=arrHistory[i];}
		  arrHistory=newArr;
		  super.add(amount); //קוראת למתודה במחלקת העל ומוסיפה שקלים לחשבון 
		  arrHistory[len]=getShekels(); //מוסיפה במקום האחרון במערך החדש את מספר השקלים בחשבון  
		  
	   }
	//מחזירה את שם החשבון וכמה שקלים יש בו, ובנוסף את היסטורית החשבון 
    @Override
    public String toString() {
    	String res=super.toString()+" [";
    	for(int i=0;i<arrHistory.length-1;i++) {
    		res+=(arrHistory[i]+",");
    	}
    	res+=(arrHistory[arrHistory.length-1]+"]");
    	return res;
    }
    // שיטה סטטית המעבירה כמות שקלים מחשבון לחשבון בהתאם לפרמטרים שנשלחו למתודה 
    public static void transfer(ProAccount from, ProAccount to, int amount) {
    	from.add(-1*amount);//מחסירה מהחשבון שמעביר את כמות השקלים שהעביר
    	to.add(amount); //מוסיפה את כמות השקלים שהועבר לחשבון
    }


}
