import java.util.Objects;

class Article implements Comparable<Article> {

    private final String title;
    private final int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        // If the sizes don't equal, return size comparison.
        int sizeComparison = Integer.compare(size, otherArticle.size);
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        // If sizes equal, compare title.
        return CharSequence.compare(title, otherArticle.title);
    }
}
