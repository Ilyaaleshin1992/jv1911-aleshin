package org.itstep.msk.app.repository.documentsUserRepository;

import org.itstep.msk.app.entity.documentsUser.contactInformation.UserAddress;
import org.itstep.msk.app.entity.documentsUser.contactInformation.UserTelephone;
import org.itstep.msk.app.entity.numberСard.PaymentSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTelephoneRepository extends JpaRepository<UserTelephone, Integer> {
    UserTelephone findByNumber(String numbers);
}