package net.plang.DYAccount.base.dao;

import java.util.ArrayList;

import net.plang.DYAccount.base.to.CodeBean;

public interface CodeDAO {

    public ArrayList<CodeBean> selectCodeList();

    public void insertCode(CodeBean codeBean);

    public void updateCode(CodeBean codeBean);

    public void deleteCode(String Code);

}
