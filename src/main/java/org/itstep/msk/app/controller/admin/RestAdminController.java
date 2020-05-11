package org.itstep.msk.app.controller.admin;



import org.itstep.msk.app.entity.Account;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.enums.Role;
import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.itstep.msk.app.entity.numberСard.ProductNumber;
import org.itstep.msk.app.repository.UserRepository;
import org.itstep.msk.app.repository.modelFormApplicationRepository.ModelFormPassportRepository;
import org.itstep.msk.app.repository.СardProductNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class RestAdminController {
    @Autowired
    ModelFormPassportRepository modelFormPassportRepository;

    @Autowired
    СardProductNumberRepository cRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/listCaps")
    public List<ProductNumber> getListCaps() {
        return cRepository.findAll();
    }

    @GetMapping("/listClient")
    public List getListClient() {
        List<User> list = userRepository.findAll();
        List<SimpleUser> list1 = new ArrayList<>();

        for (User itVar : list) {
            list1.add(
                    new SimpleUser(
                            itVar.getId(),
                            itVar.getUsername()
                    )
            );
        }
        return list1;
    }

    @GetMapping("/formApplications")
    public List formApplications(){
        List list = modelFormPassportRepository.findAll();
        return list;
    }

    private class SimpleUser {
        public Integer id;
        public String username;
        public SimpleUser(int id, String username) {
            this.id = id;
            this.username = username;
        }
    }
}