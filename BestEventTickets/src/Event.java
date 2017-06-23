/**
 * This represents an event
 */

/**
 * @author tao
 * @version 06/20/2017
 */
public class Event {
	int eventID;				//ID of event
	char eventName;			//Name of event
	double location_X;	//the location coordinate x 
	double location_Y;	//the location coordinate y
	double distance;    //the distance to user
	Ticket[] ticketList;	//different tickets list of this event
	int typeAmount; 	//this variable means how many different types of tickets this event have
	
	
public Event( ) {
		
		// the number of type, the amount of each type
		//randomly generate the tickets data, the number of available tickets of each event
		
    
		double typeAmountDouble = Math.random()*10; // we assume the tickets have [0,10] different types
		typeAmount = (int) typeAmountDouble;
		//System.out.print(typeAmount);
		
		ticketList = new Ticket[typeAmount];
		
		for (int i = 0; i < typeAmount; i++){
		
			double ticketsAmountDoule = Math.random()*1000; // we assume the amount of each type of ticket is [0,100] 
			int ticketsAmount = (int) ticketsAmountDoule;
			//System.out.print(ticketsAmount);
			
			double ticketprice = Math.random()*100;		// we assume the price range of each type ticket is from [0, 100]
			ticketprice = Math.round(ticketprice*100.0)/100.0;//round the decimal into two digits
			
			ticketList[i] = new Ticket();
			ticketList[i].setID(i);
			ticketList[i].setPrice(ticketprice);
			ticketList[i].setAmount(ticketsAmount);
		}
		
	}

	
	public int getID() {
		return eventID;
	}


	public void setID(int iD) {
		eventID = iD;
	}


	public char getName() {
		return eventName;
	}


	public void setName(char name) {
		eventName = name;
	}


	public double getLocationX() {
		return location_X;
	}


	public void setLocationX(double locationX) {
		location_X = locationX;
	}


	public double getLocationY() {
		return location_Y;
	}


	public void setLocationY(double locationY) {
		location_Y = locationY;
	}

	public Ticket[] getTickets() {
		return ticketList;
	}


	public void setTickets(Ticket[] tickets) {
		ticketList = tickets;
	}
	

	public int getTypeAmount() {
		return typeAmount;
	}


	public void setTypeAmount(int typeAmount) {
		this.typeAmount = typeAmount;
	}


	public double getDistance(double user_X, double user_Y) {
            this.distance = Math.sqrt(Math.pow((user_X - this.location_X),2) + Math.pow((user_Y - this.location_Y), 2));
            this.setDistance(distance);
            return distance;
	}
        
    public void setDistance(double distance)
    {
        this.distance = distance;        
    }
    
    public Ticket getCheapestTicket()
    {
        return this.ticketList[getCheapestTicketIndex()];
    }
        
    public int getCheapestTicketIndex()
    {
        double cheapestPrice = this.ticketList[0].getPrice();
        int cheapestIndex = 0;        
            for(int i = 1; i < ticketList.length; i++)
            {
                if (ticketList[i].getPrice() < cheapestPrice)
                {
                    cheapestPrice = ticketList[i].getPrice();
                    cheapestIndex = i;
                }
            }
            
        return cheapestIndex;
    }

    @Override
    public String toString() {
        return "Event" + eventID + "\t\t"
               // + "Event Name: " + eventName + "\t"
                + "Cheapest Price:$" + getCheapestTicket().getPrice() + "\t"
                + "Ticket Amount: " + getCheapestTicket().getAmount() ;
    }


	
}
