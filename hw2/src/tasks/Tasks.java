package tasks;
//(num-1)מחלקה לסידור אוטומטי של משימות, כאשר כל משימה מיוצגת ע"י מספר מ-0 ועד 
public class Tasks {
       private int num;
       private int[] order; // הגדרת המערך שיוחזר לפי סדר המשימות אותן יש לבצע
       private int[][] depArr; //  הגדרת מערך עזר  דו מימדי על מנת לשמור את המשימות שתלויות אחת בשניה 
       // משימות(num) מאתחלת את המערכת לשימוש עם
       public Tasks(int num) {
              this.num=num;
              depArr=new int[num][num]; // (numxnum)אתחול המערך הדו מימדי למערך ריבועי בגודל 
              order=new int[num]; // אתחול המערך אותו יש להחזיר לגודל המבוקש
       }
       //   ובדיקת תקינות מספרי המשימות והחזרת ערך מתאים לפי תקינותם task2 לא יכולה להתקיים לפניtask1 מתודה שמוסיפה למערכת את התלות לפיה
       public boolean dependsOn(int task1, int task2) {
              if(0>task1 || task1>num-1 || 0>task2 || task2>num-1 || task1==task2) {// בדיקה האם מספרי המשימות שהתקבלו תקינים
                     return false;}
              else {
                     depArr[task1][task2]+=1;// השמת ערך 1 בכל מקום בו יש תלות בין השורה לעמודה של המיקום
                     return true;}
       }
       //  null מתודה שמחזירה מערך בו מופיעות כל המשימות לפי סדר שמקיים את כל התלויות המבוקשות, במידה ויש מעגל של תלויות מחזירה
       public int[] order() {
              int a=0; // order אתחול ערך המסמן את המיקום במערך
              int cntNoDep=0;//אתחול משתנה שסופר את מספר המשימות שאינן תלויות
              for (int i=0 ; i<num; i++) {
                     int cntDep=0; // אתחול משתנה שסופר את מספר המשימות התלויות 
                     for(int j=0; j<num; j++) {
                           if (depArr[i][j]!=0) { //בדיקה האם המשימה תלויה 
                                  cntDep+=1;}
                     }
                     if(cntDep==0){ //אם המשימה לא תלויה באף משימה אחרת
                           order[a]=i; // נכניס את האינדקס שמ
                           a++;//מעבר למקום הבא במערך
                           cntNoDep++;// הגדלת המונה שסופר את המשימות הבלתי תלויות
                           for (int k=0; k<num; k++) {
                                  if (depArr[k][i]!=0) {//יש תנאים שתלויים בה כלומר אם יש תנאים שתלויים במשימה הזוiתנאי שבודק האם בעמודה ה
                                         depArr[k][i]=0;}// במידה ויש תנאי שתלוי במשימה זו נשנה את ערכו לבלתי תלוי 
                           }
                           for (int k=0; k<num; k++) { 
                                  depArr[i][k]=-1; //- סימון השורה (המשימה)שכבר עברנו עליה ב1
                           }}
                     if ((i==num-1) && (cntNoDep==0))// תנאי שבודק האם קיבלנו מעגל
                           return null;
                     else {
                           if (i==num-1) { // תנאי שבודק אם הגענו לסוף המערך ובמידה וכן מתחיל את הבידקה מחדש על השורות עליהן דילגנו בבדיקה הקודמת
                                  i=-1;
                                  cntNoDep=0;}
                     if(a==num) // תנאי שבודק האם מילאנו את כל המערך של המשימות לפי הסדר של התלויות
                           return order;
                     }
              }
              return order; 
              
       }

}
