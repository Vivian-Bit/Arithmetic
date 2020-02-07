public class AgeQuestion {
    public static void main(String[] args) {
        for(int i = 10;i < 100;i++){
            int m =i*i*i;
            int n = m*i;
            if((m+"").length()==4&&(n+"").length()==6){
                System.out.println("i="+i+"  "+"m="+m+"  "+"n="+n);
            }
            continue;
        }
    }
}
