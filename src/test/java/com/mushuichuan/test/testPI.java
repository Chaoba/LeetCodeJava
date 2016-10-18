package com.mushuichuan.test;

import com.mushuichuan.PI;
import org.junit.Test;
import rx.functions.Action1;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

/**
 * Created by yanshun.li on 10/18/16.
 */
public class testPI {
    final static double PiValue = 3.14159265;

    @Test
    public void test1() {
        final CountDownLatch latch = new CountDownLatch(1);
        PI pi = new PI();
        final double[] result = {0};
        pi.getPi(4, 1000000)
                .subscribe(new Action1<Double>() {
                    public void call(Double aDouble) {
                        System.out.print(aDouble);
                        result[0] = aDouble;

                        latch.countDown();
                    }
                });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(PiValue, result[0], 0.001);
    }
}
