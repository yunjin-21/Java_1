package onboarding;

import java.util.*;

public class Problem6 {
    private static  HashMap<String, List<String>> twoLetters = new HashMap<>(); //2글자이름, 이메일 배열

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        initTwoLetters();
        for(List<String> userInfo : forms){
            int checkIndex = userInfo.get(1).length()-1 ; // nickName 길이 -1
            checkDuplicateLetters(checkIndex, userInfo);
        }
        answer = extractEamilByDuplicateNickname();
        //answer = removeDuplicateEmailDate(answer);
        Collections.sort(answer);
        return answer;
    }
    private static void initTwoLetters(){
        twoLetters = new HashMap<>();
    }

    private static void checkDuplicateLetters(int checkIndex ,List<String>userInfo){
        for(int i = 0 ; i <checkIndex;i++){
            String checkTwoLetter = userInfo.get(1).substring(i,i+2);
            List<String> tempList = new ArrayList<>(); //이메일 배열
            if(isContainTwoLetter(checkTwoLetter)){
                tempList = twoLetters.get(checkTwoLetter);//tempList에 기존 이메일 리스트를 가져옵니다.
            } // jm~ // jm~ jason
            tempList.add(userInfo.get(0));//이메일 추가하기 //jm~ jason~  //jm~ jason~ mj~
            twoLetters.put(checkTwoLetter, tempList);// 제이 jm~ 이엠 jm~ //제이 jm~ jason~ //이슨 jason~
            // 워니 woni~ // 엠제 mj~ // 제이 jm~ json~ mj~  //이제 now~  제엠 now~
        }
        //해쉬맵 중복된키를 허용하지않으면서도 순서를 유지
        //제이 jm~ jason~ mj~  이엠 jm~   이슨 jason~  워니 woni~   엠제 mj~  이제 now~  제엠 now~
    }
    private static boolean isContainTwoLetter(String checkTwoLetter){
        return twoLetters.containsKey(checkTwoLetter); // 특정 키(two letter)가 있는지 확인
    }
    private static List<String> extractEamilByDuplicateNickname(){
        List<String> answer = new ArrayList<>();
        for(String key: twoLetters.keySet()){
            if(twoLetters.get(key).size()>1){ //이메일 개수 이거너무중요
                // 해당 키(두 글자)에 대응하는 리스트의 크기, 즉 해당 두 글자에 대응하는 이메일 주소의 개수를 반환
                answer.addAll(twoLetters.get(key));
            }
        }
        return answer;
    }

    /*private static List<String> removeDuplicateEmailDate(List<String> answer){
        HashSet<String> tempSet = new HashSet<>(answer);
        answer = new ArrayList<>(tempSet);
        return answer;
    }*/
}



/*
 public static List<String> solution(List<List<String>> forms){
        //List<String> answer = List.of("answer");
        partNameAndEmail = new HashMap<>(); //nickname email
        answer = new ArrayList<>(); // email

        // 크루들 인원수 검증1
        //verifyCrewNum(forms);
        for(List<String> form : forms){
            String email = form.get(0);
            // 이메일에 대한 검증2
            //checkEmailCon(email);
            String nickname = form.get(1);
            //닉네임에 대한 검증3
            String [] nicknameArr  = nickname.split("");
            CreatePartNicknameAndCheck(email, nicknameArr);

        }
        List<String> answerList = new ArrayList<>(answer);
        answerList.sort(String::compareTo);
        return answerList;
    }

    private static void CreatePartNicknameAndCheck(String email, String[] nicknameArr){

        for(int i=0;i<nicknameArr.length-1;i++){
            String partNickname = nicknameArr[i]+nicknameArr[i+1];
            checkDuplicateAndAddResult(email, partNickname);
            partNameAndEmail.put(partNickname,email);
        }

    }
    private  static void checkDuplicateAndAddResult(String email, String partNickname){
        if(partNameAndEmail.containsKey(partNickname)){
            answer.add(email);
            answer.add(partNameAndEmail.get(partNickname));
        }


    }

 */