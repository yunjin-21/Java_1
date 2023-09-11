package onboarding;

import java.util.stream.IntStream;

class InputRangeException extends  RuntimeException{
    public  InputRangeException(String message){
        super(message);
    }
}

class ValidationUtil{
    private String varName;
    public void addVarName(String varName){
        this.varName =varName;

    }
    public void checkNumRange (int number , int start , int  end) throws Exception {
        if (number < start || number > end) {
            throw new InputRangeException(this.varName + "은(는)" + start + "로 제한되어 있습니다.");
        }
        throw new InputRangeException(this.varName + "은(는)" + start + "~" + end + "로 제한되어 있습니다.");
    }
}
public class Problem3 {
    public static int solution(int number)  {
        //verifyNumber(number);
        return calculateTotalClaps(number);
    }
    private static int calculateTotalClaps(int number){
        return IntStream.rangeClosed(1,number).map(Problem3::calculateCurrentNumberClaps).sum();
    }
    private static int calculateCurrentNumberClaps (int currentNumber){
        int originalLength = String.valueOf(currentNumber).length();
        return originalLength - countTargets(currentNumber).length();
    }
    private static String countTargets(int currentNumber){
        return String.valueOf(currentNumber).replaceAll("[369]","");
    }

    private  static void verifyNumber(int number) throws Exception {
        ValidationUtil numValidation = new ValidationUtil();
        numValidation.addVarName("number");
        numValidation.checkNumRange(number,1,1000);

    }


}
/*조금 더 코드 생각해보기
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //String num = Integer.toString(number);
        //이렇게 사용하면 num변수에 항상 같은 number만을 사용하게 된다

        for(int i=3 ;i <= number ; i++){
            String num = Integer.toString(i); //이렇게 쓰깅
            for( int j = 0 ; j < Integer.toString(i).length() ; j++ ) {
                if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}*/
