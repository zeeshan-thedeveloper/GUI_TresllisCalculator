package application;


public class Gauss {
	Gauss(){
		
	}
	static void Create_Equations() {
		
	}
	static double[][] Create_Matrix_Of_Equation(Meta_Data_Holder data_Holder) {
		
		System.out.println("Creating nodes and bars ");
		// Here we will access node and the will check which type of node is this.
		
		// here we will check no of nodes first with respect to factor 3. 
		
		double[][] result = null;
		
		
		System.out.println("length is : "+data_Holder.getNode_Data().length);
		
		if(data_Holder.getNode_Data().length==3)
		{
			result = new double[6][6];
			System.out.println("when length is 3");
			int index=0;
			for(Node support : data_Holder.getNode_Data())
			{
				if(support.getTypeSupport()==0)
				{
					System.out.println("when support 1");
					
					/*
					 * R : 1
					 *  0 : cos(45). : T1
					 *  1 : 0 : T2
					 *  2 : 0 Rx:  T3
					 *  
					 * R : 2
					 *  0 : cos(-45) : T1
					 *  1 : 0 : T2
					 *  2 : R T3
					 * */
					
					
					//Single support
					
					//Row 1 fo s1
					
					result[index][0] = Math.sqrt(2)/2;
					result[index][1] = 0.0;
					result[index][2] = 0.0;
				
					
					//Row 2 fo s1
					
					index++;
					result[index][0] = (Math.sqrt(2)/2)*(-1);
					result[index][1] = 0.0;
					result[index][2] = -1.0;
					
					index++;
					
					
					
				}
				else if(support.getTypeSupport()==1)
				{
					// Double  support
					/*
					 * R : 1
					 *  0 : cos(3pi/4). : T1
					 *  1 : cos(-3pi/4) : T2
					 *  2 : 0 px:  T3
					 *  
					 * R : 2
					 *  0 : sin(3pi/4) : T1
					 *  1 : sin(-3pi/4) : T2
					 *  2 : px :  T3
					 * */
					
					System.out.println("when support 1");
					
					
					//Row 1 fo s1
					
					result[index][0] = (Math.sqrt(2)/2)*(-1);
					result[index][1] = (Math.sqrt(2)/2)*(-1);
					result[index][2] = 0.0;
				
					
					//Row 2 fo s1
					
					index++;
					result[index][0] = (Math.sqrt(2)/2)*(1);
					result[index][1] = (Math.sqrt(2)/2)*(-1);
					result[index][2] = 0.0;
					
					index++;
					
				}
				else 
				{
					//No support
				}
					
			}
			
			result[0][3]=1;
			result[0][4]=0;
			result[0][5]=0;
			
			result[1][3]=0;
			result[1][4]=1;
			result[1][5]=0;
			
			result[2][3]=0;
			result[2][4]=0;
			result[2][5]=1;
			
			result[3][3]=0;
			result[3][4]=0;
			result[3][5]=0;
			
			result[4][3]=0;
			result[4][4]=0;
			result[4][5]=0;
			
			result[5][3]=0;
			result[5][4]=0;
			result[5][5]=0;
			
			
			
			
		}
		else if(data_Holder.getNode_Data().length==6)
		{
			result = new double[12][12];
			
			for(Node support : data_Holder.getNode_Data())
			{
				if(support.getTypeSupport()==0)
				{
					//Single support
				}
				else if(support.getTypeSupport()==1)
				{
					// Double  support
				}
				else 
				{
					//No support
				}
					
			}
		}
		
		
		
		
		
		return result;
	}

