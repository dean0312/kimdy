package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.base.to.DetailCodeBean;

public interface CodeListApplicationService {

    ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param);

    ArrayList<CodeBean> findCodeList();

}
