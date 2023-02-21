package io.github.uttmangosteen.dangoclicker;

import java.math.BigInteger;

public class ViewFormat {
    private static final String[] digitName = {"", "万", "億", "兆", "京", "垓", "秭", "穰", "溝", "澗", "正", "載", "極", "恒河沙", "阿僧祇", "那由他", "不可思議", "無量大数"};
    public static String bigIntegerFormat(BigInteger number){
        StringBuilder viewString = new StringBuilder();
        int digitAmount = String.valueOf(number).length() - 1;
        if(digitAmount == 0){
            return viewString.append("0.").append(number).toString();
        }else if(digitAmount <= 4){
            return viewString.append(String.valueOf(number), 0, digitAmount).append(".").append(String.valueOf(number), digitAmount, digitAmount + 1).toString();
        }else if(digitAmount <= 64){
            int digitNamePath = digitAmount / 4 % 18;
            int bigViewNumber = Integer.parseInt(String.valueOf(number).substring(0, digitAmount % 4));
            int smallViewNumber = Integer.parseInt(String.valueOf(number).substring(digitAmount % 4, digitAmount % 4 + 4));
            viewString.append(bigViewNumber).append(digitName[digitNamePath]);
            if(!(smallViewNumber == 0)){
                viewString.append(smallViewNumber).append(digitName[digitNamePath - 1]);
            }
            return viewString.toString();
        }else{
            int viewNumber = Integer.parseInt(String.valueOf(number).substring(0, 5));
            viewString.append(viewNumber).insert(1, ".").append("E+").append(digitAmount - 1);
            return viewString.toString();
        }
    }
}
