public class Quine {

    private static String escape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\n') {
                sb.append("\\n");
            } else if (c == '\t') {
                sb.append("\\t");
            } else if (c == '\'') {
                sb.append("\\'");
            } else if (c == '"') {
                sb.append("\\\"");
            } else if (c == '\\') {
                sb.append("\\\\");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String getCode() {
        String s = "$";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '$') {
                s = s.substring(0, i) + escape(s) + s.substring(i + 1);
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(getCode());
    }
}