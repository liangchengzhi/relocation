package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

public class DomTools {
	
	public static void main(String[] args) throws Exception {		
		// DocumentFactory 是单例模式
		DocumentFactory factory = DocumentFactory.getInstance();
		Document doc = factory.createDocument();
		
		// 另外一种方式
		// Document doc = DocumentHelper.createDocument();  
		
		doc.add(factory.createComment("这是注释"));
		Element rootElement = factory.createElement("books");
		doc.add(rootElement);
		
		Element e1 = factory.createElement("book")
        .addAttribute("author", "lcz")
        .addAttribute("hasSale", "false")
        .addText("红高粱");
		
		Element e2 = factory.createElement("book")
        .addAttribute("author", "luxun")
        .addAttribute("hasSale", "true")
        .addText("鲁迅全集");
		
		Element e3 = factory.createElement("owner")
        .addAttribute("isSelf", "true")
        .addText("梁成志");
        
		e1.add(e3);
		rootElement.add(e1);
		rootElement.add(e2);
		
		System.out.println("----------- 格式化输出到控制台 -------------");
		formatWrite(doc,System.out,"gbk"); // 格式化输出到控制台
		
		System.out.println("----------- 遍历元素 -------------");
		walkDocument(doc); // 遍历元素
		
		System.out.println("----------- 从文件中读取文档 -------------");
		formatWrite(doc,new FileOutputStream(CommonsUtil.getTmpFile(null)),"gbk"); // 格式化输出到临时输出文件中
		Document readDoc = readDoc(factory,CommonsUtil.getTmpFile(null),null);// 使用默认编码读取文档对象
		
		System.out.println(readDoc.asXML());
		
		System.out.println("----------- visitor(遍历) 模式测试 -------------");

		
		System.out.println("----------- 使用xpath和xml寻找节点 -------------");
		List<Node> nodes = readDoc.selectNodes("/books/book");// 返回匹配到的所有节点
		walkNodes(nodes);	
		
		Node n = readDoc.selectSingleNode("/books/book"); // 返回匹配到的第一个节点
		System.out.println(n.asXML());
		
		nodes = readDoc.selectNodes("/books/book/@author"); // 遍历属性author
		walkNodes(nodes);
		
		// books/book[@author='lcz'] 查找属性author=lcz的 book
		// /books/book[1] 第一个元素，下标从1开始
		// //book@author xpath
	}
	
	/**
	 * @descript 把Node或者List<Node> 输出到指定的流中
	 * @param obj
	 * @param out
	 * @param encoding
	 * @throws IOException
	 */
	public static void formatWrite(Object obj,OutputStream out,String encoding) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();
		if(encoding != null){
			format.setEncoding(encoding);// 强制指定编码
		}
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(obj);
	}
	
	/**
	 * @descript 指定文件和编码，获取文档对象
	 * @param factory
	 * @param file
	 * @param encoding
	 * @return
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static Document readDoc(DocumentFactory factory,File file,String encoding) throws FileNotFoundException, DocumentException{
		if(factory == null){
			factory = DocumentFactory.getInstance();
		}
		SAXReader reader = new SAXReader(factory);
		InputSource in = new InputSource(); // 使用inputSource 可以强行指定解析的编码
		in.setByteStream(new FileInputStream(file));
		if(encoding != null){
			in.setEncoding(encoding); // 指定编码则按编码来解析，否则取xml的编码头来解析
		}
		Document doc = reader.read(in);
		return doc;
	}
	
	public static Document readDoc(File file,String encoding) throws FileNotFoundException, DocumentException{
		DocumentFactory factory = DocumentFactory.getInstance();
		return readDoc(factory,file,encoding);
	}
	
	public static Document readDoc(File file) throws FileNotFoundException, DocumentException{
		DocumentFactory factory = DocumentFactory.getInstance();
		return readDoc(factory,file,"GBK");
	}
	
	// 遍历Document
	public static void walkDocument(Document doc){
		Element rootElement = doc.getRootElement();
		walkElement(rootElement);
	}
	// 遍历元素
	public static void walkElement(Element e){
		System.out.print("element:" + e.getName()  + "的text是" + e.getText() + "\t");
		getElementAttrs(e);
		for (Iterator iter = e.elementIterator(); iter.hasNext();) {// elementIterator("book"),可以指定遍历哪个元素
			Element e1 = (Element) iter.next();
			System.out.print(e.getName() + "的子标签："+ e1.getName() +"的text是:"+e1.getText()+"  ");
			getElementAttrs(e1);
			
			System.out.println("");
			if(e1.elements().size()!=0){
				System.out.print("----> ");
				walkElement(e1);
			}
		}
	}
	
	// 获取节点的属性
	public static Map<String, String> getElementAttrs(Element e){
		Iterator<Attribute> iterator = e.attributeIterator();
		Map<String, String> attrs = new HashMap<String, String>();
		while(iterator.hasNext()){
			Attribute attr = iterator.next();
			attrs.put(attr.getName(), attr.getValue());
			//System.out.print(attr.getName() + "属性的值是: " + attr.getValue() + "\t");
		}
		return attrs;
	}
	
	// 获取名称获取节点的属性，返回字符串
	public static String getElementAttrsByName(Element e,String name){
		Map<String, String> attrs = getElementAttrs(e);
		return attrs.get(name);
	}
	
	/**
	 * @descript 遍历list的Element元素
	 * @param nodes
	 */
	public static void walkNodes(List<Node> nodes){
		for (Iterator iter = nodes.iterator(); iter.hasNext();) {
			Node node = (Node) iter.next();
			if (node instanceof Element) {
				Element e = (Element) node;
				walkElement(e);
			}
			
			if (node instanceof Attribute) {
				Attribute attr = (Attribute) node;
				System.out.println("节点是属性：" + attr.getName() + " 值是 " + attr.getValue());
			}
		}	
	}
	
	

}
