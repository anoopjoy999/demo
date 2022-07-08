package com.example.demo.model;

import com.example.demo.entity.NaceOrder;

public class NaceOrderDto {
	
	  private String order;
	  private String level;
	  private String code;
	  private String parent;
	  private String description;
	  private String itemsIncludes;
	  private String alsoIncludes;
	  private String rulings;
	  private String excludes;
	  private String isicReference;
	  
	  public NaceOrderDto() {
			super();
		}
 
	  
	  
	public NaceOrderDto(String order, String level, String code, String parent, String description, String itemsIncludes,
			String alsoIncludes, String rulings, String excludes, String isicReference) {
		super();
		this.order = order;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.itemsIncludes = itemsIncludes;
		this.alsoIncludes = alsoIncludes;
		this.rulings = rulings;
		this.excludes = excludes;
		this.isicReference = isicReference;
	}
	
	public NaceOrderDto(NaceOrder obj) {
		super();
		this.order = obj.getOrderId();
		this.level = obj.getLevel();
		this.code = obj.getCode();
		this.parent = obj.getParent();
		this.description = obj.getDescription();
		this.itemsIncludes = obj.getItemsIncludes();
		this.alsoIncludes = obj.getAlsoIncludes();
		this.rulings = obj.getRulings();
		this.excludes = obj.getExcludes();
		this.isicReference = obj.getIsicReference();
	}
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItemsIncludes() {
		return itemsIncludes;
	}
	public void setItemsIncludes(String itemsIncludes) {
		this.itemsIncludes = itemsIncludes;
	}
	public String getAlsoIncludes() {
		return alsoIncludes;
	}
	public void setAlsoIncludes(String alsoIncludes) {
		this.alsoIncludes = alsoIncludes;
	}
	public String getRulings() {
		return rulings;
	}
	public void setRulings(String rulings) {
		this.rulings = rulings;
	}
	public String getExcludes() {
		return excludes;
	}
	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}
	public String getIsicReference() {
		return isicReference;
	}
	public void setIsicReference(String isicReference) {
		this.isicReference = isicReference;
	}
	  
	  

}
