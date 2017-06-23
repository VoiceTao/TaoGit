import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class DataSeed {
	public static Event [] eventlist;
	// generate the data seeds 
		public static void dataGeneration(int Num) throws IOException{
			
			//Randomly generate the events data, the number of available events are defined as global variable "EventAmount"
			//we assume there are "EventAmount" events in the area of (X,Y) -10<X<10, -10<Y<10.
			eventlist = new Event[Num];	//create an array space for the event list
			
			for (int i=0; i < Num; i++){
				eventlist[i] = new Event();			//create every single event	
				eventlist[i].setID(i+1);			//set Event ID from 1 to EventAmount
				eventlist[i].setLocationX((Math.random()*10 - 5) *2);//math.random range from 0 to 1; (0,1)*10=(0,10); (0,10)-5=(-5,5); (-5,5)*2=(-10,10); 
				eventlist[i].setLocationY((Math.random()*10 - 5) *2);
			}
			
			FileOutputStream fos = new FileOutputStream("dataset.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);;
			
			//write the dataset file
			for (int i=0;i<Num; i++){
				int n = eventlist[i].getTypeAmount();		//for every event, get the the different ticket types
				for (int j=0; j < n ; j++){
					bw.write("Event"+eventlist[i].getID()+"\t\t"
							+"Location:" + "(" + (int)eventlist[i].location_X + "," + (int)eventlist[i].location_Y + ")" + "\t"
							+"Price:$"+eventlist[i].ticketList[j].getPrice()+"\t"
							+"amount:" + eventlist[i].ticketList[j].getAmount() + "\n"); 
				}
			}
			bw.close();
			
			
		}

	public static void print(int Num){
		// print the data
		
		for (int i=0; i < Num; i++){
			int n = eventlist[i].getTypeAmount();		//for every event, get the the different ticket types
			for (int j=0; j < n ; j++){
				
				System.out.print("Event"+eventlist[i].getID()+"\t"); 
				System.out.print("Location:" + "(" + (int)eventlist[i].location_X + "," + (int)eventlist[i].location_Y + ")" + "\t"+ "\t"); 
				System.out.print("Price:"+eventlist[i].ticketList[j].getPrice()+"\t" + "amount:" + eventlist[i].ticketList[j].getAmount() + "\n"); 	
				
			} 
		}
	}
}
