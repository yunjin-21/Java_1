package onboarding;

// word를 하나의 문자배열로 보고 대문자일경우 소문자일경우 나누기
// (문자를 바꾸는 )함수를 적용시킨다.

public class Problem4 {
    public static String solution(String word) {
        char [] arr = word.toCharArray();
        for(int index=0;index<arr.length;index++){
            if(Character.isUpperCase(arr[index])){
                arr[index] = changeCharacterUpp(arr[index]); // arr[index]에 집어넣어야 함
            }else if(Character.isLowerCase((arr[index]))){
                arr[index] = changeCharacterLow(arr[index]);
            }else{ // 공백일 경우를 경우의 수에 넣기
                arr[index] = ' ';
            }
        }

        String ans = new String(arr);
        return ans;
    }

    private static char changeCharacterUpp(char ch){
       // ch = (char) (155 - (ch -'0')); // 문자를 정수로 바꾼후 ch - '0' 25를 더해줌 A : 65 Z: 90 a: 97 z: 122
        int intCh = 155 - (int) ch;
        ch = (char) intCh;
        return ch;
    }

    private static char changeCharacterLow(char ch){
        //ch = (char) (219 - (ch -'0')); // 문자를 정수로 바꾼후 ch - '0' 25를 더해줌 A : 65 Z: 90 a: 97 z: 122
        int intCh = 219 - (int) ch;
        ch = (char) intCh;
        return ch;
    }
}
