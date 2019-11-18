package net.plang.DYAccount.company.dao;

import java.util.ArrayList;

import net.plang.DYAccount.company.to.BusinessBean;


public interface BusinessDAO {

    public ArrayList<BusinessBean> selectBusinessList();

}
