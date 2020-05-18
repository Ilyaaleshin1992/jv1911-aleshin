package org.itstep.msk.app.repository.documentsUserRepository;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.documentsUser.contactInformation.UserMail;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface UserMailRepository extends JpaRepository<UserMail, Integer> {
  UserMail findByNameMail(String nameMail);
}