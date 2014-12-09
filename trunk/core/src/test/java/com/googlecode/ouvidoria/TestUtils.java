package com.googlecode.ouvidoria;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.ouvidoria.model.vo.SimpleVO;

public class TestUtils {

	public static List getSimpleVoList(int size){
		return getSimpleVoList(size,true);
	}
	
	public static List getSimpleVoList(int size, boolean active){
		List list = new ArrayList();
		if(size >= 0){
			for(int i=1; i <= size; i++){
				list.add(new SimpleVO((long)i,"vo-"+i,"vo-"+i,active));
			}
		}
		return list;
	}
	
}
