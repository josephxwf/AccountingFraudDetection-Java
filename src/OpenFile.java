import  java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;


public class OpenFile {

	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	StringBuilder sb2 = new StringBuilder();
	
	public void PickMe() throws Exception {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			//get the file
			java.io.File file = fileChooser.getSelectedFile();
			
			//create scanner for the file
			Scanner input = new Scanner(file);
		
			
			//read text from file
			
			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
				
			}
			
			input.close();
			
			Scanner input2 = new Scanner(file);
			SetReadWrite(input2); // read input data and process it 
			input2.close();
			
		}else{
			
			sb.append("No file was selected");
			
			
		}
		
		
	}
	
	
	
	public void SetReadWrite(Scanner br) {

 		try {
 			
 			// write data to dataRecord.ext
 			String fileName1 = "dataRecord.txt";
 			
 		// second parameter set to false will rewrite the text in the file, true will append new text in the file, FilwWriter() has the same property		
 			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName1,false)));
 			ReadWrite(br,bw1);
 	 		br.close();
 	 		bw1.close();
 		} catch (IOException e) {
			System.out.println(e.toString()); 			
 		}

	}


	

	// read data from data.txt file and read the counted data into dataRecord.txt file
	private void ReadWrite(Scanner br,BufferedWriter bw1) throws IOException {
   
		double total = 0;
		  int[] frequency = new int[10];   //from frequency[1] to frequency[9] count the number of appearance of 1 to 9 respectively
		  //String line =  br.nextLine();    // read each line from the textfile
		  //System.out.print (line);
		  while(br.hasNext()){
			  
		    String line =  br.nextLine();
			char[] charArray = line.toCharArray();      // convert a string line to character array
			 for(int i=0; i<charArray.length; ++i)
				 
			 {
				if(charArray[i] >='1' && charArray[i]<='9') // or if(Charcater.isDigit(charArray[i]) && charArray[i]!=0 )
					{
					++frequency[Character.getNumericValue(charArray[i])];
					++total;
				    break;
					}
			 }
			 
			 //line =  br.nextLine();
			 //System.out.print (line);
			 //System.out.print ("\n");
		  }
		    
		  for (int i = 1; i <= 9; i++)
		  {
			  
			  System.out.printf("%n%d  (%.3f%%)\t : ",i,frequency[i]/total*100);
			 
			  int starnumber= (int) Math.round(frequency[i]/total*100);   // long Math.round(double) or int  Math.round(float) --->round off decimal to integer
		  
		      for(int j=0; j <starnumber;j++ )
		    	  System.out.printf("*") ; 
		      
		      
		      try {
		    	  
		    	    sb2.append(String.format("%d  (%.3f%%)\t : ",i , frequency[i]/total*100 ));
		    	    for(int j=0; j <starnumber;j++ )
		    	    	sb2.append("*");
					sb2.append("\n");
					
					
					bw1.write(String.format("%d  (%.3f%%)\t : ",i , frequency[i]/total*100 )); // write data into dataRecord.txt file. use String.format() to align
					
					for(int j=0; j <starnumber;j++ )
						bw1.write("*");
					
					    bw1.newLine(); // write a newline character into the file.
				} catch (IOException e) {
					System.out.println(e.toString());
				}
		  }	 
			  
    	
	}

	
	
	
	
}
