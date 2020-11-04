package com.alibaba.spring;
/**
 * 静态工厂,调用静态工厂的方法不需要创建工厂的独对象
 * 只需通过类名就可以调用方法
 * @author ASUS
 *
 */
public class AirPlaneStaticFactory {
	
	public static AirPlane getAirStaticPlane(String jzName) {
		System.out.println("静态工厂被调用,正在为你造飞机...");
		AirPlane a = new AirPlane();
		a.setFdj("F-119");
		a.setFjs("美国人");
		a.setJzName(jzName);
		a.setPersonNum(25);
		a.setYizhan("2m");
		return a;
	}

}
