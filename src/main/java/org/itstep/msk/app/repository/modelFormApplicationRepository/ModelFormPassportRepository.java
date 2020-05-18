package org.itstep.msk.app.repository.modelFormApplicationRepository;

import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelFormPassportRepository extends JpaRepository<ModelFormPassport, Integer> {
    ModelFormPassport findByMail (String mail);
}
