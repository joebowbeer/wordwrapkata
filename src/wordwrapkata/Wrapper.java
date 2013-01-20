package wordwrapkata;

public class Wrapper {

    private final StringBuilder sb;
    private final int cols;

    public static String wrap(String s, int cols) {
        return new Wrapper(s, cols).wrap(0);
    }

    public Wrapper(String s, int cols) {
        this.sb = new StringBuilder(s != null ? s : "");
        if (cols <= 0) {
            throw new IllegalArgumentException(String.valueOf(cols));
        }
        this.cols = cols;
    }

    public String wrap(int index) {
        int wrapColumn = index + cols;
        if (sb.length() <= wrapColumn) {
            return sb.toString();
        }
        int space = sb.lastIndexOf(" ", wrapColumn);
        if (space != -1) {
            wrapColumn = space;
            sb.setCharAt(wrapColumn, '\n');
        } else {
            sb.insert(wrapColumn, '\n');
        }
        return wrap(++wrapColumn);
    }
}
