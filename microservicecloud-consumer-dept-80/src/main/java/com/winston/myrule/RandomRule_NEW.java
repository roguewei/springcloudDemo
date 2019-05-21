package com.winston.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author Winston
 * @title: RandomRule_NEW
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/21 14:42
 */
public class RandomRule_NEW extends AbstractLoadBalancerRule {

//    /**
//     * @Author Winston
//     * @Description 覆盖ribbon原有的轮询算法
//     * @Date 10:15 2019/5/21
//     * @Param
//     * @return
//     **/
//    @Bean
//    public IRule myRule(){
//        // 用重新选择的随机算法替代默认的轮询
//        return new RandomRule();
//    }

    // 原始随机算法所需的
//    Random random;
//    public MySelfRule(){
//        random = new Random();
//    }

    // total = 0 当total==5之后，指针才能往下走
    // index = 0 当前对外提供服务的服务器地址
    // total需要重新置为0，但是已经达到过一次5，index=1

    // 总共被调用的次数，目前要求每台被调用5次
    private int total = 0;
    // 当前提供服务的机器号
    private int currentIndex = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    // 自定义的随机算法
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            // 线程是否被中断
            if (Thread.interrupted()) {
                return null;
            }
            // 存活的微服务
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

//            int index = random.nextInt(serverCount);
//            server = upList.get(index);

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }
        return server;
    }

    // 原始的随机算法
//    public Server choose(ILoadBalancer lb, Object key){
//        if(lb == null){
//            return null;
//        }
//        Server server = null;
//        while(server == null){
//            // 线程是否被中断
//            if(Thread.interrupted()){
//                return null;
//            }
//            // 存活的微服务
//            List<Server> upList = lb.getReachableServers();
//            List<Server> allList = lb.getAllServers();
//
//            int serverCount = allList.size();
//            if(serverCount == 0){
//                return null;
//            }
//
//            int index = random.nextInt(serverCount);
//            server = upList.get(index);
//
//            if(server == null){
//                Thread.yield();
//                continue;
//            }
//            if(server.isAlive()){
//                return (server);
//            }
//
//            server = null;
//            Thread.yield();
//        }
//        return server;
//    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
