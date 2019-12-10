package net.plang.DYAccountVer3.base.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccountVer3.base.to.CodeBean;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;

public interface CodeListServiceFacade {
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param);

    public ArrayList<CodeBean> findCodeList();
}
