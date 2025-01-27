package repository;

import models.Gate;

import java.util.Optional;

public interface IGateRepository {
    public Optional<Gate> findByGateId(long GateId);
}
