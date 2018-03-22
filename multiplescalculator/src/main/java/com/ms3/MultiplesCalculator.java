package com.ms3;

import java.util.Map;
import java.util.TreeMap;

public class MultiplesCalculator {

	public Map<Integer,String> returnNumbersListWithLables(int n1,int n2) {
	
		//making sure that always n1 is less than n2
		if(n1>n2){
			int n3=n1;
			n1=n2;
			n2=n3;
		}
		
		long start = System.currentTimeMillis();
	
		Map<Integer,String> finalMap = new TreeMap<Integer,String>();
		
		for(int j=n1;j<=n2;j++){
			if(j%21==0){
				finalMap.put(j,"MS3 and ME");
			}else if(j%7==0){
				finalMap.put(j,"MS3");
			}else if(j%3==0){
				finalMap.put(j,"ME");
			}else{
				finalMap.put(j,j+"");
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(finalMap.toString());
	    
		System.out.println("Total Time Taken for Algorithm in MilliSeconds "+(end-start));
		
		return finalMap;
		
	}
}
