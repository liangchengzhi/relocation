package common.entity.basic;

import java.util.List;
import java.util.Map;

/**
 *  导入模板
 * @author liangcz
 *
 */
public class ImportModel {
	
	/**
	 *  模板id
	 */
	private String id;
	/**
	 *  模板描述
	 */
	private String desc;
	/**
	 *  模板列
	 */
	private List<Input> inputs;
	/**
	 *  模板的索引
	 */
	private Map<String, Integer> indexs;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Input> getInputs() {
		return inputs;
	}


	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}


	public Map<String, Integer> getIndexs() {
		return indexs;
	}

	public void setIndexs(Map<String, Integer> indexs) {
		this.indexs = indexs;
	}



	
}
