package com.nateshao.sword_offer.topic_52_strToInt;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/2/28 22:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        String arr = "42";
        System.out.println("strToInt(arr) = " + strToInt(arr));
    }
    public static int strToInt(String str) {
        char[] c = str.trim().toCharArray(); //去前后空格
        if(c.length == 0) return 0;// 字符串为空则直接返回
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;// sign = 1记录第一个符合是否为负数  i = 1开始遍历的位置
        if(c[0] == '-') sign = -1;// 保存负号
        else if(c[0] != '+') i = 0;// 若无符号位，则需从 i = 0 开始数字拼接
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;// 遇到非数字的字符则跳出
            // 根据字符串首负号判断返回最大值还是最小值
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');// 数字拼接
        }
        return sign * res;
    }

    public static int strToInt1(String str) {
        if (str == null || str.length() == 0) return 0;
        int mark = 0, number = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '-') mark = 1;
        for (int i = mark; i < chars.length; i++) {
            if (chars[i] == '+') continue;
            if (chars[i] < 48 || chars[i] > 57) return 0;
            number = number * 10 + chars[i] - 48;
        }
        return mark == 0 ? number : -number;
    }
    public int strToInt2(String str) {
        //先去空格再判空，不然" "教您做人，血的教训
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        //然后我想啊，下面要判断首位了
        //首位合格的无非就'+'或'-'或数字三种情况，其他的一概滚蛋
        //'+''-'肯定是要把它去掉的，这样三种情况就统一了
        //当然了，'-abc'这种有可能出现，不过只看首位它是没毛病的
        //让它进来，反正后面很容易解决
        //既然要去掉正负号，那肯定要出个boolean记一下是不是负数
        boolean isMinus = false;
        char[] ch = str.toCharArray();
        //首位是不是正负号或者数字啊
        if(ch[0] == '+' || ch[0] == '-' || Character.isDigit(ch[0])){
            //是不是正负号啊
            if(ch[0] == '+' || ch[0] == '-'){
                //是不是负号啊
                if(ch[0] == '-'){
                    isMinus = true;
                }
                //删除首位
                ch = Arrays.copyOfRange(ch,1,ch.length);
            }
            //首位搞定了就看后面是不是数字了，直到不是数字的地方或者倒底结束
            int index = 0;
            //结果可能超int范围，拿个long接一下
            //'-abc'这种情况返回的也是0，舒服，一箭双雕
            long res = 0;
            //短路与助您远离空指针喔，铁汁们，先后顺序关注一下
            while(index < ch.length && Character.isDigit(ch[index])){
                //一位一位往上算
                res *= 10;
                res += ch[index] - '0';
                //及时止损，一看到res超int范围立马return
                //你要是想着最后一起算，那肯定会有超long范围的测试用例等着你，你就哭去吧
                if(res > Integer.MAX_VALUE){
                    //正负号看是正数负数，返回最大值
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //别忘了往后走一位
                index++;
            }
            //long转int就是这么朴实无华
            return isMinus ? -(int)res : (int)res;
        }
        //兄弟首位都不对想啥呢，回去吧您
        return 0;
    }
}
