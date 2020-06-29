class Problem {

    public static void main(String[] args) {
        boolean isParam = true;
        for (String a : args) {
            if (isParam) {
                System.out.print(a + "=");
            } else {
                System.out.println(a);
            }
            isParam = !isParam;
        }
    }
}