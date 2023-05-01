public class Mines extends boxes {

    private boolean status;
    public Mines(int x, int y) {
        super(x, y);
        status = false;
    }
    public boolean getstatus(){
        return this.status;
    }
}
