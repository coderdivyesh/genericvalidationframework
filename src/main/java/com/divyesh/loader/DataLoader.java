package com.divyesh.loader;

import com.divyesh.keywords.register.MaxLength;

public class DataLoader {
	
	static{
		System.out.println("inside static block");
		new MaxLength();
	}

}
