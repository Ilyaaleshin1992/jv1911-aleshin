package org.itstep.msk.app.repository.documentsUserRepository;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.documentsUser.contactInformation.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Integer> {
    ContactInformation findByUser(User user);
}
