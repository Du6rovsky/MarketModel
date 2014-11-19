package marketmodel

class Cash {
	
	int performance = (int) Math.round(Math.random()*9 + 1)
	
	int catered
	
	Queue<Customer> queue = new LinkedList<Customer>()
	
    static constraints = {
    }
}
