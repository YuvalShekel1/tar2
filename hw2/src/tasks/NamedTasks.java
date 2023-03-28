package tasks;

// ובה כל משימה מתוארת ע"י שם ולא מספרTasks מחלקה שיורשת מהמחלקה
public class NamedTasks extends Tasks{
       private String[] names;
       //בנאי שמקבל את מערך השמות של המשימות 
       public NamedTasks(String[] names) {
              super(names.length);
              this.names=names;
       }
       // ובדיקת תקינות מספרי המשימות והחזרת ערך מתאים לפי תקינותם task2 לא יכולה להתקיים לפניtask1 מתודה שמוסיפה למערכת את התלות לפיה
       public boolean dependsOn(String task1, String task2) {
              //אתחול דגלים ל-0 שיסמנו את תקינותם של המספרים של שתי המשימות אפ ערך הדגל ישתנה ל-1 סימן שמספרי המשימות תקינים, הגדרת משתנים לאינדקסים שבאמצעותם נמצא את האינדקסים של המשימות 
              int flag1=0,flag2=0,index1=0,index2=0;
              for(int i=0;i<names.length;i++) { // i לולאה שבודקת האם השם של המשימה הראשונה הוא מספר תקין ומעדכנת את הדגל בהתאם ומעדכנת את האינדקס לפי ה
                        if(task1.equals(names[i])==true) {
                              flag1=1;
                              index1=i;
                        }
              }
              for(int i=0;i<names.length;i++) {// i לולאה שבודקת האם השם של המשימה הראשונה הוא מספר תקין ומעדכנת את הדגל בהתאם ומעדכנת את האינדקס לפי
                       if(task2.equals(names[i])==true) {
                              flag2=1;
                              index2=i;
                        }
                 }
              if (flag1==0 || flag2==0)// תנאי שבודק אם אחת מהמשימות לא תקינה, אם אחת מהן לא תקינה מחזיר שקר
                     return false;
              else {
                     super.dependsOn(index1, index2); // אחרת מעדכן את קדימות המשימות לפי האינדקסים ומחזיר אמת
                     return true;}
         
       }


       
       ////  null מתודה שמחזירה מערך בו מופיעות כל המשימות לפי סדר שמקיים את כל התלויות המבוקשות, במידה ויש מעגל של תלויות מחזירה
       public String[] nameOrder() {
              String[] nameOrder= new String[names.length]; //אתחול המערך לפי גודל מערך השמות שקיבלנו
              int []order= new int[names.length];// אתחול מערך עזר בעזרתו נמיין לפי הערכים המתאימים
              order=super.order();// שימוש במתודה ממחלקת העל שמסדרת את המערך לפי סדר המשימות הנכון
              for(int i=0;i<names.length;i++) {
                     nameOrder[i]=names[order[i]];} // המרת המערך המסודר שמצאנו ממספרים למחרוזת המתאימה למספר 
              return nameOrder;
              }

}
