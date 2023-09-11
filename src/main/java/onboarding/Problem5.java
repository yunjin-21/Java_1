package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int arr[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int order : arr) {
            if (money < order) {
                answer.add(0);
                continue;
            }
            answer.add(money/order);
            money%=order;

        }
        return  answer;
    }
}


//통과는 했지만 내가 생각해도 너무너무 구린 코드
//오만 원권, 만 원권, 오천 원권, 천 원권
//오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
/*
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int first = money / 50000;money -= first*50000;
        int second = money / 10000;money -= second*10000;
        int third = money / 5000;money -= third* 5000;
        int fourth = money / 1000;money -= fourth*1000;
        int fifth = money / 500;money -= fifth*500;
        int sixth = money / 100;money -= sixth*100;
        int seventh = money / 50;money -= seventh*50;
        int eigth = money / 10;money -= eigth*10;
        int ninth = money;money -= ninth;
        answer.add(first); answer.add(second); answer.add(third);
        answer.add(fourth); answer.add(fifth); answer.add(sixth);
        answer.add(seventh); answer.add(eigth); answer.add(ninth);


        return answer;
    }
}

 */
