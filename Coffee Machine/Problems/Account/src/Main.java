class Account {
    Long balance;
    String ownerName;
    boolean locked;

    public Account(Long balance, String ownerName, boolean locked) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.locked = locked;
    }
}