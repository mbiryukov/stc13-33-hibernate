package ru.innopolis.stc13.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc13.hibernate.db.dao.MobilePhoneDao;
import ru.innopolis.stc13.hibernate.db.entities.MobilePhone;

@Controller
public class PhoneController {

    private MobilePhoneDao mobilePhoneDao;

    @Autowired
    public void setMobilePhoneDao(MobilePhoneDao mobilePhoneDao) {
        this.mobilePhoneDao = mobilePhoneDao;
    }

    @RequestMapping(value = "/getPhone", method = RequestMethod.GET)
    public String getAllPhones(Model model) {
        model.addAttribute("phone", mobilePhoneDao.getPhoneById(1));
        return "data";
    }

    @RequestMapping(value = "/createPhone", method = RequestMethod.GET)
    public String createPhone(Model model) {
        MobilePhone phone = new MobilePhone(1L, "Siemens m35", 20000, "Siemens");
        mobilePhoneDao.addPhone(phone);
        model.addAttribute("phone", phone);
        return "data";
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.GET)
    public String updatePhone(Model model) {
        MobilePhone phone = mobilePhoneDao.getPhoneById(1);
        phone.setCost(25000);
        mobilePhoneDao.updatePhone(phone);
        model.addAttribute("phone", phone);
        return "data";
    }


    @RequestMapping(value = "/deletePhone", method = RequestMethod.GET)
    public String deletePhone(Model model) {
        mobilePhoneDao.deletePhoneById(1L);
        model.addAttribute("phone", mobilePhoneDao.getPhoneById(1));
        return "data";
    }
}
