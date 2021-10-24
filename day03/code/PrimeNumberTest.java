class PrimeNumberTest {
    public static void main(String[] args) {

            boolean isFlag = true;

            //获取当前时间距离的毫秒数
            long start = System.currentTimeMillis();

            for (int i = 2; i <= 100000; i++) {

                //优化二：对本身是质数的自然数是有效的。
                for (int j = 2; j <= Math.sqrt(i); j++) {

                    if (i % j == 0) {
                        isFlag = false;
                        break;//优化一：只对本身非素数的自然数是有效的。
                    }

                    if (isFlag == true) {
                        System.out.println(i);
                    }
                }
            }


            //重置isFlag
            isFlag = true;


            //获取当前时间距离的毫秒数
            long end = System.currentTimeMillis();

            System.out.println("所花费的时间为：" + (end - start));
        }     
}