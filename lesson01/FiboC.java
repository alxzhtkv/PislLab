package by.it.a_khmelev.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.Vector;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано

        Vector<Integer> s= new Vector<>(2);
        s.add(0,0);
        s.add(1,1);
        int k=0;
        for(int j=2;j<m*m+1;j++){
            s.add(j,(s.get(j - 1) + s.get(j - 2)) % m);

            k++;
            if(s.get(j)==1 && s.get(j - 1)==0)
                break;

        }

        System.out.println("P= "+k);
        return s.get(Math.toIntExact((n % k)));
    }


}

