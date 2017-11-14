package com.makeronly.common.snowflake;

import org.springframework.beans.factory.annotation.Value;

/**
 * 主键生成器
 * @author Walter Wong
 * @date 2017-10-26
 */
public enum IdGenerator {
    INSTANCE;
    private final IdWorker worker;
    @Value("${workerId}")
    private long workerId;
    @Value("${datacenterId}")
    private long datacenterId;
    IdGenerator(){
        worker = new IdWorker(workerId, datacenterId);
    }

    public long getId(){
        return worker.nextId();
    }
}
