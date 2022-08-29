package cn.itcast.user.utils;

import java.io.Serializable;

/**
 * 标签schema类
 *  
 * @since Apr 19, 2019
 * @author 陈锡伟
 *
 */
public class LabelSchemaDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5152370731000851326L;
	private String name;
	private String type;
	private boolean nullable;
	public LabelSchemaDO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isNullable() {
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
}
