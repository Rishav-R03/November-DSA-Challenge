public class AnotherQ {
    public static String processTicket(String TicketNumber) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < TicketNumber.length()) {
            if (i + 1 < TicketNumber.length() && TicketNumber.substring(i, i + 2).equals("EF")) {
                i += 2;
            } else if (TicketNumber.charAt(i) != 'G') {
                result.append(TicketNumber.charAt(i));
                i++;
            } else {
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String ans = processTicket("FJOJEFE332G");
        System.out.println(ans);
    }
}