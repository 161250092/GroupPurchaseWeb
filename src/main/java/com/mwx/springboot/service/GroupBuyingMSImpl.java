package com.mwx.springboot.service;


import entity.GroupPurchaseItem;
import org.springframework.stereotype.Service;
import service.GroupPurchaseManagementSystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


@Service
public class GroupBuyingMSImpl implements GroupBuyingMS {
//
    private static GroupPurchaseManagementSystem groupPurchaseManagementSystem;
    private static String location ="rmi://localhost:1099";

    static {

        try {
            System.setSecurityManager(new java.rmi.RMISecurityManager());

            groupPurchaseManagementSystem = (GroupPurchaseManagementSystem) Naming.lookup(location+"/GroupPurchaseManagementSystem");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


//    @Autowired
//    private GroupPurchaseManagementSystem groupPurchaseManagementSystem;


    @Override
    public List<GroupPurchaseItem> listGroupPurchase() throws RemoteException {
        return groupPurchaseManagementSystem.listGroupPurchase();
    }

    @Override
    public boolean submitPurchase(String commodityId, String bankAccount, String password, String phoneNumber) throws RemoteException {
        return groupPurchaseManagementSystem.submitPurchase(commodityId,bankAccount,password,phoneNumber);
    }


}
