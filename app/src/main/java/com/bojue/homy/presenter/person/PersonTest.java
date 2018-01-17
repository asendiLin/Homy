package com.bojue.homy.presenter.person;

import com.bojue.homy.entity.PersonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/1/11.
 * 个人中心的测试类
 */

public class PersonTest extends AbstractPersonPresenter {
    @Override
    public void loadDemand(int page) {
        List<PersonBean> personBeanList = new ArrayList<>();
        PersonBean person1 = new PersonBean("1月11日","1月21日",10);
        personBeanList.add(person1);
        PersonBean person2 = new PersonBean("2月11日","2月21日",20);
        personBeanList.add(person2);
        PersonBean person3 = new PersonBean("3月11日","3月21日",30);
        personBeanList.add(person3);
        PersonBean person4 = new PersonBean("4月11日","4月21日",40);
        personBeanList.add(person4);
        PersonBean person5 = new PersonBean("5月11日","6月21日",50);
        personBeanList.add(person5);

        getView().initDemand(personBeanList);//初始化，我的需求item的数据
    }

    @Override
    public void loadOrder(int page) {
        List<PersonBean> personBeanList = new ArrayList<>();
        PersonBean person1 = new PersonBean("6月11日","12月21日",100);
        personBeanList.add(person1);
        PersonBean person2 = new PersonBean("7月11日","2月21日",200);
        personBeanList.add(person2);
        PersonBean person3 = new PersonBean("8月11日","3月21日",300);
        personBeanList.add(person3);
        PersonBean person4 = new PersonBean("9月11日","4月21日",400);
        personBeanList.add(person4);
        PersonBean person5 = new PersonBean("10月11日","10月21日",500);
        personBeanList.add(person5);

        getView().initOrder(personBeanList);//初始化，我的订单item的数据
    }
}
