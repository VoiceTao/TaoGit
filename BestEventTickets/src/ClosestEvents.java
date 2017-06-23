
public class ClosestEvents {
	
	// This is to get five closest events. the location coordinates inputed by user
	static int[] tempList = {-1, -1, -1, -1, -1}; // the array for sorting
	 
    public static void getClosestEvents(double x, double y) {  
		
		Event []closestEvents= new Event[5]; 		//the array for storing the five closest events 
        double[] closestDistance = new double[5]; 	//the array for storing the closest distance of each event, five closest distances
        int [] closestIndex = {1, 2, 3, 4, 5}; 		//the array for storing the indexes of these five closest events
        
        //initialize the five closest events, and their distances
 		for (int i=0; i<5; i++){
			closestEvents[i] = new Event();
			closestEvents[i] = DataSeed.eventlist[i];
			closestDistance[i] = DataSeed.eventlist[i].getDistance(x, y);
        }
		    
        int current_lonestIndex = findLongestDistance(closestDistance); //get the index of the longest one from the five closest distance array
                
		//search from the other events and update the array of five closest events
		for (int i=5; i < DataSeed.eventlist.length; i++)
		{
	        double curr_distance = DataSeed.eventlist[i].getDistance(x, y); 	// calculate the distance from the user to each event
	        //System.out.println("Event"+DataSeed.eventlist[i].getID() +  "\t" + "Distance:"+ curr_distance);
	        if(curr_distance < closestDistance[current_lonestIndex]) 			//if current distance < the current longest distance in the closest distance list
	        {
	             closestDistance[current_lonestIndex] = curr_distance;			// update the closest distance array
	             closestIndex[current_lonestIndex] = i; 
	             current_lonestIndex = findLongestDistance(closestDistance);               
	        }
		}

		System.out.println("Your current location:("+ x+","+y+")");
                
        for(int i = 0; i < 5; i ++)		//get the initial five index of the closestdistance									//find the shortest one from the five closest distances array, and get its index in the five shortest distance  
        {
             int index = findShortestDistance(closestDistance);	
             tempList[i] = index;
        }
      
        System.out.println("\nHere are the five closest events and their cheapest ticket for you!\n");
       
        for(int i = 0; i < closestIndex.length; i++)
        {                   
                System.out.println(DataSeed.eventlist[closestIndex[tempList[i]]]);
                System.out.println("Distance from your location: " + Math.round(closestDistance[tempList[i]]*100.0)/100.0 + "\n");                    
        }        	   
	}
    
    //this is to check if the xx  exist in the array list, to reduce the calculation and consumption.
    public static boolean checkIndexExist(int[] indexList, int index)
        {
            for(int i = 0; i < indexList.length; i++)
            {
                if(indexList[i] == index)
                    return true;
            }
            return false;
        }
    
    // this function is to find the longest distance from the distance list
    public static int findLongestDistance(double[] distanceList)
        {
            double longestDistance = distanceList[0];
            int longestIndex = 0;
            
            for(int i = 1; i < distanceList.length; i++)
            {
                if (distanceList[i] > longestDistance)
                {
                    longestDistance = distanceList[i];
                    longestIndex = i;
                }
            }
            
            return longestIndex;
        }
        
    //this function is to find the shortest one from the distance list, and return its index. In order to sort the five shortest distance  
    public static int findShortestDistance(double[] distanceList)
        {
            double shortestDistance = 999.99;
            int shortestIndex = 99;
            for(int i = 0; i < distanceList.length; i++)
            {
                 if(!checkIndexExist(tempList, i))
                   {
                        if (distanceList[i] < shortestDistance)
                        {
                            shortestDistance = distanceList[i];
                            shortestIndex = i;
                        }
                   }
            }
            
            return shortestIndex;
        }

}
