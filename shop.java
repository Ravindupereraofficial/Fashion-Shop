import java.util.*;

class Orders{
	
	private String orderId;
	private String size;
	private int quantity;
	private double amount;
	private String tpnumber;
	private int status;
	
	
	//set
	
	public void setOrderId(String orderId){
		this.orderId=orderId;
		}
	public void setSize(String size){
		this.size=size;
		}	
	public void setquantity(int quantity){
		this.quantity=quantity;
		}
	public void setamount(double amount){
		this.amount=amount;
		}			
	public void settpnumber(String tpnumber){
		this.tpnumber=tpnumber;
		}
	public void setstatus(int status){
		this.status=status;
		}	
	
	//get

	public String getOrderId(){
		return orderId;
		}
	public int getquantity(){
		return quantity;
		} 	
	public String getSize(){
		return size;
		}	
	public double getamount(){
		return amount;
		} 
	public String gettpnumber(){
		return tpnumber;
		}
	public int getstatus(){
		return status;
		}
	
	
}

class Customer {
    private String tpNumber;
    private int totalQuantity;
    private double totalAmount;
    private int[] sizeQuantities;

    public Customer(String tpNumber) {
        this.tpNumber = tpNumber;
        this.totalQuantity = 0;
        this.totalAmount = 0.0;
        this.sizeQuantities = new int[6];
    }

	public Customer(String tpNumber, int qty, double amount) {
        this.tpNumber = tpNumber;
        this.totalQuantity = qty;
        this.totalAmount = amount;
        this.sizeQuantities = new int[6];
        initializeSizeQuantities();
    }

    public String getTpNumber() {
        return tpNumber;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addQuantity(int quantity) {
        this.totalQuantity += quantity;
    }

    public void addAmount(double amount) {
        this.totalAmount += amount;
    }

    public void initializeSizeQuantities() {
        for (int i = 0; i < sizeQuantities.length; i++) {
            sizeQuantities[i] = 0;
        }
    }

    public void updateSizeQuantity(String size, int quantity) {
        switch (size.toUpperCase()) {
            case "XS":
                sizeQuantities[0] += quantity;
                break;
            case "S":
                sizeQuantities[1] += quantity;
                break;
            case "M":
                sizeQuantities[2] += quantity;
                break;
            case "L":
                sizeQuantities[3] += quantity;
                break;
            case "XL":
                sizeQuantities[4] += quantity;
                break;
            case "XXL":
                sizeQuantities[5] += quantity;
                break;
            default:
                System.out.println("Unknown size: " + size);
                break;
        }
    }

    public int[] getSizeQuantities() {
        return sizeQuantities;
    }
}

class Items {
    private String size;
    private int totalQuantity;
    private double totalAmount;

    public Items(String size, int totalQuantity, double totalAmount) {
        this.size = size;
        this.totalQuantity = totalQuantity;
        this.totalAmount = totalAmount;
    }

    public String getSize() {
        return size;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addQuantity(int quantity) {
        this.totalQuantity += quantity;
    }

    public void addAmount(double amount) {
        this.totalAmount += amount;
    }
}

class shop{
		
	public static Orders[] OrdersMainArray=new Orders[0];
	
	public static String[] tshirtsizes={"XS","S","M","L","XL","XXL"};
	
	public static Scanner input=new Scanner(System.in);
	public static int z=0;
		
	public static final int PROCESSING=0;
	public static final int DELIVERING=1;
	public static final int DELIVERED=2;
	
	public final static void clearConsole() { 
		try {
		final String os = System.getProperty("os.name"); 
		if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", 
		"cls").inheritIO().start().waitFor();
		} else {
		System.out.print("\033[H\033[2J"); 
		System.out.flush();
		}
	} catch (final Exception e) {
		e.printStackTrace();
		
		}
	}

	public static void main(String args[]){	
		homePage();
	
	}

