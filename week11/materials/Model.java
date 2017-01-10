package orm;

import java.util.List;
import java.util.LinkedList;

import sql.MySQLHelper;

import java.lang.reflect.*;

public abstract class Model<T> {
	
	MySQLHelper db = new MySQLHelper("//localhost/SchoolSystem", "root", "facepalm");
	
	public class ObjectModel<E> {
		Class classIns;
		ObjectModel(Class classIns) {
			this.classIns = classIns;
		}
		public List<T> all() {
			List<T> res = new LinkedList<T>();
			for(List item: db.selectFrom(classIns.getSimpleName()+"s")) {
				res.add(listStringToObject(item));
			}
			return res;
		}
		
		public void get() {
			System.out.println("Here is just a single item");
		}
	}
	
	private void fillInInstance(Object instance, Field field, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
		
		Method setter = instance.getClass().getMethod(
				"set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
				field.getType()
			);
		
		switch(field.getType().getSimpleName()) {
			case "int" : { setter.invoke(instance, Integer.parseInt(value)); break; }
			case "String" : { setter.invoke(instance, value); break; }
		}
	}
	
	private T listStringToObject(List<String> item) {
		try {
			Object instance = this.getClass().newInstance();
			
			Field[] fields = this.getClass().getDeclaredFields();
			
			for(int i=0; i < fields.length; i++) {
				fillInInstance(instance, fields[i], item.get(i));
			}
					
			return (T) instance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract List<T> update();
	public ObjectModel<T> objects() {
		return new ObjectModel<T>(this.getClass());
	}
}
