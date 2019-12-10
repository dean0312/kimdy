package net.plang.DYAccountVer3.base.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.base.to.DetailCodeBean;
@Mapper
public interface DetailCodeDAO {

    ArrayList<DetailCodeBean> selectDetailCodeList(HashMap<String, String> param);

    void insertDetailCode(DetailCodeBean codeDetailBean);

    void updateDetailCode(DetailCodeBean codeDetailBean);

    void deleteDetailCode(String codeNo);

}
