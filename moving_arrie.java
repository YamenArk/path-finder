public class moving_arrie {
        x_and_y right_position;
        int size1;
        int size2;
        x_and_y []path;
        

        public void MyArray(int size1,int size2,x_and_y right_position,x_and_y []path)
        {
            
            this.right_position = new x_and_y();
            this.right_position.x = right_position.x;
            this.right_position.y = right_position.y;
            this.size1 = size1;
            this.size2 = size2;
            this.path = new x_and_y[size1 * size2];

            int ff=0;
            while(path[ff] != null)
            {
                this.path[ff] = new x_and_y();
                this.path[ff].x = path[ff].x;
                this.path[ff].y = path[ff].y;
                ff++;
            }
        }
    
}
