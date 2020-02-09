public class JumpLineNum {
    public static int text(int x,int y){
        if(x==1){
            return 1;
        }
        if(y==1){
            return 1;
        }
        return text(x-1,y)+text(x,y-1);
        //向右走：(x-1,y)
        //向下走：(x,y-1)
    }
    public static void main(String[] args) {
        System.out.println(text(5,4));
        //35
    }
}
