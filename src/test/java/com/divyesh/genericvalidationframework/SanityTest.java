package com.divyesh.genericvalidationframework;

import com.divyesh.conversion.ContextLoader;
import com.divyesh.validator.Validator;

public class SanityTest {
	
	public static void main(String[] args) {
		
		Object data= ContextLoader.getData();
		Validator.validate(data);
		
		
	}
}
