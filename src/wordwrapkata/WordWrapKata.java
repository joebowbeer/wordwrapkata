package wordwrapkata;

import static wordwrapkata.Wrapper.wrap;

public class WordWrapKata {

    public static void main(String[] args) {
        System.out.println(wrap(args[0], Integer.valueOf(args[1])));
    }
}
