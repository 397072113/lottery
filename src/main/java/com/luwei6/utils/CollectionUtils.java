package com.luwei6.utils;

import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/10/29.
 */
public abstract class CollectionUtils{
    public static <T> void  sortByProperties(List<T> list,String... args) throws Exception {
        Assert.noNullElements(args);
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                for(String arg:args) {

                    try {
                        Object obj1Vlue = getGetMethod(o1,arg);
                        Object obj2Vlue = getGetMethod(o2,arg);
                        if(obj1Vlue == null || obj2Vlue == null) {
                            continue;
                        }
                        if(obj1Vlue instanceof String && ((String) obj1Vlue).compareTo((String) obj2Vlue) != 0) {
                            return ((String) obj1Vlue).compareTo((String) obj2Vlue);
                        }
                        else if(obj1Vlue instanceof Number) {
                            if(((Number) obj1Vlue).longValue() > ((Number) obj2Vlue).longValue() ) {
                                return 1;
                            }
                            else if (((Number) obj1Vlue).longValue() < ((Number) obj2Vlue).longValue()) {
                                return -1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return 0;
            }
        });
    }

    private static Object getGetMethod(Object ob , String name)throws Exception{
        Method[] m = ob.getClass().getMethods();
        for(int i = 0;i < m.length;i++){
            if(("get"+name).toLowerCase().equals(m[i].getName().toLowerCase())){
                return m[i].invoke(ob);
            }
        }
        return null;
    }
}