	static double[] Create_Matrix_B(Meta_Data_Holder data_Holder) {
		
		double[] B = null;
		
		double[] p_value = calculatePx(data_Holder);
		
		double px = p_value[0];
		double py = p_value[1];
		
		
		if(data_Holder.getNode_Data().length==3)
		{
			B = new double[6];
			
			int index=0;
			
			for(Node support : data_Holder.getNode_Data())
			{
				if(support.getTypeSupport()==0)
				{
				
					//single support
					B[index]=0;
					
					index++;
					
					B[index]=0;
					
					index++;
					
				}
				else if(support.getTypeSupport()==1)
				{
					// Double  support
					B[index]=px*(-1);
					
					index++;
					
					B[index]=(py)*(-1);
					
					index++;
					
					
				}
				else 
				{
					//No support
				}
					
			}
			
			
			
			
			
		}
		else if(data_Holder.getNode_Data().length==6)
		{
			B = new double[12];
			
			for(Node support : data_Holder.getNode_Data())
			{
				if(support.getTypeSupport()==0)
				{
					//Single support
				}
				else if(support.getTypeSupport()==1)
				{
					// Double  support
				}
				else 
				{
					//No support
				}
					
			}
		}
		

		
		
		return B;		
	}
	
	
	static double[] calculatePx(Meta_Data_Holder obj)
	{
		double[] p_values = new double[2];
		
		p_values[0]=0.0F;//x
		p_values[0]=(1000.0F); //y
		
		return p_values;
	}
	static void finalAnswerCalculator(double Matrix1[][], double Matrix2[][]){
	
	        double inverted_matrix1[][] = invert(Matrix1);
	        int  p, q, c, d, k;
	        int m, n;
	         double sum = 0.0F; 
	         
	          m = inverted_matrix1.length;
	          n = inverted_matrix1[0].length;
	          

	          p = Matrix2.length;
	          q = Matrix2[0].length;
	     
	          double multiply[][] = new double[m][q];
	         
	          
	  
	          if (n != p)
	             System.out.println("The matrices can't be multiplied with each other.");
	          else
	          {
	     
	             for (c = 0; c < m; c++)
	             {
	                for (d = 0; d < q; d++)
	                {  
	                   for (k = 0; k < p; k++)
	                   {
	                      sum = sum + inverted_matrix1[c][k]*Matrix2[k][d];
	                   }
	     
	                   multiply[c][d] = sum;
	                   sum = 0;
	                }
	             }
	     
	             System.out.println("Product of the matrices:");
	     
	             for (c = 0; c < m; c++)
	             {
	                for (d = 0; d < q; d++)
	                   System.out.print(multiply[c][d]+"\t");
	     
	                System.out.print("\n");
	             }

	             
	        
	        
	    
	}
	}
	 public static double[][] invert(double a[][]) 
	    {
	        int n = a.length;
	        double x[][] = new double[n][n];
	        double b[][] = new double[n][n];
	        int index[] = new int[n];
	        for (int i=0; i<n; ++i) 
	            b[i][i] = 1;
	 
	 // Transform the matrix into an upper triangle
	        gaussian(a, index);
	 
	 // Update the matrix b[i][j] with the ratios stored
	        for (int i=0; i<n-1; ++i)
	            for (int j=i+1; j<n; ++j)
	                for (int k=0; k<n; ++k)
	                    b[index[j]][k]
	                    	    -= a[index[j]][i]*b[index[i]][k];
	 
	 // Perform backward substitutions
	        for (int i=0; i<n; ++i) 
	        {
	            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
	            for (int j=n-2; j>=0; --j) 
	            {
	                x[j][i] = b[index[j]][i];
	                for (int k=j+1; k<n; ++k) 
	                {
	                    x[j][i] -= a[index[j]][k]*x[k][i];
	                }
	                x[j][i] /= a[index[j]][j];
	            }
	        }
	        return x;
	    }
	 
	// Method to carry out the partial-pivoting Gaussian
	// elimination.  Here index[] stores pivoting order.
	 
	    public static void gaussian(double a[][], int index[]) 
	    {
	        int n = index.length;
	        double c[] = new double[n];
	 
	 // Initialize the index
	        for (int i=0; i<n; ++i) 
	            index[i] = i;
	 
	 // Find the rescaling factors, one from each row
	        for (int i=0; i<n; ++i) 
	        {
	            double c1 = 0;
	            for (int j=0; j<n; ++j) 
	            {
	                double c0 = Math.abs(a[i][j]);
	                if (c0 > c1) c1 = c0;
	            }
	            c[i] = c1;
	        }
	 
	 // Search the pivoting element from each column
	        int k = 0;
	        for (int j=0; j<n-1; ++j) 
	        {
	            double pi1 = 0;
	            for (int i=j; i<n; ++i) 
	            {
	                double pi0 = Math.abs(a[index[i]][j]);
	                pi0 /= c[index[i]];
	                if (pi0 > pi1) 
	                {
	                    pi1 = pi0;
	                    k = i;
	                }
	            }
	 
	   // Interchange rows according to the pivoting order
	            int itmp = index[j];
	            index[j] = index[k];
	            index[k] = itmp;
	            for (int i=j+1; i<n; ++i) 	
	            {
	                double pj = a[index[i]][j]/a[index[j]][j];
	 
	 // Record pivoting ratios below the diagonal
	                a[index[i]][j] = pj;
	 
	 // Modify other elements accordingly
	                for (int l=j+1; l<n; ++l)
	                    a[index[i]][l] -= pj*a[index[j]][l];
	            }
	        }
	    }
}
