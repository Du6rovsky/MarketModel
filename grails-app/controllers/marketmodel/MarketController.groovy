package marketmodel

class MarketController {
	
	def beforeInterceptor = [action: this.&index]
	
	static scaffold = true
	
	def index() {
		def markets = Market.list()
		[markets:markets]
	}
	
	def run(){
		
		def market = new Market(params)
		market.save()
		
		int cd = market.cd
		int steps = market.steps
		int m = market.m
		int w = market.w
		int k = market.k
		
		//create cash desks		
		Cash[] cashS = new Cash[cd]
		for(int c =0; c <= cd; c++){
			try{
				cashS[c] = new Cash();
				cashS[c].id = c+1;
			}catch (ArrayIndexOutOfBoundsException e){}
		}
		//open our market for steps count time
		for(int i = 0; i <steps; i++){
			
			//reset newstatus all customers
			for(int h = 0; h < cashS.length; h ++){
				if(cashS[h].queue.size() != 0){
					Iterator<Customer> o = cashS[h].queue.iterator();
					try{
						Customer head = cashS[h].queue.element();
						head.newstatus = false
						while(o.hasNext()){
								o.next().newstatus = false
						}
					}catch(NoSuchElementException e){}
				}
			}			
			
			//create customer			
			def customer = new Customer()
			customer.newstatus = true
				
			//choose customer type
			String[] typeStorage = new String [100];
			
			for(int t = 0 ; t < m; t++){
				try{typeStorage[t] = "Man";}
				catch(NullPointerException e){}
			}
			
			for(int t = m ; t < (m+w); t++){
				try{typeStorage[t] = "Woman";}
				catch(NullPointerException e){}	
			}
			
			for(int t = (m+w) ; t < (m+w+k); t++){
				try{typeStorage[t] = "Kid";
				}catch(NullPointerException e){}
			}
			
			Random chooser = new Random();
			String ctype = typeStorage[chooser.nextInt(typeStorage.length)];
			customer.type = ctype
			
			
			//customer choose queue
			
			//If customer type is man
			if(customer.type=="Man"){
				Flash[] speedStorage = new Flash[cashS.length];
				for(int c = 0; c != cashS.length; c++){
		
					int[] goods = new int[cashS[c].queue.size() + 1];
					if(cashS[c].queue.size() != 0){
						int counter = 0;
						Customer head = cashS[c].queue.element();
						goods[counter] = head.goods;
						counter ++;
						Iterator<Customer> o = cashS[c].queue.iterator();
						while(o.hasNext()){
								goods[counter] = o.next().goods;
								counter ++;
						}
					}
					
					try{
						goods[goods.length-1] = customer.goods;
					}catch (ArrayIndexOutOfBoundsException e){}
					
					int count = 0;
					int perf = cashS[c].performance;
					for(int s=0; s < goods.length; s++){
						int processor;
						int reducer = goods[s];
						processor = reducer - perf;
						count ++;
						while(processor > 0){
							processor = processor - perf;
							count ++;
						}
					}
					speedStorage[c] = new Flash();
					speedStorage[c].id = cashS[c].id;
					speedStorage[c].response = count;
					
				}
				
				try{
					int faster = speedStorage[0].response;
					int id_faster = speedStorage[0].id;
					
					for(int fw = 0; fw != speedStorage.length; fw ++){
						if(speedStorage[fw].response < faster){
							faster = speedStorage[fw].response;
							id_faster = speedStorage[fw].id;
						}
					}
					for(int s = 0; s != cashS.length; s++){
						if(id_faster == cashS[s].id){
							cashS[s].queue.add(customer);
						}
					}
					
				}catch(NullPointerException e){}
				
			}
			
			//If type of customer is woman
			if(customer.type=="Woman"){
				Elastika[] queueLenght = new Elastika[cashS.length];
				
				for(int q = 0; q != cashS.length; q++){
					try{
						queueLenght[q] = new Elastika();
						queueLenght[q].length = cashS[q].queue.size();
						queueLenght[q].id = cashS[q].id;
					}catch (NullPointerException e){}
				}
				
				try{
					int min = queueLenght[0].length;
					int min_id = queueLenght[0].id;
					
					for(int ql = 0; ql != queueLenght.length; ql ++){
						if(queueLenght[ql].length < min){
							min = queueLenght[ql].length;
							min_id = queueLenght[ql].id;
						}
						if(queueLenght[ql].length == min){
							if(queueLenght[ql].id < min_id){
								min = queueLenght[ql].length;
								min_id = queueLenght[ql].id;
							}
						}
					}
					
					for(int sw = 0; sw != cashS.length; sw++){
						if(min_id == cashS[sw].id){
							cashS[sw].queue.add(customer);
						}
					}
					
				}catch(NullPointerException e){}
				
			}
			
			//If type of customer is kid
			if(customer.type=="Kid"){
				int finder = (int) Math.round(Math.random()*(cashS.length-1));
				cashS[finder].queue.add(customer);
			}
			
			//cash desks start work
			
			for(int csh = 0; csh < cashS.length; csh ++){
				if(cashS[csh].queue.size() != 0){
					int power = cashS[csh].performance;
					try{
						Customer head = cashS[csh].queue.element();
						head.goods = head.goods - power;
						if( head.goods <= 0){
							cashS[csh].queue.remove();
							cashS[csh].catered = (cashS[csh].catered) + 1;
						}
					}catch(NoSuchElementException e){}
				}
			}
		}
		
		def cashList = cashS
		[cashList : cashList]
	}
	
	def add={
		redirect(action: 'create')
	}
}
