package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccountVer3.base.to.CodeBean;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;

public interface CodeListApplicationService {

    ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param);

    ArrayList<CodeBean> findCodeList();

}
