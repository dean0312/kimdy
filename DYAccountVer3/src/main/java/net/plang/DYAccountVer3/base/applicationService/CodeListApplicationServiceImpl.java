package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.base.dao.CodeDAO;
import net.plang.DYAccountVer3.base.dao.DetailCodeDAO;
import net.plang.DYAccountVer3.base.to.CodeBean;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;

@Component
@Transactional
public class CodeListApplicationServiceImpl implements CodeListApplicationService {
	@Autowired
	private CodeDAO codeDAO;
	@Autowired
	private DetailCodeDAO detailCodeDAO;

	@Override
	public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, String> param) {
		
		return detailCodeDAO.selectDetailCodeList(param);
	}

	@Override
	public ArrayList<CodeBean> findCodeList() {
		return codeDAO.selectCodeList();
	}

}
