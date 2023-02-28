package com.calculator;

import java.util.Scanner;

public class CalculatorView implements CalculatorViewCallBack {

	private CalculatorControllerCallBack controller;
	private Scanner scanner = new Scanner(System.in);

	CalculatorView() {
		controller = new CalculatorController(this);
	}

	public static void main(String[] args) {
		new CalculatorView().calculator();
	}

	public void calculator() {
		System.out.println("Enter which operation you want");
		System.out.println("1.Addtion\n2.Subtraction\n3.Multiplication\n4.Division\n5.Mixed Operation\n6.Exit");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			addition();
			break;
		case 2:
			subtraction();
			break;
		case 3:
			multiplication();
			break;
		case 4:
			division();
			break;
		case 5:
			mixedOperation();
			break;
		case 6:
			System.out.println("\t\t\t\t\t\t\t---x---");
			return;
		default:
			System.out.println("Enter a valid number");
			calculator();
		}
	}

	private void mixedOperation() {
		System.out.println("Enter the expression");
		String expression = scanner.nextLine();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*'
					&& expression.charAt(i) != '/' && (expression.charAt(i) < '0' && expression.charAt(i) > '9')) {
				System.out.println("\t\t\t\t\tYou entered an invalid expression");
				calculator();
			}
		}
		controller.expression(expression);
	}

	private void division() {
		String number;
		System.out.println("Enter the number to add..Press \"=\" to get final Answer");
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			number = scanner.nextLine();
			if(i==0&&number.equals("=")) {
				System.out.println("You entered an invalid expression");
				calculator();
			}
			else if (number.equals("=")) {
				controller.addition();
				break;
			} else
				controller.divNumber(Float.parseFloat(number));
		}

	}

	private void multiplication() {
		String number;
		System.out.println("Enter the number to add..Press \"=\" to get final Answer");
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			number = scanner.nextLine();
			if(i==0&&number.equals("=")) {
				System.out.println("You entered an invalid expression");
				calculator();
			}
			else if (number.equals("=")) {
				controller.addition();
				break;
			} else
				controller.mulNumber(Float.parseFloat(number));
		}

	}

	private void subtraction() {
		String number;
		System.out.println("Enter the number to add..Press \"=\" to get final Answer");
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			number = scanner.nextLine();
			if(i==0&&number.equals("=")) {
				System.out.println("You entered an invalid expression");
				calculator();
			}
			else if (number.equals("=")) {
				controller.addition();
				break;
			} else
				controller.subNumber(Float.parseFloat(number));
		}

	}

	private void addition() {
		String number;
		System.out.println("Enter the number to add..Press \"=\" to get final Answer");
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			number = scanner.nextLine();
			if(i==0&&number.equals("=")) {
				System.out.println("You entered an invalid expression");
				calculator();
			}
			else if (number.equals("=")) {
				controller.addition();
				break;
			} else
				controller.addNumber(Float.parseFloat(number));
		}

	}

	@Override
	public void result(String soln, float result) {
		System.out.println(soln + " = " + result);
		calculator();
	}

	@Override
	public void result(String result, String expression) {
		System.out.println(expression + " = " + result);
		calculator();
	}
}