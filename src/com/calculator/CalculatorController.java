package com.calculator;

import com.calculator.CalculatorModel.CalculatorModelControllerCallBack;

public class CalculatorController implements CalculatorControllerCallBack,CalculatorModelControllerCallBack{

	private CalculatorViewCallBack view;
	private CalculatorModelCallBack model;
	
	CalculatorController(CalculatorView view ){
		this.view=view;
		model=new CalculatorModel(this);
	}

	@Override
	public void addNumber(float number) {
		model.addNumber(number);
	}

	@Override
	public void addition() {
	model.addition();	
	}

	@Override
	public void result(String soln,float result) {
		view.result(soln,result);
	}

	@Override
	public void subNumber(float parseFloat) {
		model.subtraction();
	}

	@Override
	public void divNumber(float parseFloat) {
		model.division();
	}

	@Override
	public void mulNumber(float parseFloat) {
		model.multiplication();
	}

	@Override
	public void expression(String expression) {
		model.expression(expression);
	}

	@Override
	public void result(String result, String expression) {
		view.result(result, expression);
	}
	
}