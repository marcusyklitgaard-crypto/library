public record Book (String author, String title, String isbn, int id) {

    @Override
    public String toString(){
        return String.format("""
                Author: %s
                Title: %s
                isbn: %s
                id: %d
                """,author, title, isbn, id);
    }
}
