package org.wx.sdk.common;

import java.util.*;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * dom4j解析XML工具类
 * @author Rocye
 * @version 2013-10-21
 */
public class Dom4jUtil {

	/** 日志对象 */
    private final static Logger logger = Logger.getLogger(Dom4jUtil.class.getName());

    /**
     * 解析XML字串得到Map对象
     * @author Rocye
     * @param xmlStr Xml字符串
     * @return Xml对应的Map对象
     * @version 2017.11.15
     */
    public static Map<String, Object> getMapByXmlStr(String xmlStr){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlStr);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null){
			return map;
		}
		Element rootElement = doc.getRootElement();
		Element2Map(rootElement, map);
		return (Map<String, Object>)map.get("xml");
    }

	/**
	 * Dom4j结点递归转Map
	 * @param outele  节点
	 * @param outmap  键值对
	 * @return 键值对
	 * @version 2017.11.15
	 */
	public static Map Element2Map(Element outele, Map outmap) {
		List<Element> list = outele.elements();		//必定返回0,1,2,3,....... 不会异常
		int size = list.size();
		if (size == 0) {	//当前节点是叶子节点(outele如果为叶子节点,是不可能有子节点的,因为它里面是纯文本)
			outmap.put(outele.getName(), outele.getTextTrim());
		} else {
			Map<String, Object> innermap = new HashMap<String, Object>();
			for (Element ele1 : list) {
				String eleName = ele1.getName();
				Object obj = innermap.get(eleName);	//获取MASTER
				if (obj == null) {	//如果该MASTER不存在,现在有一个MASTER过来
					Element2Map(ele1, innermap);
				} else {
					if (obj instanceof java.util.Map) {		//如果没有生成过list,把原来的单个map合并到新的list
						List<Map> list1 = new ArrayList<Map>();
						list1.add((Map) innermap.remove(eleName));
						Element2Map(ele1, innermap);
						list1.add((Map) innermap.remove(eleName));
						innermap.put(eleName, list1);
					} else {	//如果不是map,必然是list,只有这两种情况,所以不再else if 条件判断
						Element2Map(ele1, innermap);
						((List) obj).add(innermap);
					}
				}
			}
			outmap.put(outele.getName(), innermap);
		}
		return outmap;
	}
    
    /**
     * 解析Map对象得到XML字串
     * @author Rocye
     * @param msgMap Map对象
     * @return Map对象对应的Xml字符串
     * @version 2013-10-21
     */
    public static String getXmlStrByMap(Map<String, Object> msgMap){
        if(msgMap == null){
            return null;
        }
        
        Document document = DocumentHelper.createDocument();
        Element rootEle = document.addElement("xml");
        for(Iterator<String> it = msgMap.keySet().iterator(); it.hasNext(); ){
            String key = it.next();
            Object valObj = msgMap.get(key);
            if(valObj instanceof List<?>){
                Element tempEle = rootEle.addElement(key);
                List<Map<String, Object>> listMap = (List<Map<String, Object>>)valObj;
                for(Map<String, Object> temp : listMap){
                    Element itemEle = tempEle.addElement("item");
                    for(Iterator<String> it2 = temp.keySet().iterator(); it2.hasNext(); ){
                        String key2 = it2.next();
                        if(temp.get(key2) != null){
                            String val2 = temp.get(key2).toString();
                            Element tempEle2 = itemEle.addElement(key2);
                            tempEle2.setText(val2);
                        }
                    }
                }
            }else if(valObj instanceof Map<?,?>){
                Element tempEle = rootEle.addElement(key);
                Map<String, Object> childMap = (Map<String, Object>)valObj;
                for(Iterator<String> it2 = childMap.keySet().iterator(); it2.hasNext(); ){
                    String key2 = it2.next();
                    if(childMap.get(key2) != null){
                        String val2 = childMap.get(key2).toString();
                        Element tempEle2 = tempEle.addElement(key2);
                        tempEle2.setText(val2);
                    }
                }
            }else{
                String val = msgMap.get(key).toString();
                Element tempEle = rootEle.addElement(key);
                tempEle.setText(val);
            }
        }
        String backXml = document.asXML();
        return backXml;
    }
    
}
