package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.numberСard.PaymentSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Integer> {
}
