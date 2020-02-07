public class ReverseRomanNum {
    // I --> 1     V --> 5
    // X --> 10    L --> 50
    // C --> 100   D --> 500
    // M --> 1000
    public static String convert(int num){
        int thousandDigit = num/1000;//千位
        int hundredsDigit = num%1000/100;//百位
        int tensDigit = num%100/10;//十位
        int unitsDigit = num%10; //个位
        String s = " ";
        if(thousandDigit == 1) s+="M";
        if(thousandDigit == 2) s+="MM";
        if(thousandDigit == 3) s+="MMM";

        if(hundredsDigit == 1) s+="C";
        if(hundredsDigit == 2) s+="CC";
        if(hundredsDigit == 3) s+="CCC";
        if(hundredsDigit == 4) s+="CD";
        if(hundredsDigit == 5) s+="D";
        if(hundredsDigit == 6) s+="DC";
        if(hundredsDigit == 7) s+="DCC";
        if(hundredsDigit == 8) s+="DCCC";
        if(hundredsDigit == 9) s+="CM";

        if(tensDigit == 1) s+="X";
        if(tensDigit == 2) s+="XX";
        if(tensDigit == 3) s+="XXX";
        if(tensDigit == 4) s+="XL";
        if(tensDigit == 5) s+="L";
        if(tensDigit == 6) s+="LX";
        if(tensDigit == 7) s+="LXX";
        if(tensDigit == 8) s+="LXXX";
        if(tensDigit == 9) s+="XC";

        if(unitsDigit == 1) s+="I";
        if(unitsDigit == 2) s+="II";
        if(unitsDigit == 3) s+="III";
        if(unitsDigit == 4) s+="IV";
        if(unitsDigit == 5) s+="V";
        if(unitsDigit == 6) s+="VI";
        if(unitsDigit == 7) s+="VII";
        if(unitsDigit == 8) s+="VIII";
        if(unitsDigit == 9) s+="IX";

        return s.trim();

    }

    static boolean RomanNumOk(String s){
        for(int i = 1;i < 4000;i++){ //1-3999均转换成罗马数字 进行类比
           if(s.equals(convert(i))){
               return true;
           }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(RomanNumOk(" "));
        System.out.println(RomanNumOk("CCXLIX"));
        System.out.println(RomanNumOk("MCCCXIV"));
        System.out.println(convert(1314));
    }
}
