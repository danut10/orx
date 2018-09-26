package ro.jdmx.orx.common.core;

public class ObjectFactory {

	public static <T> Object getInstance(Class<T> cls) {
		Object result = null;
		try {
			result = cls.newInstance();
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (SecurityException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return result;
	}
}
