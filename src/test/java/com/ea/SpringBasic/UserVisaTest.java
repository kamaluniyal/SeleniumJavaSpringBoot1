package com.ea.SpringBasic;

import com.ea.SpringBasic.Page.visa.VisaRegistrationPage;
import com.ea.SpringBasic.entity.User;
import com.ea.SpringBasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private VisaRegistrationPage registrationPage;

//    @Test
//    public void visaTest(){
//        System.out.println(
//                this.repository.findAll().size()
//        );
//
//    this.repository.findById(85)
//        .ifPresent(u-> System.out.println(u.getFirstName()));
//
//    }

    @Test
    public void visaTest(){
        List<User> users = this.repository.findAll()
                                .stream()
                                .limit(3)
                                .collect(Collectors.toList());


        for (User u: users ) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            System.out.println(
                    this.registrationPage.getConfirmationNumber()
            );

        }
    }
}
