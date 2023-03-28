package game;

	//מחלקה שמתארת שחקן בודד
	public class Player {
		private String name;
		private char mark;
		
		//מאתחלת שחקן עם שם ועם אות אחת שתהיה הסימן שלו בלוח המשחק.
		public Player(String name, char mark) {
			this.name=name;
			this.mark=mark;
		}
		//מתודה שמחזירה את השם.
		public String getName() {
			return name;
		}
		//מתודה שמחזירה את הסימן.
		public char getMark() {
			return mark;
		}
		//מתודה שמחזירה את שם השחקן והסימן שלו
		public String toString() {
			return String.format("%s(%c)",name,mark);
		}
		
	}

