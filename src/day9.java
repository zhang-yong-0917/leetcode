/**
 * @BelongsProject: leetcode
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhangyong
 * @CreateTime: 2022-09-15  11:37
 * @Description: TODO
 * @Version: 1.0
 */
public class day9 {
    public static void main(String[] args) {

    }
    class Solution {
        public int flipLights(int n, int k) {
            if (k == 0) return 1;
            if (n == 1) return 2;
            else if (n == 2) return k == 1 ? 3 : 4;
            else return k == 1 ? 4 : k == 2 ? 7 : 8;
        }
    }

}
