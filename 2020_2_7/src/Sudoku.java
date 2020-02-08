import java.util.Scanner;

/* 旋转4种
   4 9 2
   3 5 7
   8 1 6
"492357816"
   8 3 4
   1 5 9
   6 7 2
"834159672"
 */
//镜像4种
public class Sudoku {
    public static boolean test(String s, String ss){
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ss.charAt(i)||ss.charAt(i) =='0') continue;
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = "";
        for(int i = 0; i < 9 ; i++){
            ss += scanner.next();
        }
        scanner.close();
        String[] strings ={"492357816","834159672","618753294","276951438",
                "249753618","438951276","816357492","672159834"};
        for(String s:strings){
            if(test(s,ss)){
                System.out.println(s.charAt(0)+" "+s.charAt(1)+" "+s.charAt(2));
                System.out.println(s.charAt(3)+" "+s.charAt(4)+" "+s.charAt(5));
                System.out.println(s.charAt(6)+" "+s.charAt(7)+" "+s.charAt(8));
            }
        }
    }
}
