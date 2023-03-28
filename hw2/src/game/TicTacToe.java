package game;

// מחלקה שמממשת את המשחק איקס עיגולת שחקן אחד מסומן באיקס והשני בעיגול. הלוח תמיד בגודל 3 על 3 והמנצח הוא מי שמייצר קו באורך 3
public class TicTacToe extends Game{
	
	//player2 ושם השני הוא player1 מייצרת משחק בו שם השחקן הוא    
	public TicTacToe(String player1, String player2) {
		super(3,3,new  Player(player1,'X'),new  Player(player2,'O')); //קריאה לבנאי של מחלקת העל משחק ויצירת אובייקטים מסוג שחקן
	}
	//ואורך הקו של המצח היה 3 אז המתודה תחזיר אמת, אחרת שקר  x,y אם המהלך האחרון מנצח כשהמהלך היה במיקום
	@Override
	protected boolean doesWin(int x, int y) {
		if (maxLineContaining(x,y)==3) {return true;}
		return false;
		
	}
	{
	
	}
}
