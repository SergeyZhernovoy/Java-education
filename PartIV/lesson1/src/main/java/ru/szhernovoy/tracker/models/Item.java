/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс документ заявка 
*/

package ru.szhernovoy.tracker.models;

class Item {

	/** The value storage uniquie identifier item. */
	private String id;
	/** This is name item.*/
	private String name;
	/** The value identify full purpose item.*/
	private String description;
	/** This value save date time create item.*/
	private long create;

	/**
	 * Setting initial parameters while create.
	 * @param name
	 * @param descr
	 * @param create
     */
	public Item(String name, String descr, long create){
		this.name = name;
		this.description = descr;
		this.create = create;
	}

	/**
	 * Setting field name.
	 * @param name
     */
	public void setName(String name){
			this.name = name;
	}

	/**
	 * Setting field description.
	 * @param descr
     */
	public void setDescr(String descr){
			this.description = descr;
	}

	/**
	 * Setting field data time create.
	 * @param data
     */
	public void setData(long data){
			this.create = data;
	}

	/**
	 * Setting id.
	 * @param id
     */
	public void setId(String id){
			this.id = id;
	}

	/**
	 * Get field name.
	 * @return name
     */
	public String getName(){
		return this.name;	
	}

	/**
	 * Get field description.
	 * @return decription
     */
	public String getDescr(){
		return this.description;	
	}

	/**
	 * Get field create.
	 * @return create
     */
	public long getCreate(){
		return this.create;	
	}

	/**
	 * Get field id.
	 * @return id
	 *
     */
	public String getId(){
		return this.id;
	}

}