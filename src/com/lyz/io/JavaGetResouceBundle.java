package com.lyz.io;
import java.text.MessageFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class JavaGetResouceBundle {
	// ��Դ����
	private static final String BUNDLE_NAME = "welcome";
	// ��Դ��
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	// ���ز�����������Դ
	public static String getMessage(String key) {
		
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return key;
		}
	}
	// ���ش��������������Դ
	public static String getMessage(String key, Object... params) {
		
		try {
			String value = RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(value, params);
		} catch (MissingResourceException e) {
			return key;
		}
	}

	public static void main(String args[]) {  
		System.out.println(getMessage("welcomeinfo"));
	}
}

