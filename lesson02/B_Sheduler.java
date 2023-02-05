package by.it.a_khmelev.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
даны интервальные события events
реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event  implements Comparable{
        int start;
        int stop;

        public int getStart() {
            return start;
        }

        public int getStop() {
            return stop;
        }

        public int getTime(){
            return stop-start;
        }

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }

        @Override
        public int compareTo(Object obj) {
            Event tmp=(Event) obj;

            int flag = this.stop-this.start;
            if(flag==0){
                if(this.stop - this.start<tmp.stop- tmp.start){
                    flag = -1;
                }
                else if (this.stop - this.start>tmp.stop- tmp.start){
                    flag = 1;
                }

            }
            return flag;




//            if(this.stop - this.start<tmp.stop- tmp.start){
//                return -1;
//            }
//            else if (this.stop - this.start>tmp.stop- tmp.start){
//                return 1;
//            }
//            return 0;

        }
    }

    public static void main(String[] args) {
        B_Sheduler instance = new B_Sheduler();
        Event[] events = {  new Event(0, 3),  new Event(0, 1), new Event(1, 2), new Event(3, 5),
                new Event(1, 3),  new Event(1, 3), new Event(1, 3), new Event(3, 6),
                new Event(2, 7),  new Event(2, 3), new Event(2, 7), new Event(7, 9),
                new Event(3, 5),  new Event(2, 4), new Event(2, 3), new Event(3, 7),
                new Event(4, 5),  new Event(6, 7), new Event(6, 9), new Event(7, 9),
                new Event(8, 9),  new Event(4, 6), new Event(8, 10), new Event(7, 10)
        };

        List<Event> starts = instance.calcStartTimes(events,0,10);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {

        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<Event> result;
        result = new ArrayList<>();
        //ваше решение.

//        Arrays.sort(events);







        int start=events[0].start;
        int end = events[0].stop;



        List<Event> sortedEvents = Arrays.asList(events);
        sortedEvents.sort(Comparator.comparing(Event::getStart).thenComparing(Event::getTime));

//        for (Event student : sortedEvents) {
//            System.out.println(student);
//        }

//        int t=0;
//        for (int i=0;i<events.length;i++){
//
//            if (t==0){
//                if (events[i].start==0){
//                    result.add(events[i]);
//                    t=t+(events[i].stop-events[i].start);
//                }
//            }
//            while(t<=10){
//
//            }
//        }



        int k=0;
        result.add(events[0]);

        for(int i = 1; i< events.length;i++){
            if(result.get(k).stop<=events[i].start){
                result.add(events[i]);
                k++;
            }
//            if((result.get(k).start == events[i].start) || (result.get(k).start<events[i].stop)  )
        }






        return result;                        //вернем итог
    }
}