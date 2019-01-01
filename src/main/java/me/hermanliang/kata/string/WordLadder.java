package me.hermanliang.kata.string;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/word-ladder/description/">
 * https://leetcode.com/problems/word-ladder/description/</a>
 */
public class WordLadder {

    /**
     * 127. Word Ladder [Medium]
     * <p>
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * <p>
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     * <p>
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * Output: 5
     * <p>
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     * <p>
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * Output: 0
     * <p>
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     *
     * @param beginWord begin word
     * @param endWord   end word
     * @param wordList  word list
     * @return shortest transformation steps
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (isLadder(node, endWord)) return level + 1;
                for (String word : wordList) {
                    if (visited.contains(word)) continue;
                    if (isLadder(node, word)) {
                        visited.add(word);
                        queue.offer(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private boolean isLadder(String w1, String w2) {
        boolean onediff = false;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (onediff) return false;
                onediff = true;
            }
        }
        return onediff;
    }
}
