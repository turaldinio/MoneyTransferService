package ru.guluev.moneytransferservice.repository;

import ru.guluev.moneytransferservice.beans.Operation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationRepository {
    private ConcurrentHashMap<AtomicInteger, Operation> map = new ConcurrentHashMap<>();


    public ConcurrentHashMap<AtomicInteger, Operation> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<AtomicInteger, Operation> map) {
        this.map = map;
    }
}
