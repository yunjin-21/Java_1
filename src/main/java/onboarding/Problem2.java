package onboarding;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Stack;
public class Problem2 {
   public static String solution(String cryptogram){
       return StringFormat(decrypt(cryptogram));
   }
   public static Stack<Character> decrypt(String cryptogram){
       Stack<Character> result = new Stack<>();
       for(char alphabet : cryptogram.toCharArray() ){
           if(result.isEmpty()){
               result.push(alphabet);
                       continue;
           }
           char top = result.pop();

           if(alphabet != top){ //여러개가 중복되어도 제거할 수 있는 방법
               result.push(top);
               result.push(alphabet);

           }

       }
       return result;
   }
   public static String StringFormat(Stack<Character> result){
       StringBuffer sb = new StringBuffer();
       Iterator<Character> it = result.iterator();
       while(it.hasNext()){
           sb.append(it.next());

       }
       return sb.toString();
   }


}



/*
public class Problem2 {
    public static String solution(String cryptogram) {
        return formatAnswer(decrypt(cryptogram));
    }

    private static Stack<Character> decrypt(String cryptogram) {
        Stack<Character> result = new Stack<>();
        for (char alphabet : cryptogram.toCharArray()) {
            if (result.isEmpty()) {
                result.push(alphabet);
                continue;//다음 for문을 수행
            }
            char top = result.pop();
            if (top != alphabet) {//top이 중복되지않는다면
                result.push(top); //다시 스택에 넣는다
                result.push(alphabet); // 알파벳도 넣는다
            }
        }
        return result;
    }

    private static String formatAnswer(Stack<Character> stack) {
        //StringBuilder answer = new StringBuilder();
        StringBuffer answer = new StringBuffer();
        Iterator<Character> word = stack.iterator();
        while (word.hasNext()) {
            answer.append(word.next());
        }
        return answer.toString();
    }
}*/



