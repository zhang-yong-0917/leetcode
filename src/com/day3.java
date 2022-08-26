package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com
 * @Author: zhangyong
 * @CreateTime: 2022-08-18  15:02
 * @Description: TODO
 * @Version: 1.0
 * 实现trie树
 */

public class day3 {
    public static void main(String[] args) {

    }
}
class Trie{

    static int N=100009;
    //存数所有的单词数
    static int[][]trie=new int[N][26];
    //记录某个格子被标记为结尾的个数
    static  int[] count=new int[N];
    //给被用到格子进行编号
    static int index=0;

    public Trie() {
        for (int row = index; row >= 0; row--) {
            Arrays.fill(trie[row], 0);
        }
        Arrays.fill(count, 0);
        index = 0;
    }

    public void insert(String word) {
        int p=0;
        for (int i = 0; i < word.length(); i++) {
            int u=word.charAt(i)-'a';
            if(trie[p][u]==0) trie[p][u]=++index;
            p=trie[p][u];

        }
        count[p]++;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return true;
    }

}
