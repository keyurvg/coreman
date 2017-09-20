class synch 
{
	Boolean t = true;
	
	public void printOddNumber(int n)
	{
		for(int i=1; i<=n; i=i+2)
		{
			synchronized (this) {
				if(t == true)
					try{
						wait();
					}
				catch(InterruptedException e){}
				System.out.println("odd number " + i );
				t = true;
				notify();
			}
			
		}
	}
	
	public void printEvenNumber(int n)
	{
		for(int i=0; i<=n; i=i+2)
		{
			
			synchronized (this) {
				if(t == false)
					try{
						wait();
					}
				catch(InterruptedException e){}
				System.out.println("even number" + i);
				t = false;
				notify();
			}		
			
		}
	}
}

class PrintNumberOdd implements Runnable
{
	int n;
	synch s1;
	PrintNumberOdd(int m, synch s1)
	{
		this.n = m;
		this.s1 = s1;
	}
	
	public void run()
	{
		s1.printOddNumber(n);
	}
}

class PrintNumberEven implements Runnable
{
	int n;
	synch s1;
	PrintNumberEven(int m, synch s1)
	{
		this.n = m;
		this.s1 = s1;
	}
	
	public void run()
	{
		s1.printEvenNumber(n);
	}
}

class ThreadTest1{
	public static void main(String args[])
	{
		synch obj1 = new synch();
		PrintNumberOdd m = new PrintNumberOdd(100, obj1);
		PrintNumberEven n = new PrintNumberEven(100, obj1);
		new Thread(n).start();
		new Thread(m).start();
		
		System.out.println("Keyur");
	}
}