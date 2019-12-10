package net.plang.DYAccountVer3.company.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.company.to.DetailBusinessBean;
@Mapper
public interface DetailBusinessDAO {

	public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode);
}
