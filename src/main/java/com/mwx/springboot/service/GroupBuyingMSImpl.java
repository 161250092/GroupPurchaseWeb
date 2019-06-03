package com.mwx.springboot.service;



import org.springframework.stereotype.Service;
import service.GroupPurchase4Web;
import service.GroupPurchaseItem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


@Service
public class GroupBuyingMSImpl implements GroupBuyingMS {
//
    private static GroupPurchase4Web groupPurchaseManagementSystem;
    private static String ipAddress = "172.17.161.112";
    private static int port =8080;
    private static String location ="rmi://"+ipAddress+":"+port;
    static {

        try {
            System.setSecurityManager(new java.rmi.RMISecurityManager());
            groupPurchaseManagementSystem = (GroupPurchase4Web) Naming.lookup(location+"/groupPurchase4Web");
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
