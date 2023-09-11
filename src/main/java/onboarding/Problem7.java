package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>(); // 사용자별 점수를 저장할 맵
        List<String> userFriend = new ArrayList<>(); //donut  shakevan

        for(List<String> friend : friends){
            if(friend.get(0).equals(user)){
                userFriend.add(friend.get(1));
            }
            if(friend.get(1).equals(user)){
                userFriend.add(friend.get(0));
            }
        }
        // 사용자와 함께 아는 친구의 수를 계산하여 점수를 더합니다.
        for (List<String> friend : friends) {
            for(String uf : userFriend){
                if (friend.get(0).equals(uf) && friend.get(1) != user) {
                    scores.put(friend.get(1), scores.getOrDefault(friend.get(1), 0) + 10);
                }
                if (friend.get(1).equals(uf) && friend.get(0) != user) {
                    scores.put(friend.get(0), scores.getOrDefault(friend.get(0), 0) + 10);
                }
            }
        }

        // 사용자의 타임 라인에 방문한 횟수를 계산하여 점수를 더합니다.
        for (String visitor : visitors) {
            if(userFriend.contains(visitor)){
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }

        // 추천 점수가 0인 항목을 제외하고, 점수가 높은 순서로 정렬합니다.
        List<String> recommended = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > 0) { //&& !entry.getKey().equals(user)
                recommended.add(entry.getKey());
            }
        }

        Collections.sort(recommended, (a,b) -> {
            int scoreA= scores.get(a);
            int scoreB = scores.get(b);

            if(scoreA != scoreB){
                return Integer.compare(scoreB,scoreA); // 크기가 큰 순서대로 정렬

            }else{
                return a.compareTo(b); // 값이 같다면 알파벳 순서대로
            }
        });

        // 최대 5명까지 추천합니다.
        return recommended.subList(0, Math.min(5, recommended.size())); // 5랄 size중에서 작은 값을 반환하는 메서드
    }

    public static void main(String[] args) {
        List<List<String>> friends = Arrays.asList(
                Arrays.asList("donut", "andole"),
                Arrays.asList("donut", "jun"),
                Arrays.asList("donut", "mrko"),
                Arrays.asList("shakevan", "andole"),
                Arrays.asList("shakevan", "jun"),
                Arrays.asList("shakevan", "mrko")
        );

        List<String> visitors = Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> result = solution("mrko", friends, visitors);
        System.out.println(result); // ["andole", "jun", "bedi"]
    }
}

















/*package onboarding;



import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = new ArrayList<>(); //donut  shakevan

        for(List<String> friend : friends){
            if(friend.get(0).equals(user)){
                userFriend.add(friend.get(1));
            }
            if(friend.get(1).equals(user)){
                userFriend.add(friend.get(0));
            }
        }
        Map<String, Integer> userUserFriend  = findUserUserFriend(userFriend, friends,user);//andole 20  //jun 20
        Map<String, Integer> visitUser = visitUser(visitors,user,userFriend);  // bedi 3

        Map<String, Integer> combinedMap = new HashMap<>(userUserFriend);
        combinedMap.putAll(visitUser);

        // 맵을 정렬합니다.
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(combinedMap.entrySet());
        Collections.sort(sortedEntries, (e1, e2) -> {
            int cmp = e2.getValue().compareTo(e1.getValue()); // 내림차순 정렬
            if (cmp == 0) {
                return e1.getKey().compareTo(e2.getKey()); // 값이 같으면 알파벳 순서대로 정렬
            }
            return cmp;
        });

        // 정렬된 맵에서 키만 추출하여 리스트 생성
        List<String> sortedKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            sortedKeys.add(entry.getKey());
        }
        return sortedKeys;
    }
    private static Map<String, Integer> findUserUserFriend(List<String> userFriend,List<List<String>> friends,String user){
        Map<String, Integer> userUserFriend = new HashMap<>();
        init(userUserFriend);
        for(List<String> friend: friends){
            for(String id: userFriend){
                if(friend.get(0).equals(id) && friend.get(1)!= user){
                    int preCount = userUserFriend.get(friend.get(1));
                    userUserFriend.put(friend.get(1),preCount+10);
                }
                if(friend.get(1).equals(id)&& friend.get(1)!= user){
                    int preCount = userUserFriend.get(friend.get(0));
                    userUserFriend.put(friend.get(0),preCount+10);
                }
            }

        }
        return userUserFriend;
    }

    private static Map<String, Integer> visitUser(List<String> visitors, String user,List<String> userFriend){
        Map<String, Integer> visitUser = new HashMap<>();
        init(visitUser);
        for(String visitor : visitors){
            if(userFriend.contains(visitor)){
                continue;
            }
            int preCount = visitUser.get(visitor);
            visitUser.put(visitor, preCount+1);
        }
        return visitUser;
    }

    private static void init(Map<String, Integer> a){
        for(String key: a.keySet()){
            a.put(key, 0);
        }
    }
}*/
