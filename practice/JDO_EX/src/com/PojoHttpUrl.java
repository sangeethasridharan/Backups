package com;
import javax.jdo.annotations.*;
import java.util.*;

@PersistenceCapable
public class PojoHttpUrl {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Map<String,Object> map;
	

	public Key getKey() {
		return key;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	
}
