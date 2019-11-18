package net.plang.DYAccount.base.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.base.to.DetailCodeBean;

public interface CodeListServiceFacade {
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param);

    public ArrayList<CodeBean> findCodeList();
}
