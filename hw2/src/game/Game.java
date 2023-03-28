package game;
import java.util.Scanner;
//מחלקת משחק ראשוני, הראשון שתופס את המיקום 0,0 מנצח
public class Game extends Board {
	protected Player[] players;//מערך השחקנים במשחק.
	protected Scanner s=new Scanner(System.in);//יאותחל לקרוא מהקלט הסטנדרטי.
	
	//מאתחל את הלוח לגודל הנתון וישמור את שני השחקנים.
	public Game(int n, int m, Player p1, Player p2) {
		super(n,m); //  קריאה לבנאי של מחלקת העל לוח
		players=new Player[2]; //יצירת מערך שחקנים בגודל 2
		players[0]=p1; //נוסיף במיקום הראשון במערך את השחקן הראשון
		players[1]=p2; //נוסיף במיקום השני במערך את השחקן השני
	}
	//המתודה תחזיר אמת, אחרת שקר i,j אם המהלך האחרון מנצח כשהמהלך היה במיקום 
	protected boolean doesWin(int i, int j) {
		if(get(i,j)==get(0,0)) {return true;} //זה השחקן שבמקום ה 0,0 i,j תנאי שבודק שהשחקן שהיה במקום ה
		return false;
		
	}
	//להכניס את המהלך שלו ותחזיר אמת אם זהו המהלך המנצח p תבקש מהשחקן 
	protected boolean onePlay(Player p) {
		int i,j;
		System.out.format("%s, please enter x and y:\n",p);
		i=s.nextInt(); //x את הערך של i נכניס למשתנה      
		j=s.nextInt();//y את הערך של j 
	 while(true) { //לולאה שרצה עד שיש תנאי שעוצר אותה
       // s.close();
		if (set(i,j,p)==true) { //תנאי שבודק אם המקום פנוי
			System.out.println(super.toString()); 
			if(doesWin(i, j)==true) {return true;} // תנאי שבודק אם המהלך ניצח ואם כן מחזיר אמת  
			else{return false;} // מחזיר שקר אם המהלך לא ניצח
		
		}
		System.out.println("There is a piece there already..."); //מדפיס אם המקום תפוס
		System.out.format("%s, please enter x and y:\n",p);
		i=s.nextInt(); //x את הערך של i נכניס למשתנה      
		j=s.nextInt();//y את הערך של j נכניס למשתנה


	 }		
	}
	//null תבקש משחקן אחד לשחק, אחרי זה שחקן שני, וחוזר חלילה. זה עד אחד השחקנים מנצח, ואת היא תחזיר אותו, או שהלוח מתמלא ואי אפשר לשחק יותר, ואז תחזיר
	public Player play() {
		while(isFull()==false ) { //תנאי שבודק שהלוח לא מלא
		 if(onePlay(players[0])==true) {return players[0];} //מחזיר את השחקן הראשון אם ניצח
	   	 if(onePlay(players[1])==true) {return players[1];}//מחזיר את השחקן השני אם ניצח
		} return null;//null אם הלוח מלא מחזיר    
	}


}