	public static void homePage(){
		System.out.println("\n");
		System.out.println("\t /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
		System.out.println("\t| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
		System.out.println("\t| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
		System.out.println("\t| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println("\t| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println("\t| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println("\t| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println("\t|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
		System.out.println("\t                                                                                                | $$      ");
		System.out.println("\t                                                                                                | $$      ");
		System.out.println("\t                                                                                                |__/      ");
		System.out.println("\n");
		System.out.println("\t_________________________________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Place Order                                        [2] Search Customer");
		System.out.println("\n");
		System.out.println("\t\t[3] Search Order                                       [4] View Reports");
		System.out.println("\n");
		System.out.println("\t\t[5] Set Order Status                                   [6] Delete Order");
		System.out.println("\n");
		System.out.print("\t\tInput Option : ");
		int option=input.nextInt();
		clearConsole();
		switch(option){
			
			case 1:
					placeOrder();
					break;
			
			case 2:
					searchCustomer();
					break;
			
			case 3:
					searchOrder();
					break;
			
			case 4:
					viewreports();
					break;
					
			case 5:
					setOrderStatus();
					break;
				
			case 6:
					deleteOrder();
					break;
			
			default:
					System.out.println("\t\tInvalid Input.......");
					homePage();
					break;											
			}	
	}
	public static void placeOrder(){
		System.out.println("\n");
		System.out.println("\t  _____  _                   ____          _           ");
		System.out.println("\t |  __ \\| |                 / __ \\        | |          ");
		System.out.println("\t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\n");
		System.out.println("\t_______________________________________________________");
		System.out.println("\n");
		
		orderId();
		
		System.out.println();
    
    
		String validatedPhoneNumber=phoneNumberValidate();
		if (validatedPhoneNumber.equals("not")) {
			System.out.println("\n\tBye Sudda !!!!!!!!!!!!!!!");
			return;
		}
		System.out.println();
				
		String lastsize=size();
		System.out.println();
		
		int lastqty=getquantity();
		if (lastqty==0) {
			return;	
		}		
		double lastamount=getamount(lastqty, lastsize);
		System.out.printf("\n\tAmount : %.2f", lastamount);
		System.out.println();
		
		System.out.print("\n\tDo you want to place this order? (y/n) : ");
		char option = input.next().charAt(0);
		if (option == 'y' || option == 'Y') {
			System.out.println("\n\t\tOrder Placed..!");
			z++;
			
			
			Orders[] tempOrdersMainArray=new Orders[OrdersMainArray.length+1];
		
			for(int i=0;i<OrdersMainArray.length;i++){
				tempOrdersMainArray[i]=OrdersMainArray[i];
				}
			
			Orders comingorder=new Orders();
			
			comingorder.setOrderId(genarateorderid());
			comingorder.setSize(lastsize);
			comingorder.setquantity(lastqty);
			comingorder.setamount(lastamount);
			comingorder.settpnumber(validatedPhoneNumber);
			comingorder.setstatus(PROCESSING);
			
			tempOrdersMainArray[tempOrdersMainArray.length-1]=comingorder;
			OrdersMainArray=tempOrdersMainArray;
			
			//System.out.println(OrdersMainArray[0].getOrderId());
			//System.out.println(OrdersMainArray[0].getSize());
			//System.out.println(OrdersMainArray[0].getquantity());
			//System.out.println(OrdersMainArray[0].getamount());
			//System.out.println(OrdersMainArray[0].gettpnumber());
			//System.out.println(OrdersMainArray[0].getstatus());
				
						
			}else{
				
				System.out.println("\n\t\tOrder not placed!!!!!!!!!!!!!!!!!!!!!");
			}
			
			System.out.print("\n\tDo you want to place another order? (y/n) : ");	
			char yesnoo = input.next().charAt(0);
			clearConsole();
			if(yesnoo=='y' || yesnoo=='Y'){
				placeOrder();
			}else{
				homePage();
			}	
	}
	
	public static String genarateorderid(){
		
		String ord="ODR#" + String.format("%05d", z);
		return ord;
		
		}		
		
    public static void orderId(){
			
        System.out.printf("\tEnter Order ID : ODR#%05d%n", z+1);
       		  
	  }

	public static String phoneNumberValidate(){
		
		System.out.print("\tEnter Phone Number : ");
		String phoneNumber=input.next();
		
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
			return phoneNumber;
			}else{
				System.out.println("\n\t\tInvalid Phone number... Try again");
				System.out.print("\n\tDo you wan to enter phone number agin? (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='y' || yesno=='Y'){
					System.out.print("\033[5A");//go to phone number
					System.out.print("\033[0J");//clear enterd phone number
					return phoneNumberValidate();
					}else{
						return "not";
						}
				
				}	
		
		}
	public static String size(){	
		System.out.print("\tEnter T-Shirt Size (XS/S/M/L/XL/XXL): ");
		String tsize=input.next().toUpperCase();
		
		boolean isValidsize=false;
		for(int a=0;a<6;a++){
			
			if(tsize.equals(tshirtsizes[a])){
				isValidsize=true;
				break;
				}
					
			}
			if(isValidsize){
				return tsize;
				}
					
					System.out.print("\033[1A");//go to phone number
					System.out.print("\033[0J");//clear enterd phone number
					return size();
		
		}

	public static int getquantity(){
		
		System.out.print("\tEnter QTY : ");
		int qty=input.nextInt();
		if(qty<=0){
		   System.out.print("\033[1A");
           System.out.print("\033[0J");
           	getquantity();
           	return 0;		
			}
			return qty;		
		
		}

		public static int getamount(int qty, String size){
		int amount=0;
        switch (size)
	   {
		case "XS": 
			amount=qty*600;
			break;
		case "S":
			amount=qty*800;
			break;
		case "M":
			amount=qty*900;
			break;
		case "L":
			amount=qty*1000;
			break;
		case "XL":
			amount=qty*1100;
			break;
		case "XXL":
			amount=qty*1200;
			break;
	   }
	   return amount;
		
		}

	public static void searchCustomer(){
		System.out.println("\n");
		System.out.println("\t   _____                     _        _____          _                            ");
		System.out.println("\t  / ____|                   | |      / ____|        | |                           ");
		System.out.println("\t | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
		System.out.println("\t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
		System.out.println("\t  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
		System.out.println("\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
		System.out.println("\t_________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		int data[] = new int[6];
		System.out.print("\tEnter Customer Phone Number : ");
		String inputphonenumber=input.next();
		
		
        boolean found = false;
        double totalAmount = 0;

        String[] processedSizes = new String[OrdersMainArray.length];
        int[] totalQtyForSize = new int[OrdersMainArray.length];
        double[] totalAmountForSize = new double[OrdersMainArray.length];
        int processedCount = 0;

		for (int i = 0; i < OrdersMainArray.length; i++) {
            if (OrdersMainArray[i].gettpnumber().equals(inputphonenumber)) {
                if (!found) {
                    System.out.println("\n\t+---------------+---------------+---------------+");
                    System.out.println("\t|\tSize\t|\tQTY\t|\tAmount\t|");
                    System.out.println("\t+---------------+---------------+---------------+");
					System.out.println("\t|               |               |               |");
                    found = true;
                }
                boolean sizeAlreadyProcessed = false;
                int index = -1;

                for(int k=0;k<processedCount;k++) {
                    if(processedSizes[k].equals(OrdersMainArray[i].getSize())) {
                        sizeAlreadyProcessed = true;
                        index=k;
                        break;
                    }
                }
                if (sizeAlreadyProcessed) {
                    totalQtyForSize[index] += OrdersMainArray[i].getquantity();
                    totalAmountForSize[index] += OrdersMainArray[i].getamount();
                } else {
                    processedSizes[processedCount] = OrdersMainArray[i].getSize();
                    totalQtyForSize[processedCount] = OrdersMainArray[i].getquantity();
                    totalAmountForSize[processedCount] = OrdersMainArray[i].getamount();
                    processedCount++;
                }
                totalAmount += OrdersMainArray[i].getamount();
            }
        }

           for (int i = 0; i < processedCount - 1; i++) {
            for (int j = 0; j < processedCount - i - 1; j++) {
                if (totalAmountForSize[j] < totalAmountForSize[j + 1]) {

                    String tempSize = processedSizes[j];
                    processedSizes[j] = processedSizes[j + 1];
                    processedSizes[j + 1] = tempSize;

                    int tempQty = totalQtyForSize[j];
                    totalQtyForSize[j] = totalQtyForSize[j + 1];
                    totalQtyForSize[j + 1] = tempQty;

                    double tempAmount = totalAmountForSize[j];
                    totalAmountForSize[j] = totalAmountForSize[j + 1];
                    totalAmountForSize[j + 1] = tempAmount;
                }
            }
        }
		
		for (int i = 0; i < processedCount; i++) {
			System.out.println("\t|\t" + processedSizes[i] + "\t|\t" + totalQtyForSize[i] + "\t|\t" + totalAmountForSize[i] + "\t|");
			System.out.println("\t|               |               |               |");
		}
		if (found) {
			System.out.println("\t+---------------+---------------+---------------+");
		} else {
			System.out.println("\n\tInvalid input..");
		}
		
			System.out.println("\n");		
			System.out.print("\tDo you want to search another customer report? (y/n) : ");
				char yesnor=input.next().charAt(0);
				clearConsole();
				if(yesnor=='Y' || yesnor=='y'){
					searchCustomer();
					}else{
						homePage();
						}

	}

	public static void searchOrder(){
		System.out.println("\n");
		System.out.println("\t   _____                     _        ____          _           ");
		System.out.println("\t  / ____|                   | |      / __ \\        | |          ");
		System.out.println("\t | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\t_________________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();
		
		
		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid ID ................");
			}else{
				showCustomerdetails(index);
				System.out.print("\n\tDo you want to search another order? (y/n) : ");
				char yesno=input.next().charAt(0);
				clearConsole();
					if(yesno=='Y' || yesno=='y'){
						searchOrder();
						}else{
							homePage();
							}
					
					
				}//if eka		
		System.out.print("\n\tDo you want to search another order? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			searchOrder();
			}else{
				
				homePage();
				
				}	    


	}
 
	public static void deleteOrder(){
		System.out.println("\n");
		System.out.println("\t  _____       _      _          ____          _           ");
		System.out.println("\t |  __ \\     | |    | |        / __ \\        | |          ");
		System.out.println("\t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();

		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid orderid ................");
			}else{
				showCustomerdetails(index);
				System.out.print("\n\tDo you want to delete this order (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='Y' || yesno=='y'){
						removeCustomer(index);
						System.out.println("\n\t\tOrder Deleted ...! ");
					}else{
						clearConsole();
						homePage();
						}
								
				}
		System.out.print("\n\tDo you want to delete another order? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			deleteOrder();
			}else{
				homePage();
				}	       

                                                                                                      
                                                          
	}
	

	public static int searchcustomerid(String inputorderid){
		for(int i=0;i<OrdersMainArray.length;i++){
			if(OrdersMainArray[i].getOrderId().equals(inputorderid)){
				
				return i;
				
				}
			
			}
	return -1;
	
	}
	public static void showCustomerdetails(int index){
		System.out.println("\n\tPhone Number : "+OrdersMainArray[index].gettpnumber());
		System.out.println("\tSize         : "+ OrdersMainArray[index].getSize());
		System.out.println("\tQTY          : "+OrdersMainArray[index].getquantity());
		System.out.printf("\tAmount       : %.2f%n", OrdersMainArray[index].getamount());
		System.out.println("\tStatus       : " +(OrdersMainArray[index].getstatus()==0 ? "Processing" : OrdersMainArray[index].getstatus()==1 ? "DELIVERING" : OrdersMainArray[index].getstatus()==2 ? "DELIVERED" : "NOT VALID STATUS"));
		
		}

	public static void removeCustomer(int index){
    
    Orders[] tempdeleteOrdersMainArray=new Orders[OrdersMainArray.length-1];
     
    for(int i=index; i<OrdersMainArray.length-1; i++){
     
        tempdeleteOrdersMainArray[i]=OrdersMainArray[i+1];
    }
    
    for(int i=0;i<index;i++){
		tempdeleteOrdersMainArray[i]=OrdersMainArray[i];
		}
    
      
     
	OrdersMainArray=tempdeleteOrdersMainArray;
    
	}

	public static void setOrderStatus(){
		System.out.println("\n");
		System.out.println("\t   ____          _              _____ _        _             ");
		System.out.println("\t  / __ \\        | |            / ____| |      | |            ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
		System.out.println("\t | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();


		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid orderid ................");
			}else{
				showCustomerdetails(index);
				
				if(OrdersMainArray[index].getstatus()==2){//delivered num eka para cus details ekk cant change this pennan (delivering thibboth if eka)	
				System.out.println("\n\t\tCan't change this order status, Order alredy delivered....!");
			
					}else{//ehem naththam wenas karannd kiyala ahanna
				System.out.print("\n\tDo you want to change this order status? (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='Y' || yesno=='y'){
					
					changeStatus(index);
									
					}else{
						clearConsole();
						homePage();
						}
					
				}
				}
								
		System.out.print("\n\tDo you want to change another order Status? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			setOrderStatus();
			}else{
				homePage();
				}	       

                                                                                                      
                                                          
	}

	public static void changeStatus(int index){
			if(OrdersMainArray[index].getstatus()==0){
				System.out.println("\n\t\t[1] Order Delivering");
				System.out.println("\n\t\t[2] Order Delivered");
				System.out.print("\n\tEnter Option : ");
					int option=input.nextInt();
								
					switch(option){
									
							case 1:
								changetodelivering(index);
								break;
							case 2:
								changetodevlivered(index);
								break;
							default:
								System.out.println("\n\t\tInvalid input...................");
								invalidinputt(index);
								break;
									
					}
								
				System.out.println("\n\t\tStatus Updated !!!!!!");	
							
				}
							
				else if(OrdersMainArray[index].getstatus()==1){
					System.out.println("\n\t\t[1] Order Delivered");
					System.out.print("\n\tEnter Option : ");
						int option2=input.nextInt();
							
							switch(option2){
									
								case 1:
									changetodevlivered(index);
									break;
										
								default:
									System.out.println("\n\t\tInvalid input...................");
									invalidinput(index);
									break;
										
									
								}
						System.out.println("\n\t\tStatus Updated !!!!!!");	
					}
							
	}

	public static void changetodelivering(int index){
		
		OrdersMainArray[index].setstatus(DELIVERING);
		
		}
	public static void changetodevlivered(int index){
				
		OrdersMainArray[index].setstatus(DELIVERED);

		}	
		
	public static void invalidinput(int index){
		System.out.print("\n\tEnter Option : ");
		int option=input.nextInt();
		
		if(option!=1){
			System.out.println("\n\t\tInvalid input...................");
			invalidinput(index);
			}else{
				changetodevlivered(index);
				}
		}
		
	public static void invalidinputt(int index){
		System.out.print("\n\tEnter Option : ");
		int option=input.nextInt();
		
		if(option==1){
			changetodelivering(index);
			
			}else if(option==2){
				changetodevlivered(index);
				}else{
					System.out.println("\n\t\tInvalid input...................");
					invalidinputt(index);
					}

		}
	
	public static void viewreports(){
		System.out.println("\n");
		System.out.println("\t  _____                       _       ");
		System.out.println("\t |  __ \\                     | |      ");
		System.out.println("\t | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t            | |                       ");
		System.out.println("\t            |_|                       ");
		System.out.println("\t_______________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Customer Reports");
		System.out.println("\n\t\t[2] Item Reports");
		System.out.println("\n\t\t[3] Orders Reports");
		System.out.println("\n");
		
		System.out.print("\tEnter Option : ");
		int option=input.nextInt();
		
		switch(option){
			
			case 1:
				clearConsole();
				customerreports();
				break;
				
			case 2:
				clearConsole();
				itemreports();
				break;
				
			case 3:
				clearConsole();
				ordersreportstables();
				break;		
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							viewreports();
					}else{
							clearConsole();
							homePage();
					}
				
			}

	}

	public static void customerreports(){
		
		System.out.println("\n");
		System.out.println("\t   _____          _                              _____                       _       ");
		System.out.println("\t  / ____|        | |                            |  __ \\                     | |      ");
		System.out.println("\t | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                                           | |                       ");
		System.out.println("\t                                                           |_|                       ");
		System.out.println("\t_______________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best in Customers");
		System.out.println("\n\t\t[2] View Customers");
		System.out.println("\n\t\t[3] All Customer Report");
		System.out.println("\n");
            		
		System.out.print("\tEnter Option : ");
		int optioncr=input.nextInt();
		
		
		switch(optioncr){
			
			case 1:
				clearConsole();
				bestInCustomers();
				break;
				
			case 2:
				clearConsole();
				viewcustomers();
				break;
				
			case 3:
				clearConsole();
				allcustomerreport();
				break;		
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							customerreports();
					}else{
							viewreports();
					}
				
			}
	
		}

	public static void itemreports(){
		System.out.println("\n");
		System.out.println("\t  _____ _                   _____                       _       ");
		System.out.println("\t |_   _| |                 |  __ \\                     | |      ");
		System.out.println("\t   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                      | |                       ");
		System.out.println("\t                                      |_|                       ");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best Selling Catgories Sorted by QTY");
		System.out.println("\n\t\t[2] Best Selling Categories Sorted by Amount");
		System.out.println("\n");
		
            		
		System.out.print("\tEnter Option : ");
		int optionir=input.nextInt();
		
		switch(optionir){
			
			case 1:
				clearConsole();
				sortedbyQTY();
				break;
				
			case 2:
				clearConsole();
				sortedByAmount();
				break;	
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							itemreports();
					}else{
							viewreports();
					}				
			}
				
		}

	public static void ordersreportstables(){
		System.out.println("\n");
		System.out.println("\t   ____          _             _____                       _       ");
		System.out.println("\t  / __ \\        | |           |  __ \\                     | |      ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                         | |                       ");
		System.out.println("\t                                         |_|                       ");
		System.out.println("\t____________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] All Orders");
		System.out.println("\n\t\t[2] Orders By Amount");
		System.out.println("\n");
		
            		
		System.out.print("\tEnter Option : ");
		int optionir=input.nextInt();

		switch(optionir){
			
			case 1:
				clearConsole();
				viewOrders();
				break;
				
			case 2:
				clearConsole();
				sortedByAmount();
				break;	
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							ordersreportstables();
					}else{
							viewreports();
					}
				
			}
		}

	public static void bestInCustomers(){
		System.out.println("\n");
		System.out.println("\t  ____            _     _____          _____          _                                ");
		System.out.println("\t |  _ \\          | |   |_   _|        / ____|        | |                               ");
		System.out.println("\t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("\t |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("\t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("\t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/ ");
		System.out.println("\t_______________________________________________________________________________________");
		System.out.println("\n");
		
		System.out.println("\n");
			
		Customer[] customers = new Customer[OrdersMainArray.length];
		int uniqueCustomers = 0;
		
		for (Orders Order : OrdersMainArray) {
			String tpNumber = Order.gettpnumber();
			int qty = Order.getquantity();
			double amount = Order.getamount();
		
			boolean isNewCustomer = true;
			int customerIndex = -1;
		
			for (int i = 0; i < uniqueCustomers; i++) {
				if (customers[i].getTpNumber().equals(tpNumber)) {
					isNewCustomer = false;
					customerIndex = i;
					break;
				}
			}
		
			if (isNewCustomer) {
				customers[uniqueCustomers] = new Customer(tpNumber, qty, amount);
				uniqueCustomers++;
			} else {
				customers[customerIndex].addQuantity(qty);
				customers[customerIndex].addAmount(amount);
			}
		}
		
		for (int i = 0; i < uniqueCustomers - 1; i++) {
			for (int j = 0; j < uniqueCustomers - i - 1; j++) {
				if (customers[j].getTotalAmount() < customers[j + 1].getTotalAmount()) {
					Customer temp = customers[j];
					customers[j] = customers[j + 1];
					customers[j + 1] = temp;
				}
			}
		}
		
		System.out.printf("\t+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s |\n", "Customer ID", "All QTY", "Total Amount");
		System.out.printf("\t+---------------+---------------+---------------+\n");
		
		for (int i = 0; i < uniqueCustomers; i++) {
			System.out.printf("\t|               |               |               |\n");
			System.out.printf("\t| %-13s | %-13d | %-13.2f |\n",
					customers[i].getTpNumber(),
					customers[i].getTotalQuantity(),
					customers[i].getTotalAmount());
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();
		
		if (toMenuInput == 0) {
			homePage();
		} else {
			bestInCustomers();
		}		
	}	

	public static void viewcustomers(){
		System.out.println("\n");
		System.out.println("\t __      ___                  _____          _                                ");
		System.out.println("\t \\ \\    / (_)                / ____|        | |                               ");
		System.out.println("\t  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("\t    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("\t     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println("\t_________________________________________________________________________________");
		System.out.println("\n");
			
		Customer[] customers = new Customer[OrdersMainArray.length];
		int uniqueCustomers = 0;

		for (Orders Order : OrdersMainArray) {
            String tpNumber = Order.gettpnumber();
            int quantity = Order.getquantity();
            double amount = Order.getamount();

            boolean isNewCustomer = true;
            int customerIndex = -1;
			
            for (int i = 0; i < uniqueCustomers; i++) {
                if (customers[i].getTpNumber().equals(tpNumber)) {
                    isNewCustomer = false;
                    customerIndex = i;
                    break;
                }
            }

            if (isNewCustomer) {
                customers[uniqueCustomers] = new Customer(tpNumber, quantity, amount);
                uniqueCustomers++;
            } else {
                customers[customerIndex].addQuantity(quantity);
                customers[customerIndex].addAmount(amount);
            }
        }

		System.out.printf("\t+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s |\n", "Customer ID", "All QTY", "Total Amount");
		System.out.printf("\t+---------------+---------------+---------------+\n");

		for (int i = 0; i < uniqueCustomers; i++) {
			System.out.printf("\t|               |               |               |\n");
			System.out.printf("\t| %-13s | %-13d | %-13.2f |\n", customers[i].getTpNumber(), customers[i].getTotalQuantity(), customers[i].getTotalAmount());
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			homePage();
		} else {
			viewcustomers();
			
		}
	}	
	public static void allcustomerreport(){
		
		System.out.println("\n");
		System.out.println("\t           _ _    _____          _                              _____                       _   ");
		System.out.println("\t     /\\   | | |  / ____|        | |                            |  __ \\                     | |  ");
		System.out.println("\t    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ");
		System.out.println("\t   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
		System.out.println("\t  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ ");
		System.out.println("\t /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
		System.out.println("\t                                                                          | |                   ");
		System.out.println("\t                                                                          |_|                   ");
		System.out.println("\t_________________________________________________________________________________________________");
		System.out.println("\n");
                                                                            
		System.out.println("\n");
		
		Customer[] customers = new Customer[OrdersMainArray.length];
		int uniqueCustomers = 0;

    for (Orders Order : OrdersMainArray) {
        String tpNumber = Order.gettpnumber();
        int qty = Order.getquantity();
        double amount = Order.getamount();
        String size = Order.getSize();

        boolean isNewCustomer = true;
        int customerIndex = -1;

        for (int i = 0; i < uniqueCustomers; i++) {
            if (customers[i].getTpNumber().equals(tpNumber)) {
                isNewCustomer = false;
                customerIndex = i;
                break;
            }
        }

        if (isNewCustomer) {
            customers[uniqueCustomers] = new Customer(tpNumber);
            customers[uniqueCustomers].initializeSizeQuantities();
            customerIndex = uniqueCustomers;
            uniqueCustomers++;
        }
        customers[customerIndex].updateSizeQuantity(size, qty);
        customers[customerIndex].addAmount(amount);
    }

    System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");
    System.out.printf("\t| Phone Number  | XS | S  | M  | L  | XL | XXL |  Total Amount |\n");
    System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");

    for (int i = 0; i < uniqueCustomers; i++) {
        int[] sizeQuantities = customers[i].getSizeQuantities();
        System.out.printf("\t|               |    |    |    |    |    |     |               |\n");
        System.out.printf("\t| %-13s | %-2d | %-2d | %-2d | %-2d | %-2d | %-3d |   %-12.2f|\n",
                customers[i].getTpNumber(),
                sizeQuantities[0], sizeQuantities[1], sizeQuantities[2], sizeQuantities[3], sizeQuantities[4], sizeQuantities[5],
                customers[i].getTotalAmount());
    }

    System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nTo access the main Menu, please enter 0 : ");
    int toMenuInput = scanner.nextInt();

    if (toMenuInput == 0) {
        homePage();
    } else {
        allcustomerreport();
    }
}

	public static void sortedbyQTY(){
		
		System.out.println("\n");
		System.out.println("\t   _____            _           _   ____           ____ _________     __");
		System.out.println("\t  / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /");
		System.out.println("\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / ");
		System.out.println("\t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  ");
		System.out.println("\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   ");
		System.out.println("\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   ");
		System.out.println("\t                                           __/ |                        ");
		System.out.println("\t                                          |___/                         ");
		System.out.println("\t______________________________________________________________________");
		System.out.println("\n");

		
        Items[] items = new Items[OrdersMainArray.length];
		int uniqueSizesCount = 0;
		
		
		for(Orders Order:OrdersMainArray){
			String size=Order.getSize();
			int quantity=Order.getquantity();
			double amount = Order.getamount();
			
			boolean isNewSize = true;
			int sizeIndex = -1;
		
			for (int i = 0; i < uniqueSizesCount; i++) {
				if (items[i].getSize().equals(size)) {
					isNewSize = false;
					sizeIndex = i;
					break;
			}
		}

		if (isNewSize) {
				items[uniqueSizesCount] = new Items(size, quantity, amount);
				uniqueSizesCount++;
			} else {
				items[sizeIndex].addQuantity(quantity);
				items[sizeIndex].addAmount(amount);
			}
		}

		for (int i = 0; i < uniqueSizesCount - 1; i++) {
			for (int j = 0; j < uniqueSizesCount - i - 1; j++) {
				if (items[j].getTotalQuantity() < items[j + 1].getTotalQuantity()) {
					Items temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}

		System.out.printf("\n\t+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s |\n", "Size", "Total QTY", "Total Amount");
		System.out.printf("\t+---------------+---------------+---------------+\n");
		for (int i = 0; i < uniqueSizesCount; i++) {
			System.out.printf("\t|               |               |               |\n");
 			System.out.printf("\t| %-13s | %-13d | %-13.2f |\n", items[i].getSize(), items[i].getTotalQuantity(), items[i].getTotalAmount());
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			homePage();
		} else {
			System.out.println("Invalid input..");
			clearConsole();
			sortedbyQTY();
		}
	}
		
	public static void sortedbyamount(){
		
		System.out.println("\n");
		System.out.println("\t   _____            _           _   ____                                               _   ");
		System.out.println("\t  / ____|          | |         | | |  _ \\            /\\                               | |  ");
		System.out.println("\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println("\t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println("\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println("\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println("\t                                           __/ |                                           ");
		System.out.println("\t                                          |___/                                            ");
		System.out.println("\t_________________________________________________________________________________________");
		System.out.println("\n");


		Items[] items = new Items[OrdersMainArray.length];
		int uniqueSizesCount = 0;

		for (Orders Order : OrdersMainArray) {
			String size = Order.getSize();
			int qty = Order.getquantity();
			double amount = Order.getamount();
		
			boolean isNewSize = true;
			int sizeIndex = -1;
		
			for (int i = 0; i < uniqueSizesCount; i++) {
				if (items[i].getSize().equals(size)) {
					isNewSize = false;
					sizeIndex = i;
					break;
				}
			}
		
			if (isNewSize) {
				items[uniqueSizesCount] = new Items(size, qty, amount);
				uniqueSizesCount++;
			} else {
				items[sizeIndex].addQuantity(qty);
				items[sizeIndex].addAmount(amount);
			}
		}

		for (int i = 0; i < uniqueSizesCount - 1; i++) {
			for (int j = 0; j < uniqueSizesCount - i - 1; j++) {
				if (items[j].getTotalAmount() < items[j + 1].getTotalAmount()) {
					Items temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}

		System.out.printf("\n\t+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s |\n", "Size", "Total QTY", "Total Amount");
		System.out.printf("\t+---------------+---------------+---------------+\n");
		for (int i = 0; i < uniqueSizesCount; i++) {
			System.out.printf("\t|               |               |               |\n");
			System.out.printf("\t| %-13s | %-13d | %-13.2f |\n", items[i].getSize(), items[i].getTotalQuantity(), items[i].getTotalAmount());
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			homePage();
		} else {
			System.out.println("Invalid input..");
			sortedByAmount();
		}
	}


	public static void viewOrders(){
		
		System.out.println("\n");
		System.out.println("\t __      ___                  ____          _               ");
		System.out.println("\t \\ \\    / (_)                / __ \\        | |              ");
		System.out.println("\t  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
		System.out.println("\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
		System.out.println("\t    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
		System.out.println("\t     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
				
		System.out.printf("\n\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s | %-13s | %-13s | %-13s |\n", "Order ID", "Customer ID", "Size", "Quantity", "Amount", "Status");
		System.out.printf("\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		
		for (Orders Order : OrdersMainArray) {
			
			System.out.printf("\t| %-13s | %-13s | %-13s | %-13d | %-13.2f | %-13s |\n",
				
				Order.getOrderId(),
				Order.gettpnumber(),
				Order.getSize(),
				Order.getquantity(),
				Order.getamount(),
				Order.getstatus());
		}
		System.out.printf("\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0: ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			homePage();
		} else {
			System.out.println("Invalid input..");
			viewOrders();
		}
	}


	public static void sortedByAmount(){
		System.out.println("\n");
		System.out.println("\t   ____          _                 ____                                               _   ");
		System.out.println("\t  / __ \\        | |               |  _ \\            /\\                               | |  ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println("\t | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println("\t                                          __/ |                                           ");
		System.out.println("\t                                         |___/                                            ");
		System.out.println("\t__________________________________________________________________________________________");
		System.out.println("\n");
		
		
		
		Orders[] sortedOrders = new Orders[OrdersMainArray.length];
			for (int i = 0; i < OrdersMainArray.length; i++) {
        sortedOrders[i] = OrdersMainArray[i];
    }
    
    for (int i = 0; i < sortedOrders.length - 1; i++) {
        for (int j = 0; j < sortedOrders.length - 1 - i; j++) {
            if (sortedOrders[j].getamount() < sortedOrders[j + 1].getamount()) {
                Orders temp = sortedOrders[j];
                sortedOrders[j] = sortedOrders[j + 1];
                sortedOrders[j + 1] = temp;
            }
        }
    }

		System.out.printf("\n\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s | %-13s | %-13s | %-13s |\n", "Order ID", "Customer ID", "Size", "Quantity", "Amount", "Status");
		System.out.printf("\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		for (Orders order : sortedOrders) {
			System.out.printf("\t| %-13s | %-13s | %-13s | %-13d | %-13.2f | %-13s |\n",
				order.getOrderId(),
				order.gettpnumber(),
				order.getSize(),
				order.getquantity(),
				order.getamount(),
				order.getstatus());
		}
		System.out.printf("\t+---------------+---------------+---------------+---------------+---------------+---------------+\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTo access the main Menu, please enter 0: ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			homePage();
		} else {
			System.out.println("Invalid input..");
			sortedByAmount();
		}
	}
}


