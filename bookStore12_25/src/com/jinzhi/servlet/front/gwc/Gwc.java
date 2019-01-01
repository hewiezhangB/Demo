package com.jinzhi.servlet.front.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class Gwc {

	private Hashtable<Integer, GwcItem> gwcItems = new Hashtable<Integer, GwcItem>();

	public void addItem(GwcItem gwcItem) {
		Set<Integer> keys = gwcItems.keySet();
		// �����������˵�����ﳵ���Ѿ����ڴ���Ʒ
		if (keys.contains(gwcItem.getBookId())) {
			GwcItem oldGwcItem = gwcItems.get(gwcItem.getBookId());
			// ��������
			oldGwcItem.setNum(oldGwcItem.getNum() + 1);
			// gwcItems.put(oldGwcItem.getBookId(), oldGwcItem);
		} else {
			gwcItems.put(gwcItem.getBookId(), gwcItem);
		}

	}

	public void clear() {
		gwcItems.clear();

	}

	public void deleteGwcItem(int id) {
		gwcItems.remove(id);

	}

	public Collection<GwcItem> getAllItems() {
		return gwcItems.values();
	}

	public float getHyPrices() {
		float prices = 0;
		Collection<GwcItem> list = gwcItems.values();
		for (GwcItem gwcItem : list) {
			prices += gwcItem.getHyprice() * gwcItem.getNum();
		}
		return prices;
	}

	public float getOldPrices() {
		float prices = 0;
		Collection<GwcItem> list = gwcItems.values();
		for (GwcItem gwcItem : list) {
			prices += gwcItem.getPrice() * gwcItem.getNum();
		}
		return prices;
	}

	public float getYhPrices() {
		return this.getOldPrices() - this.getHyPrices();
	}

	public void updateItemNum(int id, int num) {
		GwcItem gwcItem = gwcItems.get(id);
		gwcItem.setNum(num);
		// ���ô���
		gwcItems.put(id, gwcItem);

	}

}
