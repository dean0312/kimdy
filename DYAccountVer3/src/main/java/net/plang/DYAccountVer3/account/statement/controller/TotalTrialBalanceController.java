package net.plang.DYAccountVer3.account.statement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.plang.DYAccountVer3.account.statement.serviceFacade.StatementServiceFacade;

import java.util.HashMap;

@RestController
public class TotalTrialBalanceController {
	@Autowired
	private StatementServiceFacade statementServiceFacade;

	@RequestMapping(value = "statement/TotalTrialBalance", method = RequestMethod.GET)
	public Object getTotalTrialBalance(@RequestParam String toDate) {



		return statementServiceFacade.getTotalTrialBalance(toDate);

	}

}