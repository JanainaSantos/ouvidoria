package com.googlecode.ouvidoria.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

	public static Object get(Object obj, String parameter)
			throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
				parameter, obj.getClass());
		Method getter = propertyDescriptor.getReadMethod();
		return getter.invoke(obj);
	}

	public static String getString(Object obj, String parameter)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		Object value = get(obj, parameter);
		return (value != null)?value.toString():null;
	}
	
	public static Long getLong(Object obj, String parameter)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		Object value = get(obj, parameter);
		return (Long) value;
	}
}
