package onboarding;

import java.util.List;
import java.util.stream.IntStream;

import java.util.List;

class Problem1 {
    public static int solution (List<Integer> pobi, List<Integer> crong){
        if(!checkException(pobi, crong)){
            return -1;
        }
        int pobiMax = getMaxScore(pobi);
        int crongMax = getMaxScore(crong);

        return comparePobiCrong(pobiMax, crongMax);
    }
    private static  int getMaxScore(List<Integer> page){
        int leftPage = page.get(0);
        int rigtPage = page.get(1);
        int leftMax = Math.max(getSumOfDigits(leftPage), getProductOfDigits(leftPage));
        int rightMax = Math.max(getSumOfDigits(rigtPage), getProductOfDigits(rigtPage));
        return Math.max(leftMax,rightMax);
    }

    private  static int getSumOfDigits(int page){// 이렇게 직접 구하기~!~!
        int sum = 0;
        while(page > 0){
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int getProductOfDigits(int page){
        int sum =1;
        while(page>0){
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }



    private static int comparePobiCrong(int pobiMax, int crongMax){
        if(pobiMax > crongMax){
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }

    private  static boolean checkException(List<Integer> pobi, List<Integer> crong){
        int checkA = pobi.get(1); int checkB = crong.get(1);
        if((checkA != pobi.get(0)+1) || (checkB != crong.get(0)+1)){
            return false;
        }
        else
            return  true;
    }

}


//코드이상해...........case1통과 못함
//97 98 이 72를 반환하는 함수
/*class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        //int answer = Integer.MAX_VALUE;
        if(checkException(pobi, crong)){
            int pobiMax = bigNum(pobi);
            int crongMax = bigNum(crong);

            answer = comparePobiCrong(pobiMax, crongMax);
            return answer;
        }else{
            return -1;
        }
    }


    private static int bigNum(List<Integer> number){
        String a = Integer.toString(number.get(0)); // 97 : 16 63 // 197: 17 63
        String b = Integer.toString(number.get(1)); // 98 : 17 72 // 198: 72 18

        int sumA = 1; int sumB = 1;
        int plusA = 0; int plusB = 0;
        for(int i = 0 ; i < a.length() ; i++){
            sumA *= a.charAt(i); plusA += a.charAt(i);
        }
        for(int i = 0 ; i < b.length() ; i++){
            sumB *= b.charAt(i); plusB += b.charAt(i);
        }
        return Math.max(Math.max(sumA, sumB), Math.max(plusA, plusB));
        //return IntStream.of(sumA, sumB, plusA, plusB).max().orElse(0);
    }

    private static int comparePobiCrong(int pobiMax, int crongMax){
        if(pobiMax > crongMax){
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }

    private  static boolean checkException(List<Integer> pobi, List<Integer> crong){
        int checkA = pobi.get(1); int checkB = crong.get(1);
        if((checkA != pobi.get(0)+1) || (checkB != crong.get(0)+1)){
            return false;
        }
        else
            return  true;
    }

}*/