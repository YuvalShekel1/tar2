package game;
//מחלקה שמחזיקה את לוח המשחק
public class Board {
	protected Player[][] board; //לוח המשחק עצמו, בו בכל מקום מופיע השחקן שתפס את הנקודה הזאת בלוח.
	protected int n,m; //גודל לוח המשחק.
	
	
	// m על n מייצרת לוח משחק בגודל 
	public Board(int n, int m) {
		board=new Player[n][m];
		this.n=n;
		this.m=m;
		
	}
	//ריק אז מסמנת שהוא נלקח ע"י השחקן שקיבלה המתודה ומחזירה אמת,אחרת מחזירה שקר  i,j אם המקום
	protected boolean set(int i, int j, Player p) {
		if (board[i][j]==null) {
			board[i][j]=p;
			return true;
		}
		return false;
	}
	//ריק בלוח i,j מחזירה אמת אם המיקום 
	public boolean isEmpty(int i, int j) {
		if (board[i][j]==null) {
			return true;
		}
		return false;
	}
	// null בלוח ואם המקום ריק מחזירה  i,j מחזירה מצביע לשחקן שתפס את המקום ה
	public Player get(int i, int j) {
		if (board[i][j]==null){return null;}
		return board[i][j];
	}
	//מחזירה אמת אם כל הלוח מלא
	public boolean isFull() {
		//עוברת על כל איברי המטריצה, כלומר על כל הלוח 
		for (int i=0;i<n;i++) {
			for (int j=0;i<m;j++) {
				if (board[i][j]==null) {return false;}//במידה ומקום אחד נמצא פנוי בלוח נחזיר שקר
			}
		}return true;
	}
	//מחזירה את לוח המשחק כמחרוזת
	public String toString() {
		String s="";
		//עוברת על כל איברי הלוח ואם יש איבר ריק תרשום במקומו נקודה אחרת תרשום את הסימן של השחקן
		for (int i=0;i<n;i++) { 
			for (int j=0;j<m;j++) {
			 if (board[i][j]==null) {s+=".";}
			 else {s+=board[i][j].getMark();}
			}s+="\n";
		}return s;
	}
	//מתודה שמחשבת את את אורך הקרן הכי ארוכה שיוצאת מהנקודה הנתונה  בקו ישר או אלכסון ומכילה בכל נקודה רק את השחקן שנמצא בנקודה הנתונה
	protected int maxLineContaining(int i, int j) {
		int row=1,col=1,diagonal1=1,diagonal2=1;
		int ind1,ind2, max;
		
		//לולאה שמחשבת קרן בשורה
		for(ind1=i-1; ind1>=0;ind1--) {
			if(board[i][j]!=board[ind1][j])
				break;
			row++;}
		
		//לולאה שמחשבת קרן בשורה
		for(ind1=i+1; ind1<n ;ind1++) {
			if(board[i][j]!=board[ind1][j])
				break;
			row++;}
		
		max=row;//שומרים במקס את הקרן הארוכה בשורה
		//לולאה שמחשבת קרן בעמודה
		for(ind1=j-1; ind1>=0;ind1--) {
			if(board[i][j]!=board[i][ind1])
				break;
			col++;}
		
		//לולאה שמחשבת קרן בעמודה
		for(ind1=j+1; ind1<m ;ind1++) {
			if(board[i][j]!=board[i][ind1])
				break;
			col++;}
		//נעדכן אותו בהתאם max אם קיבלנו קרן שגדולה מ
		if(max<col)
			max=col;
		
		//לולאה שמחשבת קרן באלכסון מימין לשמאל
		for(ind1=i-1,ind2=j-1; ind1>=0 &&  ind2>=0 ; ind1--,ind2--) {
			if(board[i][j]!=board[ind1][ind2])
				break;
			diagonal1++;}
		
		//לולאה שמחשבת קרן באלכסון מימין לשמאל
		for(ind1=i+1,ind2=j+1; ind1<n &&  ind2<m ; ind1++,ind2++) {
			if(board[i][j]!=board[ind1][ind2])
				break;
			diagonal1++;}
		
		if(max<diagonal1) //נעדכן אותו בהתאם max אם קיבלנו קרן שגדולה מ
			max=diagonal1;
		//לולאה שמחשבת קרן באלכסון משמאל לימין
		for(ind1=i-1,ind2=j+1; ind1>=0 &&  ind2<m; ind1--,ind2++) {
			if(board[i][j]!=board[ind1][ind2])
				break;
			diagonal2++;}
		
		//לולאה שמחשבת קרן באלכסון משמאל לימין
		for(ind1=i+1,ind2=j-1; ind1<n &&  ind2>=0 ; ind1++,ind2--) {
			if(board[i][j]!=board[ind1][ind2])
				break;
			diagonal2++;}
		
		if(max<diagonal2) //נעדכן אותו בהתאם max אם קיבלנו קרן שגדולה מ
			max=diagonal2;
		
		return max;}	
}
