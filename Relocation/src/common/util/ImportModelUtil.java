package common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import common.entity.basic.IFSException;
import common.entity.basic.ImportModel;
import common.entity.basic.Input;

public class ImportModelUtil {
	public static boolean isInited = false;
	private static ImportModelUtil instanse;
	public static ImportModelUtil getInstance(){
		if(instanse == null){
			instanse = new ImportModelUtil();
		}
		return instanse;
	}
	private ImportModelUtil(){
		
	}
	
	/**
	 *  导入模板
	 */
	private Map<String, ImportModel> importModels;
	
	
	/**
	 * 解析模板
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws MalformedURLException 
	 */
	public void init() throws FileNotFoundException, DocumentException, MalformedURLException{
		if(isInited == true){
			return;
		}
		/* 解析import-model 文件，生成ImportModel 实体对象 */
		// ImportModelUtil.class.getClassLoader().getResource("").getFile()
		
		String path = ServletListener.getServletContext().getResource(Constant.importModelFile).getFile();
		// String path = "F:/SVN_CLIENT/projects/RELOCATION/Relocation/WebRoot/model/import-models.xml";
		Document doc = DomTools.readDoc(new File(path), Constant.encoding);
		/* 解析import-model 节点 */
		List<Node> nodes = doc.selectNodes("/import-models/import-model");
		importModels = new HashMap<String, ImportModel>();
		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Node node = iter.next();
			if (node instanceof Element) {
				ImportModel entity = new ImportModel();
				Element e = (Element) node;
				entity.setId(DomTools.getElementAttrsByName(e,"id"));
				entity.setDesc(DomTools.getElementAttrsByName(e,"desc"));
				
				/* 解析input 节点 */
				List<Node> inputNodes = node.selectNodes("input");
				List<Input> inputs = new ArrayList<Input>();
				Map<String, Integer> indexs = new HashMap<String, Integer>();
				int i = 0;
				for (Node inputNode : inputNodes) {
					Input input = new Input();
					Element inputElement = (Element) inputNode;
					input.setName(DomTools.getElementAttrsByName(inputElement,"name"));
					input.setDesc(DomTools.getElementAttrsByName(inputElement,"desc"));
					input.setType(DomTools.getElementAttrsByName(inputElement,"type"));
					input.setRequired(Boolean.valueOf(DomTools.getElementAttrsByName(inputElement,"required")));
					input.setDefaultValue(DomTools.getElementAttrsByName(inputElement,"defaultValue"));
					indexs.put(input.getName(), i++);
					inputs.add(input);
				}
				entity.setIndexs(indexs);
				entity.setInputs(inputs);
				importModels.put(entity.getId(), entity);
			}
		}
		isInited = true;
	}
	
	
	/**
	 *  获取模板key所在的位置
	 * @param modelId
	 * @param key
	 * @return
	 */
	public Integer getImportModelKeyIndex(String modelId,String key){
		ImportModel importModel = importModels.get(modelId);
		if(importModel == null){
			throw new IFSException("ImportModelUtil.getImportModelKeyIndex.01",modelId + "." + key + "无法找到模板,[" + importModel + "]"); 
		}
		if(importModel.getIndexs() == null){
			throw new IFSException("ImportModelUtil.getImportModelKeyIndex.02",modelId + "." + key + "importModel index 为空,[" + importModel + "]"); 
		}
		return importModel.getIndexs().get(key);
	}
	
	/**
	 *  获取导入模板
	 * @param modelId
	 * @return
	 */
	public ImportModel getImportModel(String modelId){
		return importModels.get(modelId);
	}
	
}
