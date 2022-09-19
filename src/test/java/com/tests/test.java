package com.tests;

import java.util.HashMap;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;

import freemarker.ext.beans.HashAdapter;

public class test {
	
	static int[] first = {1,2,3,-1,-3,5,6,7};
	static int maxValue = 0;
	static int finalStartIndex, finalEndIndex;
	public static void main(String[] args) {
		
		for(int i=0; i<first.length; i++) {
			for(int j=i+1; j<first.length; j++) {
				int result = getSum(i, j);
				if(result > maxValue) {
					maxValue = result;
					finalStartIndex = i;
					finalEndIndex = j;
				}
			}
		}
		
		System.out.println("final value : " +  maxValue);
		System.out.println("final index : " +  finalStartIndex + ">" + finalEndIndex);
	}
	
public static int getSum(int startIndex, int EndIndex) {
	int result = 0;
	for(int i= startIndex; i<EndIndex; i++) {
		result = result+first[i];
	}
	return result;
}

}
