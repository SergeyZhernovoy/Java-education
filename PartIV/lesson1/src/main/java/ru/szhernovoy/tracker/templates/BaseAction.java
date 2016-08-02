/**
 * abstract class extends user action
*@author Sergey Zhernovoy
*@since 12-07-2016
*This abstract class determined any action by class 
*/

package ru.szhernovoy.tracker.templates;


public abstract class BaseAction implements UserAction{
    /**name action for menu*/
	private String name;

	/**
	 * Main constructor
	 * @param name Name action menu
     */
	public BaseAction(String name){
		this.name = name;
	}

	/**
	 * Print infomation about method
	 * @return
     */
	public String info(){
		return String.format("%s.) %s", this.key(),this.name);
	}
	

}