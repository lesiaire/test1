package mypackage;

import java.io.Serializable;

import javax.persistence.*;

import oracle.eclipselink.coherence.integrated.config.GridCacheCustomizer;
import org.eclipse.persistence.annotations.Customizer;

import oracle.eclipselink.coherence.integrated.cache.CoherenceInterceptor;

import org.eclipse.persistence.annotations.CacheInterceptor;

//@CacheInterceptor(value = CoherenceInterceptor.class)
//@Customizer(GridCacheCustomizer.class)

@Entity
@Table(name="TABLE1")
@CacheInterceptor(value = CoherenceInterceptor.class)
public class Table1 implements Serializable {

	public Integer getColumn1() {
		return column1;
	}

	public void setColumn1(Integer column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	@Id
	@Column (name="COLUMN1")
	protected Integer column1;
	
	@Column (name="COLUMN2")
	protected String column2;
	
	@Override
	   public String toString() {
	      return "Table1 [column1=" + column1 + ", column2=" + column2 + "]";
	   }
}
