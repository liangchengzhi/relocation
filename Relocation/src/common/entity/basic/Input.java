package common.entity.basic;

/**
 * 导入模板的输入项
 * @author liangcz
 *
 */
public class Input{
	/**
	 *  name
	 */
	private String name;
	/**
	 *  描述
	 */
	private String desc;
	/**
	 *  类型
	 */
	private String type;
	
	/**
	 *  是否必输
	 */
	private boolean required;
	/**
	 * 默认值
	 */
	String defaultValue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	@Override
	public String toString() {
		return "Input [name=" + name + ", desc=" + desc + ", type=" + type
				+ ", required=" + required + ", defaultValue=" + defaultValue
				+ "]";
	}
	
}
