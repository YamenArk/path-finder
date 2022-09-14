class Arrie implements Comparable<Arrie> {
    int id;
    private int  distance;

    public Arrie() {

    }

    public Arrie(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int  getdistance() {
        return distance;
    }

    public void setdistance(int  distance) {
        this.distance = distance;
    }



    // Compare two employee objects by their distance
    @Override
    public int compareTo(Arrie arrie) {
        if(this.getdistance() > arrie.getdistance()) {
            return 1;
        } else if (this.getdistance() < arrie.getdistance()) {
            return -1;
        } else {
            return 0;
        }
    }
}
