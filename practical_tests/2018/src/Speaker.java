public class Speaker extends User{
    private int fee;

    public Speaker(String name, int age) {
        super(name, age);
        this.fee = 0;
    }

    public Speaker(String name) {
        this(name, 0);
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + getFee() + ".";
    }
}
