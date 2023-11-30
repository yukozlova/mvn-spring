package org.me.jdbc.repository;

import org.me.jdbc.model.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Integer> {
}
