package game;

//מתודה שמממשת את המשחק פוראיןרוו,במשחק 2 שחקנים בשמות האותיות איקס ובי כאשר המנצח במשחק הוא מי שיצר קו ישר או אלכסוני באורך 4
public class FourInARow extends Game{
	//W וB יוצרת לוח משחק בגודל 6 על 7 עם שחקנים עם שני שמות 
	public FourInARow(String player1, String player2) {
		super(6,7,new  Player(player1,'W'),new  Player(player2,'B')); //קריאה לבנאי של מחלקת העל משחק ויצירת אובייקטים מסוג שחקן
	} 
	
	//ואורך הקו של המצח היה 4 אז המתודה תחזיר אמת, אחרת שקר  i,j אם המהלך האחרון מנצח כשהמהלך היה במיקום
	@Override
	protected boolean doesWin(int i, int j) {
		if (maxLineContaining(i,j)==4) {return true;}
		return false;
	}
	//מתודה שבכל פעם תבקש מהשחקן את מספר העמודה בה הוא רוצה להכניס כלי משחק. אם העמודה מלאה, השחקן יתבקש לבחור עמודה שוב.

	@Override
	protected boolean onePlay(Player p) {
		int j;
		System.out.format("%s, please enter column:\n",p.toString());
		j=s.nextInt(); //שומרת במשתנה זה את מספר העמודה שהתקבל בקלט
		while(true) { //לולאה שרצה עד שיש תנאי שעוצר אותה
			for (int i=5;i>=0;i--) { // לולאה שרצה על כל השורות 
				if(isEmpty(i,j)==true) { //תנאי שבודק שיש מקום פנוי בעמודה שהשחקן ביקש
					if(set(i,j,p)) { //מסמנת את השחקן במקום הפנוי הזה ומחזירה אמת
						System.out.println(super.toString());
						return (doesWin(i,j));}}} //אם במהלך הזה השחקן ניצח מחזיר אמת
			System.out.format("%s, please enter column again:\n",p.toString()); //אם העמודה שהשחקן בחר מלאה נבקש לבחור שוב עמודה
			 j=s.nextInt();}	//קליטת מספר עמודה מהשחקן
		   
				}				

}
