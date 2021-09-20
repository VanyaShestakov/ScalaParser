package Parser;

public class Runner {
    public static void main(String[] args) {
        Parser parser = new Parser();

        //String s = "println(\"Hello, world!\"); println(\"Hello, world!\" + \"Hello, world!\");";

//        String s = "dcd(\"Hello, world!\"); println(\"Hello, world!\");";
//        Pattern pattern = Pattern.compile("^[A-Za-z]+\\({1}[\\w\\W]*\\){1};{1}$", Pattern.MULTILINE, Pattern.);
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//           // System.out.println();
//            //System.out.println(s.substring(matcher.start(), matcher.end())//);
//            System.out.println(matcher.group());
//        }
        //System.out.println(s.matches("^[A-Za-z]+\\({1}[A-Za-z1-9,\\s\"\"]*\\){1};{1}$"));
        parser.parseSourceCode();
        //s = setSubstitute(s);
        //System.out.println(s);
    }

}
