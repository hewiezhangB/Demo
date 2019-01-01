package com.jinzhi.servlet.front.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class GwcMapImpl implements IGwc {

	private Hashtable<Integer, GwcItem> gwcItems = new Hashtable<Integer, GwcItem>();

	@Override
	public void addItem(GwcItem gwcItem) {
		Set<Integer> keys = gwcItems.keySet();
		// 如果包含，则说明购物车里已经存在此商品
		if (keys.contains(gwcItem.getBookId())) {
			GwcItem oldGwcItem = gwcItems.get(gwcItem.getBookId());
			// 更改数量
			oldGwcItem.setNum(oldGwcItem.getNum() + 1);
			// gwcItems.put(oldGwcItem.getBookId(), oldGwcItem);
		} else {
			gwcItems.put(gwcItem.getBookId(), gwcItem);
		}

	}

	@Override
	public void clear() {
		gwcItems.clear();

	}

	@Override
	public void deleteGwcItem(int id) {
		gwcItems.remove(id);

	}

	@Override
	public Collection<GwcItem> getAllItems() {
		return gwcItems.values();
	}

	@Override
	public float getHyPrices() {
		float prices = 0;
		Collection<GwcItem> list = gwcItems.values();
		for (GwcItem gwcItem : list) {
			prices += gwcItem.getHyprice() * gwcItem.getNum();
		}
		return prices;
	}

	@Override
	public float getOldPrices() {
		float prices = 0;
		Collection<GwcItem> list = gwcItems.values();
		for (GwcItem gwcItem : list) {
			prices += gwcItem.getPrice() * gwcItem.getNum();
		}
		return prices;
	}

	@Override
	public float getYhPrices() {
		return this.getOldPrices() - this.getHyPrices();
	}

	@Override
	public void updateItemNum(int id, int num) {
		GwcItem gwcItem = gwcItems.get(id);
		gwcItem.setNum(num);
		// 引用传递
		gwcItems.put(id, gwcItem);

	}

}
