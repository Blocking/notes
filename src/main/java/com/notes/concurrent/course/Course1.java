package com.notes.concurrent.course;


import lombok.Getter;

/**
 * @author zhangxiaoyu
 * @date 2021/2/22
 */
public class Course1 {

    /**
     * 存在cpu缓存 所以无限趋近于循环的值
     * @throws InterruptedException
     */
    @org.junit.Test
    public void test() throws InterruptedException {
        Test test = new Test();
        final Thread thread1 = new Thread(() -> test.add());
        final Thread thread2 = new Thread(() -> test.add());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(test.getCount());
    }

    @org.junit.Test
    public void test_volatile() throws InterruptedException {
        Test test = new Test();
        final Thread thread1 = new Thread(() -> test.add_volatile());
        final Thread thread2 = new Thread(() -> test.add_volatile());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(test.getCount_volatile());
    }


    @Getter
    class Test {
        private int count = 0;

        private volatile int count_volatile = 0;

        public void add(){
            for (int i = 0; i < 10_000_000; i++) {
                count +=1;
            }
        }
        public void add_volatile(){
            for (int i = 0; i < 10_000_000; i++) {
                count_volatile +=1;
            }
        }
    }

}
