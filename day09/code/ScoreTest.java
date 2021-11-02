package top.lep101.java3;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        //1.实例化Scanner，用于从键盘获取学生成绩
        Scanner scan = new Scanner(System.in);
        //2.创建Vector对象，Vector v = new Vector();相当于原来的数组
        Vector v = new Vector();
        //3.通过for(;;)或while(true)方式，给Vector中添加数组
        int maxScore = 0;
        for (;;){
            System.out.println("请输入学生成绩（以负数代表输入结束）");
            int score = scan.nextInt();
            //3.2当输入是负数时，跳出循环
            if (score < 0) {
                break;
            }
            if (score > 100){
                System.out.println("输入的数据非法，请重新输入");
                continue;
            }
            //3.1添加操作：v.addElement(Object obj)
            /*jdk5.0之前：
            Integer inScore = new Integer(score);
            v.addElement(inScore);//多态*/
            //jdk5.0之后:
            v.addElement(score);//自动装箱
            //4.获取学生成绩的最大值
            if (maxScore < score){
                maxScore = score;
            }
        }
        char level;
        //5.遍历Vector,得到每个学生的成绩，并于最大成绩比较，得到每个学生的等级。
        for (int i = 0; i < v.size(); i++){
            Object obj = v.elementAt(i);
            //jdk5.0后
            int score = (int)obj;

            if (maxScore - score <= 10){
                level = 'A';
            }else if (maxScore - score <= 20) {
                level = 'B';
            }else if (maxScore - score <= 30) {
                level = 'C';
            }else{
                level = 'D';
            }

            System.out.println("student-" + i + " score is " + score+ ",level is " + level);
        }
    }
}
