package com.googlecode.ouvidoria.presentation.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.model.SelectItem;

import com.googlecode.ouvidoria.model.vo.SimpleVO;

public class ComboboxUtil {
	
	public static Collection<SelectItem> toSelectItemCollection(List<SimpleVO> vos) {
		return toSelectItemCollection(vos, true);
	}

	public static Collection<SelectItem> toSelectItemCollection(List<SimpleVO> vos, boolean isLong) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (SimpleVO vo : vos) {
			items.add(toSelectItem(vo, isLong));
		}
		return items;
	}

	public static SelectItem toSelectItem(SimpleVO vo, boolean isLong) {
		return new SelectItem((isLong) ? vo.getId() : vo.getName(), vo.getName(), vo.getDescription());
	}
}
