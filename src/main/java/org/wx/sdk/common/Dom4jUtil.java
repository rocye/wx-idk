package org.wx.sdk.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
     * @version 2013-10-21
     */
    public static Map<String, Object> getMapByXmlStr(String xmlStr){
        try {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            Document document = DocumentHelper.parseText(xmlStr);
            Element element = document.getRootElement();
            for(Iterator<Element> it = element.elementIterator(); it.hasNext(); ){
                Element temp = it.next();
                resultMap.put(temp.getName(), temp.getText());
            }
            return resultMap;
        } catch (DocumentException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }   
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
