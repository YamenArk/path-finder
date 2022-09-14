import java.util.Queue;
import java.util.PriorityQueue;
import java.util.*;
import java.util.LinkedList;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;


class State_Space {
  

    public static int counter=0;
    public static int size1=0;
    public static int size2=0;
    public static int numbers_of_out_from_queue = 0;
    public static boolean the_end=false;
    public static x_and_y the_first_piont;
    public static int numbers_of_bulding;


    public static boolean check_if_can_move(int size1,int size2, int x1,int y1,boolean [][]moving_boleean)
    {
        if(x1 < size1 && x1> -1 && y1 < size2 && y1 > -1)
        {
            if(moving_boleean[x1][y1] != true)
            {
                moving_boleean[x1][y1] = true;
                return true;
            }
        }

        return false;
    }
    ///////////////////////////////





    public static void making_the_array_ready(Ariies []states,int real_father)
    {
        counter ++;               
        states[counter] = new Ariies(); 
        states[counter].MyArray(states[real_father].MyArray, states[real_father].size1, states[real_father].size2, states[real_father].check_receive, states[real_father].check_Delivery, states[real_father].car, states[real_father].weight,states[real_father].moving_number);
        
    }
    ////////////////////////////////////////////////////




    public static x_and_y[] getting_the_car_back(Ariies []states,x_and_y []bulding)
    {
        x_and_y []path = new x_and_y[ size1* size2];
        int second_counter = 0;
        path[0] = new x_and_y();
        path[0].x = states[counter].car.x;
        path[0].y = states[counter].car.y;

        moving_arrie []moving = new moving_arrie [400000];
        boolean can_move;

        int x1;
        int y1;
        Queue<Integer> q  = new LinkedList<>();
       boolean [][]moving_boleean = new boolean[size1][size2];



       for(int j=0;j<numbers_of_bulding ; j++)
       {
        x1 = bulding[j].x;
        y1 = bulding[j].y;
        moving_boleean[x1][y1]=true;
       }

        int real_father;

        moving[second_counter] = new moving_arrie();   
        moving[second_counter].MyArray( size1, size2, states[counter].car,path);
        moving_boleean[moving[second_counter].right_position.x][moving[second_counter].right_position.y] = true;

       q.add(second_counter);
       


       while(  !q.isEmpty() )
       {

            real_father = q.remove();

            if (moving[real_father].right_position.x == the_first_piont.x && moving[real_father].right_position.y == the_first_piont.y)
            {
                states[counter].car.x = the_first_piont.x;
                states[counter].car.y = the_first_piont.y;

                return moving[real_father].path;
            }
            
            x1 = moving[real_father].right_position.x + 1;
            y1 = moving[real_father].right_position.y;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;

                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;


                q.add(second_counter);

            }



            x1 = moving[real_father].right_position.x - 1;
            y1 = moving[real_father].right_position.y;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray(size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                  while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }


            x1 = moving[real_father].right_position.x;
            y1 = moving[real_father].right_position.y + 1;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }


