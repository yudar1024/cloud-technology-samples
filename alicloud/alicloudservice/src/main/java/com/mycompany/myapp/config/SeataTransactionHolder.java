package com.mycompany.myapp.config;

import io.seata.tm.api.GlobalTransaction;

public class SeataTransactionHolder {

    private static final ThreadLocal<GlobalTransaction> CONTEXT = new ThreadLocal();

    SeataTransactionHolder() {
    }

    static void set(GlobalTransaction transaction) {
        CONTEXT.set(transaction);
    }

    static GlobalTransaction get() {
        return (GlobalTransaction)CONTEXT.get();
    }

    static void clear() {
        CONTEXT.remove();
    }
}
