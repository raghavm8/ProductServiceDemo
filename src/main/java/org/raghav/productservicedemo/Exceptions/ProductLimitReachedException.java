package org.raghav.productservicedemo.Exceptions;

public class ProductLimitReachedException extends Exception {
    public ProductLimitReachedException(String limitIsReached) {
        super(limitIsReached);
    }
}
