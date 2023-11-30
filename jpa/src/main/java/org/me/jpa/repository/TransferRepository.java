package org.me.jpa.repository;

import org.me.jpa.model.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Integer> {
}
