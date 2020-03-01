import java.io.*;
import java.util.*;
import java.nio.file.*;
 
public class Cars

{
    
    int car(String car_input1, String result, String O) throws IOException 
	{

        PrintWriter pw = new PrintWriter(result);        
        BufferedReader br = new BufferedReader(new FileReader(car_input1));         
        String line = br.readLine();  
        float sum=0; 
        int avg=0, c=0;    
        
        while(line != null)
        {          
            String[] arr = line.split(",");
            int l = arr.length;

            if(l==3) {
                if(arr[1].equals(O)){
                    sum = sum+Float.parseFloat(arr[2]);
                    c++;
                    pw.println(line);                  
                    pw.flush();
                }
            } 

	line = br.readLine();
                         
        }

        avg = (int)sum/c;
     
        br.close();        
        pw.close(); 
        return avg;      
    }
    public static void main(String[] args) throws IOException 
    {
        Cars ca = new Cars();
        Scanner sc = new Scanner(System.in);
	System.out.println();
	System.out.println();

        System.out.println("Input");        
	System.out.println();
        System.out.println("Enter No of lines to Output");
	System.out.println();
        int N = sc.nextInt();
	System.out.println();
        System.out.println("Enter Origin");
	System.out.println();
        String O = sc.next();
        int avg = ca.car("cars_input1.txt","rough.txt", O);
        
        
        PrintWriter pw = new PrintWriter("Europe.txt");        
        
        BufferedReader br1 = new BufferedReader(new FileReader("rough.txt"));         
        String line = br1.readLine();  
        ArrayList<Float> num = new ArrayList<Float>(); 
        ArrayList<String> ls = new ArrayList<String>();

        int c=0, i=0;  

        while (line != null) 
        {
            String[] arr = line.split(",");
            num.add(Float.parseFloat(arr[2]));
            ls.add(line);
            c++;
            line = br1.readLine();
        } 
        
        Collections.sort(num, Collections.reverseOrder()); 
            
        for (float l : num)
        {
            while(i < c)
            {
                String line1 = ls.get(i);
                String[] arr = line1.split(",");                 
                if(l==(Float.parseFloat(arr[2])))
                {
                    pw.println(line1);
                    pw.flush();
                    ls.remove(line1);
                    break;
                }                 
                i++;            
            }
            i=0;             
        }         
        
        BufferedReader br2 = new BufferedReader(new FileReader("Europe.txt"));         
        String str2 = br2.readLine();
        int z=0;
        System.out.println();
	
	System.out.println("Output");

        while(z<N) {
            String[] ar = str2.split(",");
            int a = (int)Float.parseFloat(ar[2]);
            if(a>avg) {
		
		
		System.out.println();
                System.out.println(str2);
            }
            z++;
            str2 = br2.readLine();
        }

        br1.close();        
        br2.close();
        pw.close();
        System.out.println();
	}

}
        
