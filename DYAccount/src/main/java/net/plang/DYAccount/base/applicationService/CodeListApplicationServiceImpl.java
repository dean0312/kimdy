package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccount.base.dao.CodeDAO;
import net.plang.DYAccount.base.dao.CodeDAOImpl;
import net.plang.DYAccount.base.dao.DetailCodeDAO;
import net.plang.DYAccount.base.dao.DetailCodeDAOImpl;
import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.base.to.DetailCodeBean;

public class CodeListApplicationServiceImpl implements CodeListApplicationService {
    private CodeDAO codeDAO;
    private DetailCodeDAO detailCodeDAO;

    @Override
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param) {
        return detailCodeDAO.selectDetailCodeList(param);
    }

    @Override
    public ArrayList<CodeBean> findCodeList() {
        return codeDAO.selectCodeList();
    }

    public void setCodeDAO(CodeDAO codeDAO) {
        this.codeDAO = codeDAO;
    }

    public void setDetailCodeDAO(DetailCodeDAO detailCodeDAO) {
        this.detailCodeDAO = detailCodeDAO;
    }
}
