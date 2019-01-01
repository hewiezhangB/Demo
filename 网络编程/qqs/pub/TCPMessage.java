package com.qq.pub;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TCPMessage implements Serializable {
	private String head = null;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}

	public void setBody(String key, Object value) {
		this.map.put(key, value);
	}
	public Object getBody(String key) {
		return this.map.get(key);
	}
}
