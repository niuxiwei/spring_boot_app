package cn.sunline.spring.impl;

import cn.sunline.spring.SpringContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlSpringContext  implements SpringContext {

    Map<String,Object> map = new HashMap<String,Object>();

    public XmlSpringContext (String filename){
        // xml文件的解析器
        SAXReader sr = new SAXReader();
        try {
            //构建一个直接通向我们配置文件路径 的输入流
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
            //文档模型对象
            Document doc = sr.read(inputStream);
            //获取根标签
            Element root = doc.getRootElement();
            //获取当前根标签的子标签
            List<Element> beans = root.elements("bean");
            for(Element bean:beans){
                String key = bean.attributeValue("name");
                String value = bean.attributeValue("class");
                Class<?> myclass = Class.forName(value);
                //当前对象
                Object obj = myclass.newInstance();
                map.put(key, obj);
                List<Element> elements = bean.elements("property");
                if(elements.size()>0){
                    for(Element pro: elements){
                        String av = pro.attributeValue("name");//dao--->setDao
                        //方法名
                        String methodName="set"+(av.charAt(0)+"").toUpperCase()+av.substring(1,av.length());
                        //方法参数
                        String refvalue = pro.attributeValue("ref");
                        Object refobj = map.get(refvalue);
                        //根据方法名称获取方法对象Method
                        Method method = myclass.getMethod(methodName,refobj.getClass().getInterfaces()[0]);
                        method.invoke(obj, refobj);
                    }
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Object getBean(String beanName){
        return map.get(beanName);
    }

}