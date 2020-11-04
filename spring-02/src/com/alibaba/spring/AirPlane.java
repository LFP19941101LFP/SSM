package com.alibaba.spring;

public class AirPlane {
	private String fdj; 		//发动机
	private String yizhan; 		//飞机翼展
	private Integer personNum; 	//乘客数量
	private String jzName;  	//机长名字
	private String fjs;  		//副驾驶
	public String getFdj() {
		return fdj;
	}
	public void setFdj(String fdj) {
		this.fdj = fdj;
	}
	public String getYizhan() {
		return yizhan;
	}
	public void setYizhan(String yizhan) {
		this.yizhan = yizhan;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	public String getJzName() {
		return jzName;
	}
	public void setJzName(String jzName) {
		this.jzName = jzName;
	}
	public String getFjs() {
		return fjs;
	}
	public void setFjs(String fjs) {
		this.fjs = fjs;
	}
	@Override
	public String toString() {
		return "AirPlane [fdj=" + fdj + ", yizhan=" + yizhan + ", personNum="
				+ personNum + ", jzName=" + jzName + ", fjs=" + fjs + "]";
	}
	public AirPlane() {
		super();
	}
	public AirPlane(String fdj, String yizhan, Integer personNum,
			String jzName, String fjs) {
		super();
		this.fdj = fdj;
		this.yizhan = yizhan;
		this.personNum = personNum;
		this.jzName = jzName;
		this.fjs = fjs;
	}
	
	
	
	

}
