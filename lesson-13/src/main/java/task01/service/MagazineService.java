package task01.service;

import java.util.Map;

import task01.domain.Magazine;
import task01.shared.AbstractCRUD;

public interface MagazineService extends AbstractCRUD<Magazine>{
	
	public Map<Integer, Magazine> readAllMap();
	
}