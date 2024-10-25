package com.cg.topic10.el.operator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	//Relational operators
	
	@Value("#{1 == 1}") //true
	private boolean testEqual;
	
	@Value("#{1 != 1}") //false
	private boolean testNotEqual;
	
	@Value("#{1 < 1}") //false
	private boolean testLessThan;
	
	@Value("#{1 <= 1}") //true
	private boolean testLessThanOrEqual;
	
	@Value("#{1 > 1}") //false
	private boolean testGreaterThan;
	
	@Value("#{1 >= 1}") //true
	private boolean testGreaterThanOrEqual;

	//Logical operators , numberBean.no == 999
	
	@Value("#{numberBean.no == 999 and numberBean.no < 900}") //false
	private boolean testAnd;
	
	@Value("#{numberBean.no == 999 or numberBean.no < 900}") //true
	private boolean testOr;
	
	@Value("#{!(numberBean.no == 999)}") //false
	private boolean testNot;

	//Mathematical operators
	
	@Value("#{1 + 1}") //2.0
	private double testAdd;
	
	@Value("#{'1' + '@' + '1'}") //1@1
	private String testAddString;
	
	@Value("#{1 - 1}") //0.0
	private double testSubtraction;

	@Value("#{1 * 1}") //1.0
	private double testMultiplication;
	
	@Value("#{10 / 2}") //5.0
	private double testDivision;
	
	@Value("#{10 % 10}") //0.0
	private double testModulus ;
	
	@Value("#{2 ^ 2}") //4.0
	private double testExponentialPower;

	@Override
	public String toString() {
		return "Customer [testEqual=" + testEqual + ", testNotEqual="
				+ testNotEqual + ", testLessThan=" + testLessThan
				+ ", testLessThanOrEqual=" + testLessThanOrEqual
				+ ", testGreaterThan=" + testGreaterThan
				+ ", testGreaterThanOrEqual=" + testGreaterThanOrEqual
				+ ", testAnd=" + testAnd + ", testOr=" + testOr + ", testNot="
				+ testNot + ", testAdd=" + testAdd + ", testAddString="
				+ testAddString + ", testSubtraction=" + testSubtraction
				+ ", testMultiplication=" + testMultiplication
				+ ", testDivision=" + testDivision + ", testModulus="
				+ testModulus + ", testExponentialPower="
				+ testExponentialPower + "]";
	}
	
}

