package exercise.exercise_0427;

//字符串
/*
替换空格
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/*
public class Solution {
    public String replaceSpace(StringBuffer str) {
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
                i+=2;
            }
        }
        return str.toString();
    }
}
*/

//查找和排序
/*
旋转数组的最小数字
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(array == null || len == 0){
            return 0;
        }
        int result = array[0];
        for(int i=1; i<len-1; i++){
            if(array[i]<array[i-1] && array[i]<=array[i+1]){
                result = array[i];
            }
        }
        return Math.min(result,Math.min(array[0],array[len-1]));
    }
}*/

/*
位运算
二进制中1的个数
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

/*
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n -= n &(~n+1);
            count++;
        }
        return count;
    }
    *//*
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = n &(n-1);
            count++;
        }
        return count;
    }
    *//*
    *//*
    long num = (long)n ;
        int count = 0;
        while(num != 0){
            count += num&1;
            num = num>>1;
        }
        return count;
        *//*
}
*/

//画图让抽象形象化
/*
顺时针打印矩阵
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix == null || row ==0 ||col == 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = col-1;
        int up = 0;
        int down = row-1;
        while(left<right && up<down){
            for(int i=left; i<=right; i++){
                list.add(matrix[up][i]);
            }
            for(int i=up+1;i<down; i++){
                list.add(matrix[i][right]);
            }
            for(int i=right; i>=left; i--){
                list.add(matrix[down][i]);
            }
            for(int i=down-1;i>=up+1; i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if(left == right && up == down){
            list.add(matrix[left][up]);
        }else if(left == right && up < down){
            for(int i=up; i<=down; i++){
                list.add(matrix[i][left]);
            }
        }else if(left < right && up == down){
            for(int i=left; i<=right; i++){
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
}