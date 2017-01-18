package com.automation;

/**
 * Hello world!
 *
 */
public class App 
{

	public App(){
		System.out.println("constructor initialised");
	}
	
	public void displaywords(){
		System.out.println("printed words");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		App test = new App();
		test.displaywords();
		System.out.println("test");
	}
}
