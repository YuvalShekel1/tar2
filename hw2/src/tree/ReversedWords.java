package tree;

import java.util.Scanner;

//Node מחלקה שתדגים את השימוש במחלקה 
public class ReversedWords {
	// ומחזירה את מספר המחרוזות שכבר הופיעו קודם בקלט בהיופוך סדר אותיות Xמתודה שמבקשת מחרוזת מהמשתמש, עוצרת בתו   
	public static int checkReversed() {
	Node root=new Node(); //Node יצירת אובייקט חדש מסוג
	int cnt=0; // משתנה שבאמצעותו נחזיר את מספר המחרוזות הרצוי 
	System.out.println("Please enter string: ");
	Scanner input=new Scanner(System.in); //קליטת מחרוזת מהמשתמש
	String str=input.next();//כל פעם נשמור מילה מהמחרוזת בנפרד
	while(!str.equals("X")) { //X לולאה שרצה כל עוד לא הגענו לתו
		String strRevers=""; //איתחול מחרוזת ריקה להיפוך המילה
		for (int i=str.length()-1;i>=0;i--) { //str לולאה שעוברת על כל האותיות במילה בסדר הפוך ויוצרת את היפוך המילה
			strRevers+=str.charAt(i);
		}
			if (root.num(strRevers)!=0) { // str תנאי שבודק אם נפגשנו בקלט עם המילה בסדר הפוך ל
				cnt++; // אם נפגשנו בה נעלה את המשתנה ב1
			}
			root.add(str); //נוסיף את המחרוזת 
		//}
		str=input.next(); //נשמור את המילה הבאה
	}
	input.close();
	return cnt;} //שהו נחזיר את מספר המחרוזות שהופיעו בקלט עם היפוך אותיות למחרוזות אחרות שהופיעו לפני בקלט 
	

}
