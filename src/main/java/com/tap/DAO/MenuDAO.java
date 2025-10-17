package com.tap.DAO;

import java.util.List;

import com.tap.models.Menu;

public interface MenuDAO {
	
	void addMenu(Menu menu);
	int updateMenu(Menu menu);
	int deleteMenu(int id);
	Menu getMenu(int id);
	List<Menu> getAllMenu();
	List<Menu> getAllMenuByRestaurantID(int id);
}
