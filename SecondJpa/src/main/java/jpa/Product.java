package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name="Products",schema = "chandu")
public class Product implements Serializable {


	@Id
@Column(name="product_id")
	private int productId;
@Column(name="product_name")
	private String productName;
@Column(name="productPrice")
	private int productPrice;
	@Column(name="product_Quantity")
	private int productQuantity;
@Column(name="product_Brand")
	private String productBrand;
@Column(name="product_Review")
	private int productReview;
	@Column(name="product_Category")
	private String productCategory;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}   
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}   
	public int getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}   
	public int getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}   
	public String getProductBrand() {
		return this.productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}   
	public int getProductReview() {
		return this.productReview;
	}

	public void setProductReview(int productReview) {
		this.productReview = productReview;
	}   
	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}
