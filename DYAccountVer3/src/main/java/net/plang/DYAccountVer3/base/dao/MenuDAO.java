package net.plang.DYAccountVer3.base.dao;

import java.util.ArrayList;

import net.plang.DYAccountVer3.base.to.MenuBean;

public interface MenuDAO {
    ArrayList<MenuBean> selectMenuList(String empCode);

    ArrayList<MenuBean> selectAllMenuList();

}
