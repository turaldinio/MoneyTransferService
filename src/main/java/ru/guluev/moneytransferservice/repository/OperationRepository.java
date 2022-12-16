package ru.guluev.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OperationRepository {
    private ConcurrentHashMap<Integer, Operation> map = new ConcurrentHashMap<>();

    public Operation getValueByKey(int id) {
        return map.computeIfAbsent(id, (x) -> {
            throw new ErrorConfirmation("Error confirm operation");
        });
    }

    public void addNewOperation( Operation operation) {
        map.put(Integer.valueOf(operation.getOperationId()), operation);
    }

    public ConcurrentHashMap<Integer, Operation> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<Integer, Operation> map) {
        this.map = map;
    }
}
