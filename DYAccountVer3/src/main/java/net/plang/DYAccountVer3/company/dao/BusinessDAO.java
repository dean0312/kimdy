package net.plang.DYAccountVer3.company.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.company.to.BusinessBean;

@Mapper
public interface BusinessDAO {

    public ArrayList<BusinessBean> selectBusinessList();

}
