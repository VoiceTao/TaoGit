import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static int EventAmount = 50; //it means there are 50 events in this area 
	
	// This is the main function
	public static void main(String[] args) {
		System.out.print("Hello, Welcome to Viagogo! Please input your current location"+"\n");
		
		try {
			DataSeed.dataGeneration(EventAmount);

			Scanner input = new Scanner(System.in);
			double x=0; 
			double y =0;
			
			System.out.print("Please enter the X coordinate"+"\n");
			x = input.nextDouble();
			
			System.out.print("Please enter the Y coordinate"+"\n");
			y = input.nextDouble();
                        
			input.close();
		
            ClosestEvents.getClosestEvents(x, y);// user input the location coordinates, return five closest events with the cheapest price 
            
            //System.out.print("Here are the dataset "+"\n");
            //DataSeed.print(EventAmount);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	
	

	
}
