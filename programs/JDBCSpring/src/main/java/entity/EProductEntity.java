package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


public class EProductEntity {

	private int id;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	
	
	public EProductEntity(int id, String name, BigDecimal price, Date dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}

	public EProductEntity(String name, BigDecimal price, Date dateAdded) {
		super();
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	
	public EProductEntity(Integer id2, String name2, BigDecimal price2) {
		this.id=id2;
		this.name = name2;
		this.price = price2;
		
	}

	public EProductEntity() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "EProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded + "]";
	}
	
	
}
