package com.mwx.springboot.controller;



import com.mwx.springboot.service.GroupBuyingMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GroupPurchaseItem;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/groupBuy")
public class GroupBuyController {


    @Autowired
    GroupBuyingMS groupBuyingMS;

    @RequestMapping("/getAllCommodities")
    public List<GroupPurchaseItem> getAllCommodities() throws RemoteException {
       return groupBuyingMS.listGroupPurchase();
    }


    @RequestMapping("/submitOrder")
    public boolean submitPurchase(@RequestParam(value = "commodityId", required = false) String commodityId,
                                  @RequestParam(value = "bankAccount", required = false) String bankAccount,
                                  @RequestParam(value = "password", required = false) String password,
                                  @RequestParam(value = "phoneNumber", required = false) String phoneNumber) throws RemoteException {

       // System.out.println(commodityId+" "+bankAccount+" "+password+" "+phoneNumber);
        return groupBuyingMS.submitPurchase(commodityId,bankAccount,password,phoneNumber);
    }



}
