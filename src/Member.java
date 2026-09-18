public record Member(String name, int medlemsnummer) {

    @Override
    public String toString(){
        return String.format("""
                %s, memberNR: %d""", name, medlemsnummer);
    }
}