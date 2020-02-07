import java.util.HashMap;
import java.util.Scanner;
// I --> 1     V --> 5
// X --> 10    L --> 50
// C --> 100   D --> 500
// M --> 1000
public class RomanNum {
    static HashMap<Character,Integer> Map = new HashMap<Character,Integer>(){
                {
                    put('I',1);
                    put('V',5);
                    put('X',10);
                    put('L',50);
                    put('C',100);
                    put('D',500);
                    put('M',1000);
                }
            };
    public static int convert1(String s){
        int sum = 0;	// 总和
        int i=0;
        while(i<s.length()){
            int a = Map.get(s.charAt(i));
            int b ;
            if(i+1<s.length()){
                b = Map.get(s.charAt(i+1));
            }else{
                b = 0;
            }
            if(a<b){
                sum += b - a;
                i += 2;
            }else{
                sum += a;
                i++;
            }
        }
        return sum;
    }

    public static int convert(String s){
        //在程序中枚举
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            //取s中出第i个字符
            char c = s.charAt(i);
            if (c == 'I') sum += 1;
            if (c == 'V') sum += 5;
            if (c == 'X') sum += 10;
            if (c == 'L') sum += 50;
            if (c == 'C') sum += 100;
            if (c == 'D') sum +=500;
            if (c == 'M') sum +=1000;
        }

        //补偿法:将漏掉的可能出现的情况一个一个列举出来：
        if(s.indexOf("IV")>=0) sum -=2; //如果“IV”在字符串s中是 存在的，那么
        if(s.indexOf("IX")>=0) sum -=2;
        if(s.indexOf("XL")>=0) sum -=20;
        if(s.indexOf("XC")>=0) sum -=20;
        if(s.indexOf("CD")>=0) sum -=200;
        if(s.indexOf("CM")>=0) sum -=200;

        return sum;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String RomanString[] = new String[n];
        for(int i =0;i < n ;i++){
            RomanString[i] = scanner.next();
        }
        scanner.close();
        for(String s : RomanString){
            System.out.println(convert1(s));
        }
    }
}
