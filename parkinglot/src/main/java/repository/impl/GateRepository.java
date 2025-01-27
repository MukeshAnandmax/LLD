package repository.impl;

import models.Gate;
import repository.IGateRepository;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository  implements IGateRepository {

    private final Map<Long,Gate> gates =  new TreeMap<>();

    public Optional<Gate> findByGateId(long gateId){

        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }

        return Optional.empty();
    }

}
