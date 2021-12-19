package pieces;

public enum Alliance {
    White{
        @Override
        public int getDirection(){
            return -1;
        }

        @Override
        public boolean isW() {
            return true;
        }

        @Override
        public boolean isB() {
            return false;
        }
    },
    Black{
        @Override
        public int getDirection(){
            return 1;
        }

        @Override
        public boolean isW() {
            return false;
        }

        @Override
        public boolean isB() {
            return true;
        }
    };
    public abstract int getDirection();
    public abstract boolean isW();
    public abstract boolean isB();

}

