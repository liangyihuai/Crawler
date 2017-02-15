package com.huai.driver;

import java.util.*;

/**
 * Created by liangyh on 2/14/2017.
 */
public abstract class NovelDriver implements Driver{

    public List<String> getDiff(final Set<String> curr, final Set<String> old){
        List<String> result = new ArrayList<String>();
        for(String str: curr){
            if(!old.contains(str)){
                result.add(str);
            }
        }
        for(String str: old){
            if(!curr.contains(str)){
                result.add(str);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void copyLinks(Set<String> src, Set<String> dist){
        dist.clear();
        for(String str: src){
            dist.add(str);
        }
    }

    public abstract String extractTargetContent(String htmlPage);

    public abstract Set<String> getLinks(String htmlPage);
}