            x1 = moving[real_father].right_position.x;
            y1 = moving[real_father].right_position.y - 1;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }   
       }

       return moving[2].path;

    }



    ////////////////////////////////////////////////////








    public static x_and_y[] weight_for_receive_and_delevary(Ariies []states,x_and_y []receive,int i,x_and_y []bulding)
    {
        x_and_y []path = new x_and_y[ size1* size2];
        int second_counter = 0;
        path[0] = new x_and_y();
        path[0].x = states[counter].car.x;
        path[0].y = states[counter].car.y;

        moving_arrie []moving = new moving_arrie [400000];
        boolean can_move;

        int x1;
        int y1;
        Queue<Integer> q  = new LinkedList<>();
       boolean [][]moving_boleean = new boolean[size1][size2];



       for(int j=0;j<numbers_of_bulding ; j++)
       {
        x1 = bulding[j].x;
        y1 = bulding[j].y;
        moving_boleean[x1][y1]=true;
       }

        int real_father;

        moving[second_counter] = new moving_arrie();   
        moving[second_counter].MyArray( size1, size2, states[counter].car,path);
        moving_boleean[moving[second_counter].right_position.x][moving[second_counter].right_position.y] = true;

       q.add(second_counter);
       


       while(  !q.isEmpty() )
       {

            real_father = q.remove();

            if (moving[real_father].right_position.x == receive[i].x && moving[real_father].right_position.y == receive[i].y)
            {
                states[counter].car.x = receive[i].x;
                states[counter].car.y = receive[i].y;

                return moving[real_father].path;
            }
            
            x1 = moving[real_father].right_position.x + 1;
            y1 = moving[real_father].right_position.y;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;

                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;


                q.add(second_counter);

            }



            x1 = moving[real_father].right_position.x - 1;
            y1 = moving[real_father].right_position.y;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray(size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                  while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }


            x1 = moving[real_father].right_position.x;
            y1 = moving[real_father].right_position.y + 1;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }


            x1 = moving[real_father].right_position.x;
            y1 = moving[real_father].right_position.y - 1;
            can_move = check_if_can_move(size1, size2, x1, y1, moving_boleean);
            if(can_move)
            {
                second_counter ++;               
                moving[second_counter] = new moving_arrie();   
                moving[second_counter].MyArray( size1, size2, moving[real_father].right_position,moving[real_father].path);
                moving[second_counter].right_position.x = x1;
                moving[second_counter].right_position.y = y1;
                int ff=0;
                while(moving[real_father].path[ff] != null)
                {
                    ff++;
                }
                moving[second_counter].path[ff] = new x_and_y();
                moving[second_counter].path[ff].x = x1;
                moving[second_counter].path[ff].y = y1;
                q.add(second_counter);
            }   
       }
       return path;

    }
    ///////////////////////////////////////////////////


    public static void get_on_next(Ariies []states,int real_father,x_and_y []receive ,x_and_y []Delivery,x_and_y []bulding, Queue<Arrie> ArrieePriorityQueue)
    { 
        int final_check = 0;
        int numbers_of_holding_iteams = 1;
        for(int i =0;i<receive.length ; i++)
        {
            if(states[real_father].check_receive[i] == true && states[real_father].check_Delivery[i] != true)
            {
                numbers_of_holding_iteams ++;
            }
        }

        for(int i =0;i<receive.length ; i++)
        {
            if(states[real_father].check_receive[i] != true )
            {
                int weight = 0;
                making_the_array_ready(states, real_father);
                x_and_y []path = new x_and_y[ size1* size2];
                path = weight_for_receive_and_delevary(states, receive, i, bulding); 
                int ff=1;
                int moving_number = states[counter].moving_number + 1;
                while(path[ff] != null)
                {
                    weight ++;
                    if(states[counter].MyArray[path[ff].x][path[ff].y].equals("."))
                    {

                        states[counter].MyArray[path[ff].x][path[ff].y] =  Integer.toString(moving_number);
                    }
                    else
                    {
                        states[counter].MyArray[path[ff].x][path[ff].y] =  states[counter].MyArray[path[ff].x][path[ff].y] +"/" + Integer.toString(moving_number);
                    }
                    moving_number ++;
                    ff++;
                }
                ff--;
                states[counter].MyArray[path[ff].x][path[ff].y] =  states[counter].MyArray[path[ff].x][path[ff].y] +"/+";
                states[counter].moving_number = states[counter].moving_number + weight ;
                states[counter].weight = states[counter].weight + weight * numbers_of_holding_iteams;
                states[counter].check_receive[i] = true;
                states[counter].printl();
                
                ArrieePriorityQueue.add(new Arrie(counter, states[counter].weight));
            }
            else if(states[real_father].check_Delivery[i] != true)
            {
                int weight = 0;
                making_the_array_ready(states, real_father);
                x_and_y []path = new x_and_y[ size1* size2];
                path = weight_for_receive_and_delevary(states, Delivery, i, bulding); 
                int ff=1;
                int moving_number = states[counter].moving_number + 1;
                while(path[ff] != null)
                {
                    weight ++;
                    if(states[counter].MyArray[path[ff].x][path[ff].y].equals("."))
                    {

                        states[counter].MyArray[path[ff].x][path[ff].y] =  Integer.toString(moving_number);
                    }
                    else
                    {
                        states[counter].MyArray[path[ff].x][path[ff].y] =  states[counter].MyArray[path[ff].x][path[ff].y] +"/" + Integer.toString(moving_number);
                    }
                    moving_number ++;
                    ff++;
                }
                ff--;
                states[counter].MyArray[path[ff].x][path[ff].y] =  states[counter].MyArray[path[ff].x][path[ff].y] +"/-";
                states[counter].weight = states[counter].weight + weight * numbers_of_holding_iteams;
                states[counter].moving_number = states[counter].moving_number + weight ;
                states[counter].check_Delivery[i] = true;
                states[counter].printl();
                ArrieePriorityQueue.add(new Arrie(counter, states[counter].weight));
            }
            else 
            {
                final_check ++;
            }
            
         
        }
        if(final_check == receive.length)
        {
            int weight = 0;
            making_the_array_ready(states, real_father);
            x_and_y []path = new x_and_y[ size1* size2];
            path = getting_the_car_back(states,bulding);

            int ff=1;
            int moving_number = states[counter].moving_number + 1;
            while(path[ff] != null)
            {
                weight ++;
                if(states[counter].MyArray[path[ff].x][path[ff].y].equals("."))
                {

                    states[counter].MyArray[path[ff].x][path[ff].y] =  Integer.toString(moving_number);
                }
                else
                {
                    states[counter].MyArray[path[ff].x][path[ff].y] =  states[counter].MyArray[path[ff].x][path[ff].y] +"/" + Integer.toString(moving_number);
                }
                moving_number ++;
                ff++;
            }
            states[counter].moving_number = states[counter].moving_number + weight ;
            states[counter].weight = states[counter].weight + weight * numbers_of_holding_iteams;
            states[counter].printl();

            the_end = true;
            return ;
        }
    }


    ////////////////////////////////////

    public static void ucs(Ariies []states,x_and_y []receive ,x_and_y []Delivery,x_and_y []bulding)
    {   
      
        PriorityQueue<Arrie> ArrieePriorityQueue = new PriorityQueue<>();
        ArrieePriorityQueue.add(new Arrie(counter, 0));
        int real_father = 0 ;
        Arrie the_lowest = new Arrie();
      
      
        while (!ArrieePriorityQueue.isEmpty()) 
        {
            the_lowest= ArrieePriorityQueue.remove();
            numbers_of_out_from_queue ++;
            real_father= the_lowest.id;
            System.out.println("we have choose");
            states[real_father].printl();
            get_on_next(states, real_father, receive, Delivery,bulding, ArrieePriorityQueue);
            if (the_end)
            {
                return ;
            }




        }
    }



    /////////////////////////////
    
    public static List<String> readFileInList(String fileName)
    {

    List<String> lines = Collections.emptyList();
    try
    {
        lines =
        Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    catch (IOException e)
    {

        // do something
        e.printStackTrace();
    }
    return lines;
    }

    /////////////////////////////////////////






    public static void main(String[] args) {

        
        String reading= new String();
        x_and_y []bulding = null;
        int numbers_of_package = 0;
        x_and_y car = new x_and_y();
        the_first_piont = new x_and_y();
        x_and_y []receive = null ;
        x_and_y []Delivery = null ;

        List l = readFileInList("C:\\Users\\ASUS\\Desktop\\tests\\test.txt");
    
        Iterator<String> itr = l.iterator();
        reading = itr.next();
        size1 = Integer.parseInt(reading);
        reading = itr.next();
        size2 = Integer.parseInt(reading);
        

        String [][] MyArray = new String [size1][size2];
        MyArray [0][0] = ".";

        for (int i=0;i<size1;i++)
        {
            for (int j=0;j<size2;j++)
            {
                MyArray[i][j]=".";            
            }
        }

        reading = itr.next();

        while(itr.hasNext())
        {
            if( reading.equals("car"))
            {
                reading = itr.next();       
               car.x = Integer.parseInt(reading);

               reading = itr.next();
               car.y = Integer.parseInt(reading);
               the_first_piont.x = car.x;
               the_first_piont.y = car.y;
               MyArray[car.x][car.y] = "T";
               reading = itr.next();
            }
            else if(reading.equals("bulding"))
            {
                reading = itr.next();
                int x;
                int y;
                numbers_of_bulding= Integer.parseInt(reading);
                bulding = new x_and_y[numbers_of_bulding];
                for(int i = 0; i < numbers_of_bulding ; i++)
                {
                    reading = itr.next();
                    x = Integer.parseInt(reading);
                    reading = itr.next();
                    y = Integer.parseInt(reading);

                    bulding[i] = new x_and_y();
                    bulding[i].x = x;
                    bulding[i].y = y;

                    MyArray[x][y] = "#" ;
                } 
                reading = itr.next();
            }
            else if(reading.equals("package"))
            {
                reading = itr.next();
                int x;
                int y;   
                numbers_of_package= Integer.parseInt(reading);
                receive = new x_and_y[numbers_of_package];
                Delivery = new x_and_y[numbers_of_package];
                for(int i = 0; i < numbers_of_package ; i++)
                {
                    
                    receive[i] = new x_and_y();
                    Delivery[i] = new x_and_y();

                    reading = itr.next();
                    x = Integer.parseInt(reading);
                    reading = itr.next();
                    y = Integer.parseInt(reading);

                    receive[i].x = x ;
                    receive[i].y = y ;
                    MyArray[x][y] = "P"+i;
                   

                    reading = itr.next();
                    x = Integer.parseInt(reading);
                    reading = itr.next();
                    y = Integer.parseInt(reading);

                    Delivery[i].x = x ;
                    Delivery[i].y = y ;
                    MyArray[x][y] = "D"+i;
                } 
            }
         
        }

        boolean []check_receive = new boolean[numbers_of_package];
        boolean []check_Delivery = new boolean[numbers_of_package];
        
        Ariies []states = new Ariies [400000];
        states[counter] = new Ariies();
        states[counter].MyArray(MyArray, size1, size2, check_receive, check_Delivery, car,0,0);
        states[counter].printl();
        

        ucs(states, receive, Delivery, bulding);

        
       System.out.println("numbers of out from queue are :"+numbers_of_out_from_queue);
    }
}