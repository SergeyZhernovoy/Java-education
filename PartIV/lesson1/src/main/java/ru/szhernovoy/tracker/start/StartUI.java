/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.szhernovoy.tracker.start;
import ru.szhernovoy.tracker.templates.*;

/**
 * main program
 */
public class StartUI{

	/**input method */
	private final Input input;
	/**value ref on menu */
	private final MenuTracker menu;

    /**Refactor.
	 * Main constructor.
	 * @param input
	 * @param menu
     */
	public StartUI(final Input input, final MenuTracker menu){
		this.input = input;
		this.menu = menu;
	}

	/**Refactor.
	 * Main loop programs. Show menu , set and print question, do any action from menu
     */
	public void init(){

		int[] range = this.menu.getRangeKeys();
		do{
		    this.menu.show();
			this.input.setQuestion("select: ");
			this.input.printQuestion();
			this.menu.select(this.input.ask(range));
			this.input.setQuestion("Exit? (y)");
			this.input.printQuestion();
		}
		while(!"y".equals(this.input.ask()));
	
	}

	/**
	 * Execute program
	 * @param args
     */
	public static void main(String[] args){

		Input input = new ValidateInput();
		Tracker track = new Tracker();
		MenuTracker menu = new MenuTracker(input,track);
		menu.fillActions();
		new StartUI(input,menu).init();
	}
}