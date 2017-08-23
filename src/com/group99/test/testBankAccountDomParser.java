package com.group99.test;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.xml.sax.SAXException;

import com.group99.dom.BankAccountDomParser;
import com.group99.javabean.BankAccount;

public class testBankAccountDomParser {
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(testBankAccountDomParser.class);
		for(Failure failure : result.getFailures()){
			System.out.println(failure);
		}
	}

	@Test
	public void testBankAccount(){
		
		String password = null;
		try {
			List<BankAccount> bankAccounts = BankAccountDomParser.getBankAccounts();
			for(BankAccount bankAccount : bankAccounts ){
				if("00011001".equals(bankAccount.getAccountNum())){
					password = bankAccount.getAccountPassword();
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("error!",password,"p01");
	}
}
