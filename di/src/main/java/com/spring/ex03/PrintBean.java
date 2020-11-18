package com.spring.ex03;

public class PrintBean {
	private String print;
	private PrintString printString;
	
	public void print() {
		printString.print(this.print);
	}
	public String getPrint() {
		return print;
	}
	public void setPrint(String print) {
		this.print = print;
	}
	public PrintString getPrintString() {
		return printString;
	}
	public void setPrintString(PrintString printString) {
		this.printString = printString;
	}
	
	
}
