package net.plang.DYAccount.base.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccount.base.applicationService.CodeListApplicationService;
import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.base.to.DetailCodeBean;

public class CodeListServiceFacadeImpl implements CodeListServiceFacade {
    private CodeListApplicationService codeListApplicationService;

    @Override
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param) {
        return codeListApplicationService.getDetailCodeList(param);
    }

    @Override
    public ArrayList<CodeBean> findCodeList() {
        return codeListApplicationService.findCodeList();
    }

    public void setCodeListApplicationService(CodeListApplicationService codeListApplicationService) {
        this.codeListApplicationService = codeListApplicationService;
    }
}
