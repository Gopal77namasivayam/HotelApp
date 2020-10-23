package com.freecrm.qa.util;

import java.util.ArrayList;

public class ReadDataTest  {
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		
		 ArrayList<Object[]> myData = new ArrayList<Object[]>();	 
		try
		{
		 reader=new Xls_Reader("C:\\Users\\GOPAL NAMASIVAYAM\\Desktop\\ecli\\freeCRM_maven\\src\\main\\java\\com\\freecrm\\qa\\testdata\\FreeCrmTestData.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rownum=2;rownum<=reader.getRowCount("contacts");rownum++)
		{
			String titlee =reader.getCellData("contacts","title",rownum);
			String firstname =reader.getCellData("contacts","Fname",rownum);
			String Lastname =reader.getCellData("contacts","Lname",rownum);
			String company =reader.getCellData("contacts","Company",rownum);
		 
			 
			
			Object ob[]= {titlee,firstname,Lastname,company};
			myData.add(ob);
		
		}
		
		return myData;
		
		
		
	}

}

