package com.grandcircus.spring.controller;

import com.grandcircus.spring.models.CustomersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by USER on 5/8/2017.
 */


@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView listCustomers() {
        ArrayList<CustomersEntity> customerList = getCustomersEntities();



/* //welcome is jsp welcome page -- hello is -- hello world is
   // if you use modelAndView give return OR
   //model.addAttribute("cList, customerList");
   //public String helloWorld(Model model)   return "welcome";
*/
        return new ModelAndView("welcome", "cList", customerList);
    }


//delete customer

    //before delete if you want you can add / on it---localhost:8080/delete
//add to the parameter  (@RequestParam("id")String id)
    @RequestMapping("/delete")
    public ModelAndView deleteCustomers(@RequestParam("id") String id) {

//temp customerEntity object will store info that we want to delete
        CustomersEntity temp = new CustomersEntity();
        temp.setCustomerId(id);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");//copy from up

        SessionFactory sessionFact = cfg.buildSessionFactory();//copy from up

        Session selectCustomers = sessionFact.openSession();//copy from up then that is move to down

        selectCustomers.beginTransaction();//copy from up

        selectCustomers.delete(temp);//delete the object from the list--temp is object

        selectCustomers.getTransaction().commit();//delete the row from the DB

        ArrayList<CustomersEntity> customerList = getCustomersEntities();


        return new ModelAndView("welcome", "cList", customerList);
    }


    //adding customer
    @RequestMapping("addCustomer")
    public ModelAndView addCust(@RequestParam("custID") String custid,
                                @RequestParam("compName") String companyN,
                                @RequestParam("contName")
                                        String contactN,
                                @RequestParam("contTitle")
                                        String contactT,
                                @RequestParam("address")
                                        String address,
                                @RequestParam("city")
                                        String city,
                                @RequestParam("region")
                                        String reg,
                                @RequestParam("pCode")
                                        String postCode,
                                @RequestParam("country")
                                        String countr,
                                @RequestParam("phone")
                                        String phoneN,
                                @RequestParam("fax")
                                        String fx)

    {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");//copy from up

        SessionFactory sessionFact = cfg.buildSessionFactory();//copy from up
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        CustomersEntity newCust = new CustomersEntity();

        newCust.setCustomerId(custid);
        newCust.setCompanyName(companyN);
        newCust.setContactName(contactN);
        newCust.setContactTitle(contactT);
        newCust.setAddress(address);
        newCust.setCity(city);
        newCust.setRegion(reg);
        newCust.setPostalCode(postCode);
        newCust.setCountry(countr);
        newCust.setPhone(phoneN);
        newCust.setFax(fx);


        session.save(newCust);
        tx.commit();
        session.close();


        return new ModelAndView("addACus", "addingCust", "");
    }


  @RequestMapping("getNewCustomer")
  public ModelAndView newCust(){
        return new ModelAndView("addACustomer","adding Cust","");
  }




    //this is a regular method that was extracted to use over and over again
    public ArrayList<CustomersEntity> getCustomersEntities() {
        //this defines the Configuration & mapping resources
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        //sessionFactory
        SessionFactory sessionFact = cfg.buildSessionFactory();

//
        Session selectCustomers = sessionFact.openSession();

        selectCustomers.beginTransaction();
//Criteria going to do search property -- CustomerEntity is Object
        Criteria c = selectCustomers.createCriteria(CustomersEntity.class);

//Create Arraylist -- casting the list to in arraylist or customersEntity
        return (ArrayList<CustomersEntity>) c.list();
    }


}

