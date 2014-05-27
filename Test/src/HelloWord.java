
public class HelloWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello Word!");

int[] table = {1,5,99,55,111,1,4};
for (int i=0 ;i<=(table.length-2);i++)
	
    for (int j=(table.length-1);i < j;j--)
    	
            if (table[j] < table[j-1])
        
            {
                    int tmp=table[j-1];
                    table[j-1]=table[j];
                    table[j]=tmp;
            }

	}
	


}
