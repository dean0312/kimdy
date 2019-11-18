package net.plang.DYAccount.base.dao;

import java.util.ArrayList;

import net.plang.DYAccount.base.to.MenuBean;

public interface MenuDAO {
    ArrayList<MenuBean> selectMenuList(String empCode);

    ArrayList<MenuBean> selectAllMenuList();

}
