package com.wizz.sentencelib.tool;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author seenline
 * @date 2021/8/5 13:24
 * @description 将bean类转化为map
 */
public class Bean2Map {
    //把JavaBean转化为map
    public static Map<String,Object> bean2map(Object bean) throws Exception{
        Map<String,Object> map = new HashMap<>();
        BeanInfo b = Introspector.getBeanInfo(bean.getClass(),Object.class);
        PropertyDescriptor[] pds = b.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            Method m = pd.getReadMethod();
            Object properValue = m.invoke(bean);
            map.put(propertyName, properValue);
        }
        return map;
    }
}
