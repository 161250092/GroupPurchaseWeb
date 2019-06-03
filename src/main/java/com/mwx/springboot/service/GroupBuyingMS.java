package com.mwx.springboot.service;


import entity.GroupPurchaseItem;

import java.rmi.RemoteException;
import java.util.List;


public interface GroupBuyingMS {
    List<GroupPurchaseItem> listGroupPurchase() throws RemoteException;

    boolean submitPurchase(String commodityId, String bankAccount, String password, String phoneNumber) throws RemoteException;



}
