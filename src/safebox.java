public class safebox extends boxes{
    int mineAround;
    public safebox(int x, int y, int mineAround) {
        super(x, y);
        this.mineAround  = mineAround;
    }

    public int getMineAround() {
        return mineAround;
    }

    public void setMineAround(int mineAround) {
        this.mineAround = mineAround;
    }
}