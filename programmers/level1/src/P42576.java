package com.algorithm.programmers;

import java.util.HashMap;

/* 프로그래머스 완주하지 못한 선수 (Level1) */
class P42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            if(!map.containsKey(name)) map.put(name, 1);
            else map.put(name, map.get(name)+1);
        }
        for(String name : completion) {
            int count = map.get(name);
            if(count==1) map.remove(name);
            else map.put(name, count-1);
        }
        return map.keySet().toString().replace("[", "").replace("]", "");
    }
}
