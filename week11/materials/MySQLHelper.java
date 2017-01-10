package sql;

import java.sql.*;
import java.lang.reflect.*;
import java.util.List;
import java.util.LinkedList;

public class MySQLHelper {
	private Connection conn;
	
	public MySQLHelper(String dbURL, String dbUser, String dbPass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			
			conn = DriverManager.getConnection("jdbc:mysql:"+dbURL,dbUser,dbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<List<String>> executeSQL(String sql) {
		try {
			List<List<String>> result = new LinkedList<>();
			
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();
				List<String> row = new LinkedList<String>();
				
				for (int i = 1; i <= columns; i++) {
					String colName = md.getColumnName(i);
					row.add(rs.getString(colName));
				}
				result.add(row);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String makeFirstLetterCapital(String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1);
	}
	
	public boolean insertInto(String table, Object item) {
		
		Field[] fields = item.getClass().getDeclaredFields();
		
		try {
			LinkedList<String> fieldsList = new LinkedList<>();
			LinkedList<String> fieldsNamesList = new LinkedList<>();
			for(Field f: fields) {
				if(f.getName().equals("id")) continue;
				fieldsNamesList.add(f.getName());
				fieldsList.add(item.getClass().getMethod("get"+makeFirstLetterCapital(f.getName())).invoke(item).toString());
			}
			
			String[] zz = new String[fieldsList.size()];
			fieldsList.toArray(zz);
			
			String fieldsSQL = String.join(" , ", zz);
			
			String[] s2 = new String[fieldsNamesList.size()];
			fieldsNamesList.toArray(s2);
			
			String fieldsNamesSQL = String.join(" , ", s2);
			String sql = "INSERT INTO "+table+"("+fieldsNamesSQL+") VALUES ("+fieldsSQL+");";
			
//			System.out.println(sql);
			
			this.executeSQL(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteFrom(String table, int id) {
		return false;
	}
	
	public boolean update(String table, Object ob) {
		return false;
	}
	
	public List<List<String>> selectFrom(String table) {
		return selectFrom(table, "1");
	}
	
	public List<List<String>> selectFrom(String table, String where) {
		return executeSQL("SELECT * FROM " + table + " WHERE " + where);
	}
}
