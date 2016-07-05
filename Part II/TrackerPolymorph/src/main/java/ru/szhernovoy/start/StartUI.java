/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;

public class StartUI{
	
	private Input input;
	private final String menu = 
	  "\nPress num for choice action"+
	  "\n1)add task"+
	  "\n2)update task"+
	  "\n3)delete task"+
	  "\n4)print all task"+
	  "\n5)print by filter"+
	  "\n6)add commentary"+
	  "\n7)print commentary"+
	  "\n8)exit\n\n";
	  
	private Tracker myTrack = new Tracker();
	
	public StartUI(Input input){
		this.input = input;
	}
	
	public void init(){
		
		boolean exit = false;	
	    
		
		while(!exit){
			int numMenu = Integer.parseInt(this.input.ask(this.menu));
			
			switch(numMenu){
				case 1: addTask();
						break;
				case 2: updateTask();
						break;
				case 3: deleteTask();
						break;
				case 4: printAllTask();
						break;
				case 5: printByFilter();
						break;
				case 6: addComment();
						break;
				case 7: printComment();
						break;
				case 8: exit = true;
						break;		
				default:
					System.out.println("\nError, wrong num...");			
			}
		}
	}	
		
	public void addTask(){
		String name = input.ask("\nPlease enter the task name:>\t");
		String descr = input.ask("\nPlease enter decription task:>\t");
		if(name != null && !name.equals("")){
			this.myTrack.addItem(new Task(name,descr));
			System.out.println("add task");
		}
	}	
	
	public void updateTask(){
		String name = input.ask("\nPlease enter the task name:>\t");
		String descr = input.ask("\nPlease enter decription task:>\t");
		String idSearch = input.ask("\nPlease enter id task for update:>\t");
		 
		if(name != null && !name.equals("")){
			Task task = new Task(name,descr);
			task.setId(idSearch);
			this.myTrack.updateItem(task);
			System.out.println("update task");
		}
	}		
		
	public void deleteTask(){
		
		String idSearch = input.ask("\nPlease enter id task for delete:>\t");
		if(idSearch != null && !idSearch.equals("")){
			this.myTrack.deleteItem(myTrack.findById(idSearch));
			System.out.println("delete task");
		}
	}	

	public void printAllTask(){
		System.out.println("Print all task");
		//print all task	
		for(Task item : this.myTrack.getAll()){
			System.out.println("name = "+item.getName()+" id = "+item.getId());
		}
	}

	public void printByFilter(){
		
		String filter = input.ask("Please enter filter for print task:>\t");
		//print  task with filter	
		for(Task item : this.myTrack.findByFilter(filter)){
			System.out.println("name = "+item.getName()+" id = "+item.getId());
		}
	}
					
	public void addComment(){
		String idSearch = input.ask("\nPlease enter id task for add comment:>\t");
		String comment  = input.ask("\nPlease enter comment:>\t");
		if(idSearch != null && !idSearch.equals("")){
			this.myTrack.addCommentary(this.myTrack.findById(idSearch),comment);
			System.out.println("add comment in task");
		}
	}

	public void printComment(){
		String idSearch = input.ask("\nPlease enter id task for print comment:>\t");
		if(idSearch != null && !idSearch.equals("")){
		   System.out.println("comment =  "+this.myTrack.getCommentary(this.myTrack.findById(idSearch)));
		}
	}
		
	
	public static void main(String[] args){
	
		StartUI start = new StartUI(new ConsoleInput());
		start.init();
	}
	
	
}