package by.it.a_khmelev.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        if(n==1 || n==2)
            return BigInteger.ONE;
        else if (n==0)
            return BigInteger.ZERO;
        else {
            ArrayList<BigInteger> arr = new ArrayList<>(n+1);
            arr.add(0,BigInteger.ZERO);
            arr.add(1,BigInteger.ONE);
            arr.add(2,BigInteger.ONE);
            for (int i=3;i<=n;i++){
                arr.add(i,arr.get(i-1).add(arr.get(i-2)));
            }
            return arr.get(n);

        }
    }

}

