package net.plang.DYAccount.company.dao;

import java.util.ArrayList;

import net.plang.DYAccount.company.to.DetailBusinessBean;

public interface DetailBusinessDAO {

	public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode);
}
