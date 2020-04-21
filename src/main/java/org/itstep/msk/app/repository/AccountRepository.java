package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {
}
