package topic_801_1000.t851_900;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 *
 * @author ：wy.
 * @date ：Created in 21:32 2020/12/10
 */
public class T860_LemonWaterSales {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {return true;}
        int fiveNum = 0 , tenNum = 0;
        for (int bill : bills) {
            int seed = bill / 5;
            if (seed == 1) {
                fiveNum ++;
            }else if (seed == 2 && fiveNum > 0) {
                fiveNum --; tenNum ++;
            }else if (seed == 4 && ((fiveNum > 0 && tenNum > 0) || fiveNum > 2)) {
                if (fiveNum > 0 && tenNum > 0) {
                    fiveNum -- ; tenNum -- ;
                }else {
                    fiveNum -= 3;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testInfo = new int[]{5,5,10,10,20};
        T860_LemonWaterSales lemonWaterSend = new T860_LemonWaterSales();
        System.out.println(lemonWaterSend.lemonadeChange(testInfo));
    }
}
