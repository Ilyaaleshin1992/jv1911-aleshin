package org.itstep.msk.app.repository.documentsUserRepository;

import org.itstep.msk.app.entity.documentsUser.contactInformation.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
    UserAddress findByOwnerMail (String ownerMail);
}