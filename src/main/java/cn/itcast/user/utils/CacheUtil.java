package cn.itcast.user.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.druid.sql.visitor.functions.If;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheUtil {

	public static Cache getCache() {
		CacheManager create = CacheManager.create();
		Cache cache = create.getCache("labelCache");
		return cache;
	}

	public static String getDimension(String labelcode) {
		Element element = getCache().get(labelcode + "_wd");// 拿到维度
		if (element != null) {
			return element.getObjectValue().toString();
		}
		return null;
	}

	public static boolean multivalued(String dimension) throws LabelException {
		Element element = getCache().get(dimension);
		if (element != null) {
			return element.getObjectValue().equals(1);
		} else {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, "检查是否标注了非法标签");
		}

	}





	public static List<String> buildLabelproperties(List<String> list) throws LabelException {

		List<String> listNew = new ArrayList<>();
		for (String property : list) {
			String field = "";
			String dimension = getDimension(property);
			boolean multivalued = multivalued(dimension);
			if (multivalued) {
				field = "label_" + dimension + "_" + property;
			} else {
				field = "label_" + dimension;
			}
			listNew.add(field);
		}
		
		return listNew;

	}
	
	public static String buildLabelproperties(String labelcode) throws LabelException {

			String dimension = getDimension(labelcode);
			boolean multivalued = multivalued(dimension);
			if (multivalued) {
				labelcode = "label_" + dimension + "_" + labelcode;
			} else {
				labelcode = "label_" + dimension;
			}
			return labelcode;
	}

}
