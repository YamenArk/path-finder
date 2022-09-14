public class Ariies {
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String WHITE = "\033[0;37m";   // WHITE

   
        String[][]MyArray;
        x_and_y car;
        int weight;
        boolean check_receive[];
        boolean check_Delivery[];
        int size1;
        int size2;
        int moving_number;
        
        

        public void MyArray(String MyArray[][],int size1,int size2,boolean check_receive[],boolean check_Delivery[],x_and_y car,int weight,int moving_number)
        {
            this.moving_number = moving_number;
            this.weight = weight;
            this.car = new x_and_y();
            this.car.x = car.x;
            this.car.y = car.y;
            this.size1 = size1;
            this.size2 = size2;
            this.MyArray=new String[size1][size2];
            this.check_receive = new boolean[size1];
            this.check_Delivery = new boolean[size2];
            for(int i=0;i<size1;i++)
            {
                for(int j=0;j<size2;j++)
                {
                    this.MyArray[i][j]=MyArray[i][j];
                }
            }
            for(int i=0;i<check_receive.length;i++)
            {
                this.check_receive[i]=check_receive[i];
                this.check_Delivery[i]=check_Delivery[i];
            }
                
        }
        public void printl()
        {
            for(int i=0;i<size1;i++)
            {
                for(int j=0;j<size2;j++)
                {
                    System.out.print(this.MyArray[i][j]+"\t\t");
                }
                System.out.println("\n");
            } 
            System.out.println("weight is "+this.weight);
            System.out.println("------------------------------------");
        }
    }