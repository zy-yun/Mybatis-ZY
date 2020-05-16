package com.zy.mybatis.v1.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器链，存放所有拦截插件，和对代理对象进行循环代理
 *
 * @Author zhangyun
 */
public class InterceptorChain {


    /**
     * 存放拦截器
     */
    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    /**
     * 添加拦截器
     *
     * @param interceptor
     */
    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }


    /**
     * 对被拦截对象进行层层代理
     *
     * @param target
     * @return
     */
    public Object pluginAll(Object target) {

        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }


    /**
     * 判断是否有拦截插件
     *
     * @return
     */
    public boolean hasPlugin() {

        if (interceptors.size() == 0) {
            return false;
        }
        return true;
    }
}
