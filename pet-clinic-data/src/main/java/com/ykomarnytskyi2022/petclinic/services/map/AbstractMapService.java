package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ykomarnytskyi2022.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if(object != null) {
			if(object.getId() == null) {
				object.setId(getNextID());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("BaseEntity descendant cannot be null ");
		}
		
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	protected Long getNextID() {
		return map.keySet().stream().mapToLong(Long::longValue).max().orElse(0L) + 1L;
	}
	
	protected abstract T getSpecialCaseObject();
}
