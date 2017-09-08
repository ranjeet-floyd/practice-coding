package future.fry.practice.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ranjeet
 */
public class GroupAnagrams {

    /*
     Given an array of strings, group anagrams together.
     */
    public static void main(String[] args) {
        /*
        // For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
        // Return:

        // [
        //   ["ate", "eat","tea"],
        //   ["nat","tan"],
        //   ["bat"]
        // ]
         */

        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        result.stream().forEach(subResult -> {
            System.out.println(subResult.stream()
                    .collect(Collectors.joining(",")));
        });

    }

    private List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();

        Arrays.sort(strs);

        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
