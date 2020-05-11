package org.itstep.msk.app.controller.admin;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.documentsUser.Passport;
import org.itstep.msk.app.entity.documentsUser.contactInformation.ContactInformation;
import org.itstep.msk.app.entity.documentsUser.contactInformation.UserAddress;
import org.itstep.msk.app.entity.documentsUser.contactInformation.UserMail;
import org.itstep.msk.app.entity.documentsUser.contactInformation.UserTelephone;
import org.itstep.msk.app.entity.enums.Role;
import org.itstep.msk.app.entity.enums.StatusAddress;
import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.itstep.msk.app.repository.UserRepository;
import org.itstep.msk.app.repository.documentsUserRepository.ContactInformationRepository;
import org.itstep.msk.app.repository.documentsUserRepository.UserAddressRepository;
import org.itstep.msk.app.repository.documentsUserRepository.UserMailRepository;
import org.itstep.msk.app.repository.documentsUserRepository.UserTelephoneRepository;
import org.itstep.msk.app.repository.modelFormApplicationRepository.ModelFormPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ModelFormPassportRepository modelFormPassportRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContactInformationRepository contactInformationRepository;

    @Autowired
    UserMailRepository userMailRepository;

    @Autowired
    UserTelephoneRepository userTelephoneRepository;

    @Autowired
    UserAddressRepository userAddressRepository;

    @GetMapping("/")
    public String adminIndex(Model model){
        return "admin/admin";
    }

    @GetMapping("/processingApplicationForm/{id}")
    public String processingApplicationForm(@PathVariable(name = "id") ModelFormPassport form, Model model){
        if (form == null) form = new ModelFormPassport();
        model.addAttribute("form",form);
        return "admin/processingApplicationForm";
    }

    @RequestMapping(value="/processingApplicationForm", method= RequestMethod.POST)
    public String processingApplicationForm(@ModelAttribute ModelFormPassport form){
        User user = new User();
        ContactInformation contactInformation = new ContactInformation();
        UserAddress address = new UserAddress();
        UserMail mail = new UserMail();
        UserTelephone telephone = new UserTelephone();
        Passport passport = new Passport();

        user.setUsername(form.getName());
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.saveAndFlush(user);

        contactInformation = new ContactInformation();
        contactInformation.setUser(userRepository.findByUsername(user.getUsername()));
        contactInformation.setName(form.getName());
        contactInformation.setSurname(form.getSurname());
        contactInformation.setPatronymic(form.getPatronymic());
        contactInformationRepository.saveAndFlush(contactInformation);

        mail.setNameMail(form.getMail());
        mail.setContactInformation(contactInformationRepository.findByUser(userRepository.findByUsername(form.getMail())));
        userMailRepository.saveAndFlush(mail);

        telephone.setNumber(form.getTelephone());
        telephone.setContactInformation(contactInformationRepository.findByUser(userRepository.findByUsername(form.getMail())));
        userTelephoneRepository.saveAndFlush(telephone);

        address.setApartment(form.getApartment());
        address.setBuilding(form.getBuilding());
        address.setCity(form.getCity());
        address.setHouse(form.getHouse());
        address.setIndex(form.getIndex());
        address.setRegion(form.getRegion());
        address.setStatusAddress(StatusAddress.REGISTRATION);
        address.setStreet(form.getStreet());
        address.setContactInformation(userRepository.findByUsername(form.getMail()).getContactInformation());
        userAddressRepository.saveAndFlush(address);
        


        return "redirect:/admin/";
    }
}
