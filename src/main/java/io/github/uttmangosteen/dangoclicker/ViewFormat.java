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
            return viewString.append(String.valueOf(number), 0, digitAmount + 1).insert(digitAmount, ".").toString();
        }else if(digitAmount <= 64){
            viewString.append(String.valueOf(number), 0, (digitAmount - 1) % 4 + 1).append(digitName[(digitAmount - 1) / 4]);
            int small4Digit = Integer.parseInt(String.valueOf(number).substring((digitAmount - 1) % 4 + 1, (digitAmount - 1) % 4 + 5));
            if(!(small4Digit == 0)){
                viewString.append(small4Digit).append(digitName[(digitAmount - 1) / 4 - 1]);
            }
            return viewString.toString();
        }else{
            viewString.append(String.valueOf(number), 0, 5).insert(1, ".").append("E+").append(digitAmount - 1);
            return viewString.toString();
        }
    }
}
