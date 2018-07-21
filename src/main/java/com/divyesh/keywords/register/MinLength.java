package com.divyesh.keywords.register;

public class MinLength implements Register{
	
	private static MinLength INSTANCE = new MinLength();

	public static MinLength getInstance() {
		return INSTANCE;
	}

	@Override
	public boolean validate(Object dataValue, Object confData) {
		if (dataValue instanceof Integer) {
			if ((Integer) dataValue >= (Long) confData) {
				return true;
			}
		} else if (dataValue instanceof String) {
			if (((String) dataValue).length() >= ((Long) confData)) {
				return true;
			}
		}
		return false;
	}

}
