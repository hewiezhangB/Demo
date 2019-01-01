package com.jinzhi.servlet.front.gwc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GwcListImpl implements IGwc {
	List<GwcItem> items = new ArrayList<GwcItem>() ;
	@Override
	public void addItem(GwcItem gwcItem) {
		// TODO Auto-generated method stub
		GwcItem oldGwcItem =null ;
		for(GwcItem item :items){
			if(item.getBookId()==gwcItem.getBookId()){
				oldGwcItem=item;
			}
		}
		if(oldGwcItem==null){
			items.add(gwcItem);
		}else{
			//items.remove(oldGwcItem);
			oldGwcItem.setNum(oldGwcItem.getNum()+1);
			//items.add(oldGwcItem);
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGwcItem(int id) {
		for(GwcItem item :items){
			if(item.getBookId()==id){
				items.remove(item);
				break;
			}
		}

	}

	@Override
	public Collection<GwcItem> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getHyPrices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getOldPrices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getYhPrices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateItemNum(int id, int num) {
		// TODO Auto-generated method stub

	}

}
