package cn.gsonya.Practice.base.domain;

import java.io.Serializable;

public abstract class BaseDomain implements Serializable {
	
	public abstract boolean equals(Object o);
	public abstract int hashCode();
	public abstract String toString();

}
