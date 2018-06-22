class strings {
    public static void main(String args[]) {
        String s1 = "abc";
        StringBuffer sb = new StringBuffer(s1);
        System.out.println(sb);
        System.out.println(sb.reverse());
        s1 = sb.reverse();
    }
}
