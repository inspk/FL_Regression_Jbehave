package com.hhstechgroup.util.common;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.apache.log4j.Logger;
import org.awaitility.core.ConditionTimeoutException;

import static org.awaitility.Awaitility.*;


public class Wait {

    private static long timeout;
    private static long pollingInterval;
    private static final long DEFAULT_POLLING_INTERVAL = 1;
    private static final long DEFAULT_TIMEOUT = 10;
    private static final Logger logger = Logger.getLogger(Wait.class);

    public Wait() {
        this(DEFAULT_TIMEOUT, DEFAULT_POLLING_INTERVAL);
    }

    public Wait(long timeout) {
        this(timeout, DEFAULT_POLLING_INTERVAL);
    }

    public Wait(long timeout, long pollingInterval) {
        Wait.timeout = timeout;
        Wait.pollingInterval = pollingInterval;
    }

    public void waitForCondition(Callable<Boolean> condition) {
        await().atMost(timeout, TimeUnit.SECONDS).pollInterval(pollingInterval, TimeUnit.SECONDS).until(condition);
    }

    public static <T> void waitForCondition(Predicate<T> condition, T value) {
        long start = System.currentTimeMillis();
        while (!condition.test(value)) {
            if (System.currentTimeMillis() - start > TimeUnit.SECONDS.toMillis(timeout)) {
                logger.error(String.format("Condition not meet within %s s", timeout));
                throw new ConditionTimeoutException(String.format("Condition not meet within %s s", timeout));
            } else {
                try {
                    Thread.sleep(pollingInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T, V> void waitForCondition(BiPredicate<T, V> condition, T value1, V value2) {
        long start = System.currentTimeMillis();
        while (!condition.test(value1, value2)) {
            if (System.currentTimeMillis() - start > TimeUnit.SECONDS.toMillis(timeout)) {
                logger.error(String.format("Condition not meet within %s ms", timeout));
                throw new ConditionTimeoutException(String.format("Condition not meet within %s ms", timeout));
            } else {
                try {
                    Thread.sleep(pollingInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
