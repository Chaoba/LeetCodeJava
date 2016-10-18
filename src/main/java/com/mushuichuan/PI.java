package com.mushuichuan;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.FuncN;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Random;

/**
 * Use map and reduce in Rxjava to calculate the value of PI.
 * Created by yanshun.li on 10/17/16.
 */
public class PI {
    private Random mRandom = new Random();

    private Observable<Double> createObservable(final int num) {
        return Observable.range(0, num)
                .map(new Func1<Integer, Integer>() {
                    public Integer call(Integer integer) {
                        double x = mRandom.nextDouble() * 2 - 1;
                        double y = mRandom.nextDouble() * 2 - 1;
                        return (x * x + y * y) < 1 ? 1 : 0;
                    }
                }).reduce(new Func2<Integer, Integer, Integer>() {
                    public Integer call(Integer integer, Integer integer2) {
                        int reduce = integer + integer2;
                        return reduce;
                    }
                })
                .map(new Func1<Integer, Double>() {
                    public Double call(Integer integer) {
                        double v = 4.0 * integer / num;
                        System.out.println("V:" + v);
                        return v;
                    }
                })
                .subscribeOn(Schedulers.computation());

    }

    public Observable<Double> getPi(int workNum, int num) {
        ArrayList<Observable<Double>> list = new ArrayList<Observable<Double>>(workNum);
        for (int i = 0; i < workNum; i++) {
            list.add(createObservable(num));
        }
        //use zip to get the average value of all workers.
        return Observable.zip(list, new FuncN<Double>() {
            public Double call(Object... args) {
                int len = args.length;
                double result = 0;
                for (int i = 0; i < len; i++) {
                    result += (Double) (args[i]);
                }
                return result / len;
            }
        });

    }
}
