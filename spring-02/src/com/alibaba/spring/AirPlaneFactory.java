package com.alibaba.spring;

/**
 * 实例工厂,想要调用实例工厂首先必须要创建实例工厂的对象,
 * 再去调用工厂的方法
 * @author ASUS
 *
 */
public class AirPlaneFactory {
	
	public AirPlane getAirPlane(String jzName) {
		System.out.println("实例工厂被调用,实例工厂正在造飞机.......");
		AirPlane a = new AirPlane();
		a.setFdj("太行");
		a.setFjs("lfp");
		a.setJzName(jzName);
		a.setPersonNum(380);
		a.setYizhan("80m");
		return a;
	}

}
