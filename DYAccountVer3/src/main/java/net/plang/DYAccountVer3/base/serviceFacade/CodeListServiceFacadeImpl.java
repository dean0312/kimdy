package net.plang.DYAccountVer3.base.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.base.applicationService.CodeListApplicationService;
import net.plang.DYAccountVer3.base.to.CodeBean;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;
@Service
public class CodeListServiceFacadeImpl implements CodeListServiceFacade {
	@Autowired
    private CodeListApplicationService codeListApplicationService;

    @Override
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param) {
        return codeListApplicationService.getDetailCodeList(param);
    }

    @Override
    public ArrayList<CodeBean> findCodeList() {
        return codeListApplicationService.findCodeList();
    }

   
}
