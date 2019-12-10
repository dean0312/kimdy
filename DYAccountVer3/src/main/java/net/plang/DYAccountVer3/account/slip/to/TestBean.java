package net.plang.DYAccountVer3.account.slip.to;

import java.util.ArrayList;

import net.plang.DYAccountVer3.base.to.BaseBean;

public class TestBean extends BaseBean {
	private ArrayList<JournalBean> journalObj;
	private ArrayList<SlipBean> slipObj;

	public ArrayList<JournalBean> getJournalObj() {
		return journalObj;
	}

	public void setJournalObj(ArrayList<JournalBean> journalObj) {
		this.journalObj = journalObj;
	}

	public ArrayList<SlipBean> getSlipObj() {
		return slipObj;
	}

	public void setSlipObj(ArrayList<SlipBean> slipObj) {
		this.slipObj = slipObj;
	}
}
