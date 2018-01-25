package com.demo.completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutrue 使用demo
 * @author LC
 * @date 2017/12/21
 */
public class CompletableFutrueDemo {

    /**
     * 获取商品集合
     * @return
     */
    CompletableFuture<List<String>> getList(){

        List<String> shopList = new ArrayList<>();
        shopList.add("shop001");
        shopList.add("shop002");
        shopList.add("shop003");
        shopList.add("shop004");
        return CompletableFuture.completedFuture(shopList);

    }

    /**
     * 获取名称
     * @param name
     * @return
     */
    CompletableFuture<String> getName(String name){
       return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name;
        });
    }

    /**
     * 获取价格
     * @return
     */
    CompletableFuture<Double> getPrice(){
        System.out.println("getPrice价格完毕！");
        return  CompletableFuture.completedFuture(10.2).exceptionally(e -> {
            System.out.println("test");
            return null;
        });
    }

    /**
     * 获取新价格
     * @return
     */
    CompletableFuture<Double> getNewPrice(){
        System.out.println("getNewPrice价格完毕！");
        return  CompletableFuture.completedFuture(11.2);
    }

    /**
     * 获取商品CODE
     * @return
     */
    CompletableFuture<String> getCode(){
        System.out.println("getCode完毕！");
        return  CompletableFuture.completedFuture("00001");
    }

    /**
     * 返回所有商品信息
     * @param str
     * @return
     * @throws Exception
     */
    CompletableFuture<List<String>> getAll(String str)throws Exception{
        List<String> list = new ArrayList<>();
       return  getList().thenApply((List<String> idList) ->{
            idList.stream().forEach(id->{
                //获取名称
                CompletableFuture<String> test1 = getName(id);
                //获取价格
                CompletableFuture<Double> test2 = getPrice();
                //获取新价格
                CompletableFuture<Double> test21 = getNewPrice();
                //获取商品代码
                CompletableFuture<String> test3 = getCode();

                CompletableFuture<Void> test123 = CompletableFuture.allOf(test1,test3,CompletableFuture.anyOf(test2,test21));
                test123.thenApplyAsync(s -> {
                        try {
                            String str1=  "名称：" + test1.get() + "，价格：" + (test2 == null ? test21 : test2).get() +
                                "，code:" +
                                test3.get();
                            System.out.println("ssss:"+str1);
                            list.add(str1);
                            return str1;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return "异常";
                     }
                );
                test123.join();
                System.out.println("执行完毕");
                //return new Date();
            });
            return list;
        });
    }

    public static void main(String[] args) {
        CompletableFutrueDemo demo = new CompletableFutrueDemo();
        try {
            CompletableFuture<List<String>>  list = demo.getAll("test");
            for (String str:list.get()){
                System.out.println("str:"+str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
 