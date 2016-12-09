/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс документ заявка 
*/

package ru.szhernovoy.model;

class Item {

	private String id;
	private String name;
	private String description;
	private long create;
	
	public Item(String name, String descr, long create){
		this.name = name;
		this.description = descr;
		this.create = create;
	}
	
	public void setName(String name){
			this.name = name;
	}
	
	public void setDescr(String descr){
			this.description = descr;
	}
	
	public void setData(long data){
			this.create = data;
	}
	
	public void setId(String id){
			this.id = id;
	}
	
	public String getName(){
		return this.name;	
	}
	
	public String getDescr(){
		return this.description;	
	}
	
	public long getCreate(){
		return this.create;	
	}
	
	public String getId(){
		return this.id;	
	}
	
}